package com.target.pm.model;

import java.math.BigDecimal;

public class CurrentPrice {
	
	private BigDecimal value;
	private String currencyCode;
	
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

}
