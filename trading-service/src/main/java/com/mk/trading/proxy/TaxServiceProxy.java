package com.mk.trading.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mk.trading.common.dto.TaxDto;

//Use below line when no docker/kubernetes is used
@FeignClient(name = "tax-service", url = "http://localhost:8100/tax-service")
// Use below line when using docker without kubernetes
//@FeignClient(name = "tax-service", url = "http://localhost:8100")
// Use below line when using docker and kubernetes
//@FeignClient(name = "tax-service", url = "${TAX_SERVICE_SERVICE_HOST:http://localhost}:8100")
public interface TaxServiceProxy {

	@GetMapping("/{taxId}")
	public TaxDto fetchTradingTax(@PathVariable Long taxId);

}
