package com.target.pm.redsky;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.target.pm.exception.ProductManagementException;
import com.target.pm.firebase.FireBaseRepository;
import com.target.pm.model.ProductDescriptionResponse;
import com.target.pm.model.ProductSummaryResponse;
import com.target.pm.model.UpdatePriceRequest;
import com.target.pm.model.UpdatePriceResponse;

@Service
public class RedskyAdapter implements IRedskyAdapter {
	
	@Autowired
	private FireBaseRepository fireBaseRepository;
	
	@Autowired
	private RedskyDelegate redskyDelegate;
	
	@Resource(name = "productionDescriptionMap")
	private HashMap<String,ProductDescriptionResponse> productionDescriptionMap;
	
	private static final String ERROR_MESSAGE = "PM001 - Given Product Id doesn't match with our record";

	@Override
	public ProductSummaryResponse retrieveProdcuts(long  productId) {
		ProductDescriptionResponse retrieveProductName = redskyDelegate.retrieveProductName(productId);
		if(null != retrieveProductName ) {
			return fireBaseRepository.getProductPrice(productId,retrieveProductName.getProductName()); 
		} else {
		    throw new ProductManagementException(ERROR_MESSAGE,HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public UpdatePriceResponse updatePrice(long productId, UpdatePriceRequest updatePrice) {
		return fireBaseRepository.updatePrice(productId,updatePrice); 
	}

	@Override
	public ProductDescriptionResponse retrieveProducts(long productId) {
		ProductDescriptionResponse productDescriptionResponse = null;
		if(productionDescriptionMap.containsKey(Long.toString(productId))) {
			 productDescriptionResponse = productionDescriptionMap.get(Long.toString(productId));
		}
		return productDescriptionResponse;
	}


}
