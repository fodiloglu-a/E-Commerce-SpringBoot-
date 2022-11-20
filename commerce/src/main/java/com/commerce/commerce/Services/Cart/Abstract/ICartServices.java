package com.commerce.commerce.Services.Cart.Abstract;


import com.commerce.commerce.Dtos.Cart.CartRequest;
import com.commerce.commerce.Dtos.Cart.CartResponse;
import com.commerce.commerce.Dtos.Product.ProductResponse;
import com.commerce.commerce.Entity.Cart;
import com.commerce.commerce.Entity.Product;

import java.util.List;

public interface ICartServices {

    String saveCart (int productId);
    List<ProductResponse> getCart();

    String getCartTotal();

    String completeOrder(boolean a);







}
