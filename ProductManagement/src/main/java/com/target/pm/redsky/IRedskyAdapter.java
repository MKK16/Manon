package com.target.pm.redsky;

import java.util.concurrent.ExecutionException;

import com.target.pm.model.ProductDescriptionResponse;
import com.target.pm.model.ProductSummaryResponse;
import com.target.pm.model.UpdatePriceRequest;
import com.target.pm.model.UpdatePriceResponse;

public interface IRedskyAdapter {
	
	public ProductSummaryResponse retrieveProdcuts(String productId) throws InterruptedException, ExecutionException, Exception;

	public UpdatePriceResponse updatePrice(String productId, UpdatePriceRequest updatePrice);

	public ProductDescriptionResponse retrieveProducts(String productId);

}
