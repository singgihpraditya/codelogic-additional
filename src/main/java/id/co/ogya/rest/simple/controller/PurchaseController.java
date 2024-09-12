package id.co.ogya.rest.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import id.co.ogya.rest.simple.service.PurchaseService;
import id.co.ogya.rest.simple.util.Utils;

@RestController
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;

	@RequestMapping(value = "/purchase/{customer-id}", method = RequestMethod.GET)
	public ResponseEntity inquiry(@PathVariable("customer-id") String customerId){
		String hashCode = Utils.getHashCodeNumber() + "-INQUIRY-PURCASE-";
		return purchaseService.inquiry(hashCode, customerId);
	}
}
