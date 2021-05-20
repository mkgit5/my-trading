package com.mk.trading.common.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "TRADING_STOCK_SEQ", sequenceName = "STOCK_SEQ", initialValue = 4, allocationSize = 1)
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRADING_STOCK_SEQ")
	private Long id;

	private String stock;

	private Long buyQuantity;

	private BigDecimal buyPrice;

	private BigDecimal buyValue;

	private BigDecimal profitLoss;

	private BigDecimal taxDeducted;

	private BigDecimal taxRate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date purchaseDate;

	private Character closed;

	@OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<StockOrder> stockOrders = new ArrayList<>();

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

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Character getClosed() {
		return closed;
	}

	public void setClosed(Character closed) {
		this.closed = closed;
	}

	public List<StockOrder> getStockOrders() {
		return stockOrders;
	}

	public void setStockOrders(List<StockOrder> stockOrders) {
		this.stockOrders = stockOrders;
	}

}
