package com.mk.trading.common.dto;

import java.math.BigDecimal;

public class StockOrderDto {

	private Long id;
	private Long purchaseId;
	private Long sellQuantity;
	private BigDecimal sellPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Long getSellQuantity() {
		return sellQuantity;
	}

	public void setSellQuantity(Long sellQuantity) {
		this.sellQuantity = sellQuantity;
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

}
