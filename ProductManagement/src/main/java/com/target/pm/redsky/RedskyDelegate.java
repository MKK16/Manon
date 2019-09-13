package com.target.pm.redsky;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.target.pm.config.RestClientConfig;
import com.target.pm.exception.ProductManagementException;
import com.target.pm.model.ProductDescriptionResponse;

@Service
public class RedskyDelegate {

	@Autowired
	private RestClientConfig restClientConfig;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String ERROR = "Unable to retrieve product name from Redsky service";
	
	public ProductDescriptionResponse retrieveProductName(String productId) {
		ProductDescriptionResponse productDescriptionResponse = new ProductDescriptionResponse();
		try {
			productDescriptionResponse = restTemplate.getForObject(restClientConfig.getRedskyUrl()+"/"+productId, ProductDescriptionResponse.class);
		}catch (RestClientException exception) {
			throw new ProductManagementException(ERROR,exception,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return  productDescriptionResponse;
		
	}

}
