package com.commerce.commerce.Dtos.Product;


import com.commerce.commerce.Core.Annotations.ProductAnnotations.OwnerProduct;
import lombok.Data;

@Data
public class ProductRequest {

    @OwnerProduct
    private String name;

    private String prop ;

    private int stock;

    private double price;

    private int category;
}
