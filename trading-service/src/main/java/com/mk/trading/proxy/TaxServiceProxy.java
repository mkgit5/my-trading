package com.mk.trading.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mk.trading.common.dto.TaxDto;

//Use below line when using microservices alone
//@FeignClient(name = "tax-service", url = "http://localhost:8100/tax-service")

//Use below line when using microservices, naming service & api-gateway (but no docker and no kubernetes)
@FeignClient(name = "tax-service")

//Use below line when using docker and kubernetes and default environment variable <application-name>_SERVICE_HOST
//@FeignClient(name = "tax-service", url = "${TAX-SERVICE_SERVICE_HOST:http://localhost}:8100")

//Use below line when using docker and kubernetes and custom environment variable TAX_SERVICE_URI
//@FeignClient(name = "tax-service", url = "${TAX_SERVICE_URI:http://localhost}:8100")
public interface TaxServiceProxy {

	@GetMapping("/tax-service/{taxId}")
	public TaxDto fetchTradingTax(@PathVariable Long taxId);

}
