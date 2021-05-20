package com.mk.trading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.mk.trading" })
public class TaxApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxApplication.class, args);
	}

}
