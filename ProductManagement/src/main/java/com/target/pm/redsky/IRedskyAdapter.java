package com.target.pm.redsky;

import com.target.pm.model.ProductDescriptionResponse;
import com.target.pm.model.ProductSummaryResponse;
import com.target.pm.model.UpdatePriceRequest;
import com.target.pm.model.UpdatePriceResponse;

public interface IRedskyAdapter {
	
	public ProductSummaryResponse retrieveProdcuts(String productId);

	public UpdatePriceResponse updatePrice(String productId, UpdatePriceRequest updatePrice);

	public ProductDescriptionResponse retrieveProducts(String productId);

}
