package id.co.ogya.rest.simple.response.purchase;

import id.co.ogya.rest.simple.response.BaseOutputSchema;
import lombok.Data;

@Data
public class PurchaseOutputSchema extends BaseOutputSchema {
	private String productId;
	private String productName;
	private Integer quantity;
	private Double price;
}
