package com.commerce.commerce.Services.Product.Concreate;


import com.commerce.commerce.Dtos.Product.ProductRequest;

import com.commerce.commerce.Dtos.Product.ProductResponse;
import com.commerce.commerce.Dtos.Product.UpdateProduct;

import com.commerce.commerce.Model.Category;
import com.commerce.commerce.Model.Product;

import com.commerce.commerce.Repository.Category.ICategoryDao;
import com.commerce.commerce.Repository.Product.IProductDao;
import com.commerce.commerce.Services.Product.Abstract.IProductServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductManager implements IProductServices {
    private final IProductDao iProductDao;
    private final ICategoryDao iCategoryDao;
    private final ModelMapper modelMapper;








    @Override
    public List<ProductResponse> getAllProduct() {
        List<Product> productList = this.iProductDao.findAll();
        List<ProductResponse> productResponseList = new ArrayList<>();
        for (Product p : productList
        ) {

            ProductResponse productResponse = this.modelMapper.map(p, ProductResponse.class);

            productResponseList.add(productResponse);

        }


        return productResponseList;
    }

    @Override
    public ProductResponse getProductById(int id) {

        Product product = this.iProductDao.findAll().get(id);
        ProductResponse productResponse = this.modelMapper.map(product, ProductResponse.class);

        return productResponse;
    }

    @Override
    public List<ProductResponse> findAllByCategory_CategoryId(int id) {
     List<Product>productList=this.iProductDao.findAllByCategory_Id(id);
     List<ProductResponse>productResponseList=new ArrayList<>();
        for (Product product : productList) {
            ProductResponse productResponse=this.modelMapper.map(product,ProductResponse.class);

            productResponseList.add(productResponse);


        }

        return productResponseList;
    }

    @Override
    public void addProduct(ProductRequest productRequest) {

        Category category = this.iCategoryDao.findAll().get(productRequest.getCategory());
        Product product = this.modelMapper.map(productRequest, Product.class);

        product.setCategory(category);
        this.iProductDao.save(product);
    }



















    @Override
    public String deleteProduct(int id) {

        Product product=this.iProductDao.findAll().get(id);
        this.iProductDao.delete(product);



        return "Successful Delete!";
    }


    @Override
    public String updateProduct(UpdateProduct productRequest) {
        if (this.iProductDao.findAll().get(productRequest.getUpdateId()) == null) {
            return "You are not have this {" + productRequest.getName() + "} product.";
        }

        Product productUp=this.iProductDao.findAll().get(productRequest.getUpdateId()) ;
        productUp.setProductName(productRequest.getName());
        productUp.setStock(productRequest.getStock());
        productUp.setProp(productRequest.getProp());
        productUp.setPrice(productRequest.getPrice());
        Category category=this.iCategoryDao.findAll().get(productRequest.getCategory());
        productUp.setCategory(category);

        this.iProductDao.save(productUp);




        return "Successful Update!";
    }





}
