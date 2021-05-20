package com.mk.trading.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class TaxDto {

	private Long id;
	private BigDecimal igst;
	private BigDecimal cgst;
	private BigDecimal sgst;

	public TaxDto() {
		super();
	}

	public TaxDto(Long id, BigDecimal igst, BigDecimal cgst, BigDecimal sgst) {
		super();
		this.id = id;
		this.igst = igst;
		this.cgst = cgst;
		this.sgst = sgst;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getIgst() {
		return igst;
	}

	public void setIgst(BigDecimal igst) {
		this.igst = igst;
	}

	public BigDecimal getCgst() {
		return cgst;
	}

	public void setCgst(BigDecimal cgst) {
		this.cgst = cgst;
	}

	public BigDecimal getSgst() {
		return sgst;
	}

	public void setSgst(BigDecimal sgst) {
		this.sgst = sgst;
	}

	@Override
	public String toString() {
		return "TaxDto [id=" + id + ", igst=" + igst + ", cgst=" + cgst + ", sgst=" + sgst + "]";
	}

}
