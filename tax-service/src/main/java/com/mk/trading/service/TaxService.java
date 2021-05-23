package com.mk.trading.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.trading.domain.Tax;
import com.mk.trading.dto.TaxDto;
import com.mk.trading.repository.TaxRepository;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class TaxService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TaxRepository taxRepo;

	@CircuitBreaker(name = "trading-tax", fallbackMethod = "fallbackTaxDetails")
	@Retry(name = "trading-tax", fallbackMethod = "fallbackTaxDetails")
	@RateLimiter(name = "trading-tax")
	@Bulkhead(name = "trading-tax")
	public TaxDto fetchTradingTax(Long taxId) {
		logger.info("Fetching trading tax");

		// Uncomment below line for testing Circuit-Breaker and Retry features
		// new RestTemplate().getForEntity("http://dummy-test", String.class);

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


	public TaxDto fallbackTaxDetails(Long taxId, Exception ex) {
		return new TaxDto(taxId, BigDecimal.valueOf(10), BigDecimal.valueOf(5),
				BigDecimal.valueOf(5));
	}

}
