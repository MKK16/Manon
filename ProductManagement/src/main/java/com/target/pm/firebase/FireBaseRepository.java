package com.target.pm.firebase;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.target.pm.exception.ProductManagementException;
import com.target.pm.model.CurrentPrice;
import com.target.pm.model.ProductSummary;
import com.target.pm.model.ProductSummaryResponse;
import com.target.pm.model.UpdatePriceRequest;
import com.target.pm.model.UpdatePriceResponse;

@Repository
public class FireBaseRepository {
	
	@Autowired
	private Firestore firestore;
	
	private static final String ERROR = "Unable to retrieve product price from firebase.";
	
	public ProductSummaryResponse getProductPrice(long  productId, String productName)  {
		ProductSummaryResponse productSummaryResponse = new ProductSummaryResponse();
		ApiFuture<DocumentSnapshot>  docRef = firestore.collection("productsummary").document(Long.toString(productId)).get();
		Map<String, Object> data;
		try {
			data = docRef.get().getData();
		} catch (InterruptedException | ExecutionException exception) {
			throw new ProductManagementException(ERROR,exception,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		productSummaryResponse.setId(Long.toString(productId));
		productSummaryResponse.setName(productName);
		CurrentPrice currentPrice = new CurrentPrice();
		currentPrice.setCurrencyCode(data.get("currencyCode").toString());
		currentPrice.setValue(new BigDecimal(data.get("price").toString()));
		productSummaryResponse.setCurrentPrice(currentPrice);
		return productSummaryResponse;
	}

	public UpdatePriceResponse updatePrice(long productId, UpdatePriceRequest updatePrice) {
		UpdatePriceResponse updatePriceResponse = null;
        DocumentReference docRef = firestore.collection("productsummary").document(Long.toString(productId));
        ProductSummary productSummaryData = buildRequest(updatePrice);
        ApiFuture<WriteResult> result = docRef.set(productSummaryData);
        updatePriceResponse = buildResponse(productId);
        return updatePriceResponse;
      
	}

	private UpdatePriceResponse buildResponse(long productId) {
		UpdatePriceResponse updatePriceResponse = new UpdatePriceResponse();
		updatePriceResponse.setProductid(Long.toString(productId));
		updatePriceResponse.setMessageText("Successfully Updated");
		return updatePriceResponse;
	}

	private ProductSummary buildRequest(UpdatePriceRequest updatePrice) {
		ProductSummary productSummary = new ProductSummary();
		productSummary.setCurrencyCode(updatePrice.getCurrentPrice().getCurrencyCode());
		productSummary.setPrice(updatePrice.getCurrentPrice().getValue().toString());
		return productSummary;
	}

}
