package com.mk.trading.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.trading.common.domain.Stock;
import com.mk.trading.common.domain.StockOrder;
import com.mk.trading.common.dto.StockDto;
import com.mk.trading.common.dto.StockOrderDto;
import com.mk.trading.common.dto.TaxDto;
import com.mk.trading.proxy.TaxServiceProxy;
import com.mk.trading.repository.TradingRepository;

@Service
public class TradingService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TradingRepository tradingRepo;

	@Autowired
	private TaxServiceProxy taxServiceProxy;

	public List<StockDto> fetchAllStocks() {

		logger.info("Fetching all stocks");

		final List<Stock> stocks = tradingRepo.findAll();

		final List<StockDto> result = this.populateStocks(stocks);

		logger.info("STOCKS=", result);
		return result;
	}

	public StockDto fetchStockByPurchaseId(Long purchaseId) {
		logger.info("{}={} - {}", "MESSAGE", "Fetching stock", purchaseId);
		final Optional<Stock> stockOpt = tradingRepo.findById(purchaseId);

		StockDto stockDto = null;
		if (stockOpt.isPresent()) {
			final List<Stock> stocks = new ArrayList<>();
			stocks.add(stockOpt.get());

			List<StockDto> stockDtos = this.populateStocks(stocks);
			if (!stockDtos.isEmpty()) {
				stockDto = stockDtos.get(0);
			}
		}

		logger.info("STOCK=", stockDto != null ? stockDto.toString() : "NULL");
		return stockDto;
	}

	public StockOrderDto sellStockByPurchaseId(Long purchaseId, StockOrderDto stockOrderDto) {

		logger.info("Fetching stock - {}", purchaseId);

		final Optional<Stock> stockOpt = tradingRepo.findById(purchaseId);

		if (stockOpt.isPresent()) {
			final Stock stock = stockOpt.get();

			logger.info("{}={}", "MESSAGE", "Checking whether any stocks available to sell");
			final Optional<Long> sellQty = stock.getStockOrders().stream().map(m -> m.getSellQuantity())
					.reduce(Long::sum);
			if (sellQty.isPresent()) {
				if ((sellQty.get() + stockOrderDto.getSellQuantity()) > stock.getBuyQuantity()) {
					throw new RuntimeException("No stocks found to sell or invalid request");
				}
			}

			logger.info("{}={}", "MESSAGE", "Fetching tax rates");
			final TaxDto tradingTax = taxServiceProxy.fetchTradingTax(1L);
			logger.info("{}={}", "TAX", tradingTax);

			final BigDecimal igst = tradingTax.getIgst();
			stock.setTaxRate(igst);

			final BigDecimal sellValue = stockOrderDto.getSellPrice()
					.multiply(BigDecimal.valueOf(stockOrderDto.getSellQuantity()));
			final BigDecimal taxValue = sellValue.multiply(igst);

			Optional<BigDecimal> previousSellValue = stock.getStockOrders().stream().map(m -> m.getSellValue())
					.reduce(BigDecimal::add);

			if (previousSellValue.isPresent()) {
				BigDecimal previousSellValueMinusTax = previousSellValue.get().subtract(stock.getTaxDeducted());
				final BigDecimal profitLoss = previousSellValueMinusTax.add(sellValue.subtract(taxValue))
						.subtract(stock.getBuyValue());
				stock.setProfitLoss(profitLoss);
			} else {
				final BigDecimal profitLoss = sellValue.subtract(taxValue).subtract(stock.getBuyValue());
				stock.setProfitLoss(profitLoss);
			}

			final BigDecimal taxDeducted = stock.getTaxDeducted() != null ? taxValue.add(stock.getTaxDeducted())
					: taxValue;
			stock.setTaxDeducted(taxDeducted);

			final StockOrder stockOrder = new StockOrder();
			stockOrder.setSellQuantity(stockOrderDto.getSellQuantity());
			stockOrder.setSellPrice(stockOrderDto.getSellPrice());
			stockOrder.setSellValue(sellValue);
			stockOrder.setSoldDate(Calendar.getInstance().getTime());
			stockOrder.setStock(stock);
			stock.getStockOrders().add(stockOrder);

			tradingRepo.save(stock);
			logger.info("Persisting stock order");

			stockOrderDto.setId(stock.getStockOrders().get(0).getId());
			stockOrderDto.setPurchaseId(stock.getId());
		}

		logger.info("STOCK_ORDER=", stockOrderDto != null ? stockOrderDto.toString() : "NULL");
		return stockOrderDto;
	}

	public TaxDto fetchTax(Long taxId) {
		logger.info("Fetch tax informtation");

		final Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("taxId", taxId.toString());

//		final ResponseEntity<TaxDto> responseEntity = new RestTemplate()
//				.getForEntity("http://localhost:8100/tax-service/{taxId}", TaxDto.class, uriVariables);
//		return responseEntity.getBody();

		final TaxDto tradingTax = taxServiceProxy.fetchTradingTax(taxId);
		logger.info("TAX={}", tradingTax);

		return tradingTax;
	}

	private List<StockDto> populateStocks(final List<Stock> stocks) {
		List<StockDto> result = new ArrayList<>();
		for (Stock p : stocks) {
			Long sellQty = 0L;
			BigDecimal sellValue = BigDecimal.ZERO;

			for (StockOrder s : p.getStockOrders()) {
				sellQty = sellQty + s.getSellQuantity();
				sellValue = sellValue.add(s.getSellValue());
			}

			BigDecimal avgSellPrice = null;
			BigDecimal profitLoss = null;
			BigDecimal netProfitLoss = null;

			if (!sellQty.equals(0L)) {
				avgSellPrice = sellValue.divide(BigDecimal.valueOf(sellQty));
				profitLoss = sellValue.subtract(p.getBuyValue());
				netProfitLoss = profitLoss.subtract(p.getTaxDeducted());
			} else {
				sellQty = null;
				sellValue = null;
			}

			result.add(new StockDto(p.getId(), p.getStock(), p.getBuyQuantity(), p.getBuyPrice(), p.getBuyValue(), null,
					sellQty, avgSellPrice, sellValue, profitLoss, p.getTaxDeducted(), p.getTaxRate(), netProfitLoss,
					null));

		}
		return result;
	}

}
