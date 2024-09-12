package id.co.ogya.rest.simple.entity;

import lombok.Data;

@Data
public class Purchase {
    private String productId;
    private String productName;
    private Integer quantity;
    private Double price;
}
