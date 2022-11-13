package com.commerce.commerce.Controller.CartApi;





import com.commerce.commerce.Dtos.Product.ProductResponse;

import com.commerce.commerce.Services.Cart.Concreate.CartManager;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/cart")//localhost:8080/cart
public class CartApi {

    public final CartManager cartManager;

    @GetMapping("/addCart")//localhost:8080/cart/addCart
    public String addCart(@RequestParam int productId){

        return this.cartManager.saveCart(productId);
    }



    //**Çalışan methot

    @GetMapping("/getCart")//localhost:8080/cart/getCart
    public List<ProductResponse> getCart(){
       return this.cartManager.getCart();



    }






    @GetMapping("/getCartTotal")//localhost:8080/cart/getCartTotal
    public String getCartTotal(){
         return this.cartManager.getCartTotal();


    }

    @GetMapping("/completeOrder")//localhost:8080/cart/completeOrder

    public String completeOrder(boolean a){
        return this.cartManager.completeOrder(a);
    }






}






