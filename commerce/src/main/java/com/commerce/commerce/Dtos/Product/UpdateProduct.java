package com.commerce.commerce.Dtos.Product;

import lombok.Data;

@Data
public class UpdateProduct {

    private  int updateId;
    private String name;

    private String prop ;

    private int stock;

    private double price;

    private int category;
}
