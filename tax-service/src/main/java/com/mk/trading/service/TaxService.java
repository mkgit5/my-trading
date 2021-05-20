package com.mk.trading.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.trading.domain.Tax;
import com.mk.trading.dto.TaxDto;
import com.mk.trading.repository.TaxRepository;

@Service
public class TaxService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TaxRepository taxRepo;

	public TaxDto fetchTradingTax(Long taxId) {
		logger.info("Fetching trading tax");
		Optional<Tax> taxOpt = taxRepo.findById(taxId);

		TaxDto tax = null;
		if (taxOpt.isPresent()) {
			logger.info("Processing tax details");
			Tax taxDomain = taxOpt.get();
			tax = new TaxDto(taxDomain.getId(), taxDomain.getIgst(), taxDomain.getCgst(), taxDomain.getSgst());
		}

		logger.info("TAX={}", tax != null ? tax.toString() : "");
		return tax;
	}

}
