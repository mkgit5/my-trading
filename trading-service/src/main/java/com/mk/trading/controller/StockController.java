package com.mk.trading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mk.trading.common.dto.StockDto;
import com.mk.trading.common.dto.StockOrderDto;
import com.mk.trading.common.dto.TaxDto;
import com.mk.trading.service.StockService;

@RestController
public class StockController {

	@Autowired
	private StockService stockService;

	@PostMapping(value = "/stock")
	public StockDto buyStock(@RequestBody StockDto stockDto) {
		return stockService.buyStock(stockDto);
	}

	@GetMapping(value = "/stock")
	public List<StockDto> fetchAllStocks() {
		return stockService.fetchAllStocks();
	}

	@GetMapping(value = "/stock/{purchaseId}")
	public List<StockDto> fetchStockByPurchaseId(@PathVariable(required = false) Long purchaseId) {
		return stockService.fetchStockByPurchaseId(purchaseId);
	}

	@PutMapping(value = "/stock/{purchaseId}")
	public StockOrderDto sellStockByPurchaseId(@PathVariable Long purchaseId,
			@RequestBody StockOrderDto stockOrderDto) {
		return stockService.sellStockByPurchaseId(purchaseId, stockOrderDto);
	}

	@GetMapping("/tax/{taxId}")
	public TaxDto fetchTaxTesting(@PathVariable Long taxId) {
		return stockService.fetchTax(taxId);
	}

}
