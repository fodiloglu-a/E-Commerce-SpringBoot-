package com.commerce.commerce.Services.Product.Abstract;

import com.commerce.commerce.Dtos.Product.ProductRequest;
import com.commerce.commerce.Dtos.Product.ProductResponse;
import com.commerce.commerce.Dtos.Product.UpdateProduct;
import com.commerce.commerce.Model.Product;

import java.util.List;

public interface IProductServices {
    List<ProductResponse> getAllProduct();
    ProductResponse getProductById(int id);
    List<ProductResponse> findAllByCategory_CategoryId(int id);



    void addProduct(ProductRequest productRequest);
    String deleteProduct(int id);
    public String updateProduct(UpdateProduct productRequest);



}
