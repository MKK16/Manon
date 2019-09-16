package com.target.pm.redsky;

import com.target.pm.model.ProductDescriptionResponse;
import com.target.pm.model.ProductSummaryResponse;
import com.target.pm.model.UpdatePriceRequest;
import com.target.pm.model.UpdatePriceResponse;

public interface IRedskyAdapter {
	
	public ProductSummaryResponse retrieveProdcuts(long  productId);

	public UpdatePriceResponse updatePrice(long productId, UpdatePriceRequest updatePrice);

	public ProductDescriptionResponse retrieveProducts(long productId);

}
