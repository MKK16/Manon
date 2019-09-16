package com.target.pm.model;

import javax.validation.Valid;

public class UpdatePriceRequest {
	
	private String productName;
	@Valid
	private CurrentPrice currentPrice;

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public CurrentPrice getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(CurrentPrice currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	
}
