package id.co.ogya.rest.simple.service;

import id.co.ogya.rest.simple.config.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.co.ogya.rest.simple.repository.PurchaseRepository;
import id.co.ogya.rest.simple.response.purchase.PurchaseOutputSchema;
import id.co.ogya.rest.simple.util.ResponseUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PurchaseService {
	@Autowired
	private ResponseUtils responseUtils;
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	public ResponseEntity list(String hashCode, String customerId) {
		PurchaseOutputSchema outputSchema = new PurchaseOutputSchema();
		log.debug(hashCode + "Get data");
		Purchase purchase = purchaseRepository.findByCustomerId(customerId);
		if(purchase == null) {
			return responseUtils.generateFailedResult(outputSchema, new Exception("No Data Found"), HttpStatus.NOT_FOUND.value());
		}

		outputSchema.setProductId(purchase.getProductId());
		outputSchema.setPrice(purchase.getPrice());
		outputSchema.setQuantity(purchase.getQuantity());
		outputSchema.setProductName(purchase.getProductName());

		log.debug(hashCode + "Get data done");
		return responseUtils.generateSuccessResult(outputSchema);
	}
}
