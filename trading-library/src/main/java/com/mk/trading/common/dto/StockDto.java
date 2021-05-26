package com.mk.trading.common.dto;

import java.math.BigDecimal;
import java.util.Date;

public class StockDto {
	private Long id;
	private String stock;
	private Long buyQuantity;
	private BigDecimal buyPrice;
	private BigDecimal buyValue;
	private Date purchaseDate;
	private Long sellQuantity;
	private BigDecimal sellPrice;
	private BigDecimal sellValue;
	private BigDecimal profitLoss;
	private BigDecimal taxDeducted;
	private BigDecimal taxRate;
	private BigDecimal netProfitLoss;
	private Date soldDate;

	public StockDto() {
	}

	public StockDto(Long id, String stock, Long buyQuantity, BigDecimal buyPrice, BigDecimal buyValue,
			Date purchaseDate, Long sellQuantity, BigDecimal sellPrice, BigDecimal sellValue, BigDecimal profitLoss,
			BigDecimal taxDeducted, BigDecimal taxRate, BigDecimal netProfitLoss, Date soldDate) {
		super();
		this.id = id;
		this.stock = stock;
		this.buyQuantity = buyQuantity;
		this.buyPrice = buyPrice;
		this.buyValue = buyValue;
		this.purchaseDate = purchaseDate;
		this.sellQuantity = sellQuantity;
		this.sellPrice = sellPrice;
		this.sellValue = sellValue;
		this.profitLoss = profitLoss;
		this.taxDeducted = taxDeducted;
		this.taxRate = taxRate;
		this.netProfitLoss = netProfitLoss;
		this.soldDate = soldDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Long getBuyQuantity() {
		return buyQuantity;
	}

	public void setBuyQuantity(Long buyQuantity) {
		this.buyQuantity = buyQuantity;
	}

	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

	public BigDecimal getBuyValue() {
		return buyValue;
	}

	public void setBuyValue(BigDecimal buyValue) {
		this.buyValue = buyValue;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
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

	public BigDecimal getSellValue() {
		return sellValue;
	}

	public void setSellValue(BigDecimal sellValue) {
		this.sellValue = sellValue;
	}

	public BigDecimal getProfitLoss() {
		return profitLoss;
	}

	public void setProfitLoss(BigDecimal profitLoss) {
		this.profitLoss = profitLoss;
	}

	public BigDecimal getTaxDeducted() {
		return taxDeducted;
	}

	public void setTaxDeducted(BigDecimal taxDeducted) {
		this.taxDeducted = taxDeducted;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public BigDecimal getNetProfitLoss() {
		return netProfitLoss;
	}

	public void setNetProfitLoss(BigDecimal netProfitLoss) {
		this.netProfitLoss = netProfitLoss;
	}

	public Date getSoldDate() {
		return soldDate;
	}

	public void setSoldDate(Date soldDate) {
		this.soldDate = soldDate;
	}

	@Override
	public String toString() {
		return "StockDto [id=" + id + ", stock=" + stock + ", buyQuantity=" + buyQuantity + ", buyPrice=" + buyPrice
				+ ", buyValue=" + buyValue + ", purchaseDate=" + purchaseDate + ", sellQuantity=" + sellQuantity
				+ ", sellPrice=" + sellPrice + ", sellValue=" + sellValue + ", profitLoss=" + profitLoss
				+ ", taxDeducted=" + taxDeducted + ", taxRate=" + taxRate + ", netProfitLoss=" + netProfitLoss
				+ ", soldDate=" + soldDate + "]";
	}

}
