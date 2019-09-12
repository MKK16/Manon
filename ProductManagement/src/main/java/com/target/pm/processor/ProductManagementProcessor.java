package com.target.pm.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.target.pm.model.ProductDescriptionResponse;
import com.target.pm.model.ProductSummaryResponse;
import com.target.pm.model.UpdatePriceRequest;
import com.target.pm.model.UpdatePriceResponse;
import com.target.pm.redsky.IRedskyAdapter;

@Component
public class ProductManagementProcessor {
	
	@Autowired
	private IRedskyAdapter redskyAdapter;
	
	public ResponseEntity<ProductSummaryResponse> retrieveProductById(String productId) throws Exception {
		 ProductSummaryResponse retrieveProdcuts = redskyAdapter.retrieveProdcuts(productId);
		 return new ResponseEntity<ProductSummaryResponse>(retrieveProdcuts,HttpStatus.OK);
	}

	public ResponseEntity<UpdatePriceResponse> updatePrice(String productId, UpdatePriceRequest updatePrice) {
		 UpdatePriceResponse updatePriceResponse = redskyAdapter.updatePrice(productId,updatePrice);
		 return new ResponseEntity<UpdatePriceResponse>(updatePriceResponse,HttpStatus.OK);
	}
	
	public ResponseEntity<ProductDescriptionResponse> retrieveProducts(String productId) {
		ProductDescriptionResponse retrieveProdcuts = redskyAdapter.retrieveProducts(productId);
		 return new ResponseEntity<ProductDescriptionResponse>(retrieveProdcuts,HttpStatus.OK);
	}

}
