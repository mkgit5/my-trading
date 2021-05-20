package com.mk.trading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mk.trading.dto.TaxDto;
import com.mk.trading.service.TaxService;

@RestController
public class TaxController {

	@Autowired
	private TaxService taxService;

	@GetMapping(value = "/{taxId}")
	public TaxDto fetchTradingTax(@PathVariable Long taxId) {
		return taxService.fetchTradingTax(taxId);
	}

}
