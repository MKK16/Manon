package com.target.pm.model;

import java.util.List;

public class ProductDescriptionResponse {
	
	private String productName;
	private List<String> bulletDescription;
	
	public ProductDescriptionResponse() {
		
	}
	
	public ProductDescriptionResponse(String productName,List<String> bulletDescription) { 
		 this.productName = productName; 
		 this.bulletDescription = bulletDescription; 
	} 
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public List<String> getBulletDescription() {
		return bulletDescription;
	}
	public void setBulletDescription(List<String> bulletDescription) {
		this.bulletDescription = bulletDescription;
	}
	

}
