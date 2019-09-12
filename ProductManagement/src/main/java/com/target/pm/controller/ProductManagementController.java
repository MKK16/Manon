package com.target.pm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.target.pm.model.ProductDescriptionResponse;
import com.target.pm.model.ProductSummaryResponse;
import com.target.pm.model.UpdatePriceRequest;
import com.target.pm.model.UpdatePriceResponse;
import com.target.pm.processor.ProductManagementProcessor;

import io.swagger.annotations.ApiOperation;

@RestController
public class ProductManagementController {
	
	@Autowired
	private ProductManagementProcessor productManagementProcessor;
	
	@ApiOperation(httpMethod = "GET", value = "Retrieve Products by ID")
	@GetMapping(value = "/productId/{productId}")
	public ResponseEntity<ProductSummaryResponse> getProductsById(@PathVariable ("productId") String productId) throws Exception{
		return productManagementProcessor.retrieveProductById(productId);
		
	}
	
	@ApiOperation(httpMethod = "PUT", value = "Update price")
	@PutMapping(value = "/productId/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UpdatePriceResponse> updateProductById(@RequestBody UpdatePriceRequest updatePriceRequest,@PathVariable ("productId") String productId){
		return productManagementProcessor.updatePrice(productId,updatePriceRequest);
		
	}
	

	@ApiOperation(httpMethod = "GET", value = "Retrieve Products")
	@GetMapping(value = "/products/{productId}")
	public ResponseEntity<ProductDescriptionResponse> getProducts(@PathVariable ("productId") String productId) {
		return productManagementProcessor.retrieveProducts(productId);
		
	}

}
