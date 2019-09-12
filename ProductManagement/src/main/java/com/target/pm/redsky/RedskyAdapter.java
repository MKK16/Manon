package com.target.pm.redsky;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public ProductSummaryResponse retrieveProdcuts(String productId) throws Exception {
		ProductDescriptionResponse retrieveProductName = redskyDelegate.retrieveProductName(productId);
		return fireBaseRepository.getProductPrice(productId,retrieveProductName.getProductName()); 
	}

	@Override
	public UpdatePriceResponse updatePrice(String productId, UpdatePriceRequest updatePrice) {
		return fireBaseRepository.updatePrice(productId,updatePrice); 
	}

	@Override
	public ProductDescriptionResponse retrieveProducts(String productId) {
		ProductDescriptionResponse productDescriptionResponse = null;
		if(productionDescriptionMap.containsKey(productId)) {
			 productDescriptionResponse = productionDescriptionMap.get(productId);
		}
		return productDescriptionResponse;
	}


}
