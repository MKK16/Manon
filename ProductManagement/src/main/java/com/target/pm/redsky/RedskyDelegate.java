package com.target.pm.redsky;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.target.pm.config.RestClientConfig;
import com.target.pm.model.ProductDescriptionResponse;

@Service
public class RedskyDelegate {

	@Autowired
	private RestClientConfig restClientConfig;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ProductDescriptionResponse retrieveProductName(String productId) throws Exception {
		ProductDescriptionResponse productDescriptionResponse = new ProductDescriptionResponse();
		try {
			productDescriptionResponse = restTemplate.getForObject(restClientConfig.getRedskyUrl()+"/"+productId, ProductDescriptionResponse.class);
		}catch (Exception e) {
			throw new Exception();
		}
		return  productDescriptionResponse;
		
	}

}
