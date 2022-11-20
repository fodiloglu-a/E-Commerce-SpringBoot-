package com.commerce.commerce.Services.Cart.Concreate;


import com.commerce.commerce.Dtos.Product.ProductResponse;
import com.commerce.commerce.Entity.Cart;
import com.commerce.commerce.Entity.Product;
import com.commerce.commerce.Repository.Cart.ICartDao;
import com.commerce.commerce.Repository.Product.IProductDao;
import com.commerce.commerce.Services.Cart.Abstract.ICartServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartManager implements ICartServices {
    private final ICartDao iCartDao;
    private final IProductDao iProductDao;


    private final ModelMapper modelMapper;


    @Override
    public String saveCart(int productId) {

       Cart cart=new Cart();
       Product product=this.iProductDao.findAll().get(productId);
       cart.setCartNo(1);
       cart.setProduct(product);
       this.iCartDao.save(cart);

       return "successful";
    }

    @Override
    public List<ProductResponse> getCart() {
         List<ProductResponse>productResponseList=new ArrayList<>();
        List<Cart>cartList=this.iCartDao.findByCartNo(1);
        for (Cart cart : cartList) {

            Product product=cart.getProduct();
            ProductResponse productResponse=this.modelMapper.map(product,ProductResponse.class);
            productResponseList.add(productResponse);



        }



        return productResponseList;
    }

    @Override
    public String getCartTotal() {
        double totalPrice=0.0d;
        List<Cart>cartList=this.iCartDao.findByCartNo(1);
        for (Cart cart : cartList) {

            totalPrice +=cart.getProduct().getPrice();



        }



        return "Total Cart Price= ["+totalPrice+" TL]";

    }

    @Override
    public String completeOrder(boolean a) {
        if (a){
            List<Cart>cartList=this.iCartDao.findByCartNo(1);

            for (Cart cart : cartList) {
             Product product=this.iProductDao.findByProductName(cart.getProduct().getProductName());

             product.setStock(product.getStock()-1);
             this.iProductDao.save(product);




            }
            return getCartTotal();




        }

        return null;
    }

}
