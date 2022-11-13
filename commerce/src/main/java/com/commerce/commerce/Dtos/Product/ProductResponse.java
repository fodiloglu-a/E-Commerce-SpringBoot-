package com.commerce.commerce.Dtos.Product;


import lombok.Data;

@Data

public class ProductResponse {
    private String name;

    private String prop ;

    private int stock;

    private double price;

    private String category;
}
