package com.mk.trading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mk.trading.common.dto.StockDto;
import com.mk.trading.common.dto.StockOrderDto;
import com.mk.trading.common.dto.TaxDto;
import com.mk.trading.service.TradingService;

@RestController
public class TradingController {

	@Autowired
	private TradingService tradingService;

	@GetMapping
	public List<StockDto> fetchAllStocks() {
		return tradingService.fetchAllStocks();
	}

	@GetMapping(value = "/{purchaseId}")
	public StockDto fetchStockByPurchaseId(@PathVariable Long purchaseId) {
		return tradingService.fetchStockByPurchaseId(purchaseId);
	}

	@PutMapping(value = "/{purchaseId}")
	public StockOrderDto sellStockByPurchaseId(@PathVariable Long purchaseId,
			@RequestBody StockOrderDto stockOrderDto) {
		return tradingService.sellStockByPurchaseId(purchaseId, stockOrderDto);
	}
	
	@GetMapping("/tax/{taxId}")
	public TaxDto fetchTax(@PathVariable Long taxId) {
		return tradingService.fetchTax(taxId);
	}

}
