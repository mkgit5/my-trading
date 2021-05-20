package com.mk.trading.common.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "STOCK_ORDER_SEQUENCE", name = "STOCK_ORDER_SEQUENCE")
public class StockOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STOCK_ORDER_SEQUENCE")
	private Long id;

	@OneToOne
	@JoinColumn(name = "STOCK_ID", referencedColumnName = "id")
	private Stock stock;

	private Long sellQuantity;

	private BigDecimal sellPrice;

	private BigDecimal sellValue;

	@Temporal(TemporalType.TIMESTAMP)
	private Date soldDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
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

	public Date getSoldDate() {
		return soldDate;
	}

	public void setSoldDate(Date soldDate) {
		this.soldDate = soldDate;
	}

}
