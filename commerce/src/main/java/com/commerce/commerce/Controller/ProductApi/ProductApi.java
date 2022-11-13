package com.commerce.commerce.Controller.ProductApi;


import com.commerce.commerce.Dtos.Product.ProductRequest;
import com.commerce.commerce.Dtos.Product.ProductResponse;
import com.commerce.commerce.Dtos.Product.UpdateProduct;

import com.commerce.commerce.Repository.Category.ICategoryDao;
import com.commerce.commerce.Services.Product.Concreate.ProductManager;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")//localhost:8080/product
public class ProductApi {
    private final ProductManager productManager;
    private final ICategoryDao iCategoryDao;


    @GetMapping("/getAllProduct")//localhost:8080/product/getAllProduct
    public List<ProductResponse> getAllProduct(){
        return this.productManager.getAllProduct();

    }
    @GetMapping("/getProductById")//localhost:8080/product/getProductById
    public ResponseEntity<ProductResponse> getProductById(@RequestParam int id){
         ProductResponse productResponse=this.productManager.getProductById(id);


        return ResponseEntity.ok().body(this.productManager.getProductById(id));
    }




    @PostMapping("/addProduct")//localhost:8080/product/addProduct
    public ResponseEntity<?> addProduct (@Valid @RequestBody ProductRequest productRequest){
       this.productManager.addProduct(productRequest);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/updateProduct")//localhost:8080/product/updateProduct
    public String updateProduct( @RequestBody UpdateProduct productRequest){
        return  this.productManager.updateProduct(  productRequest);
    }



    @GetMapping("/deleteProducts")//localhost:8080/product/deleteProducts
    public String deleteProducts (@RequestParam int id){
       return this.productManager.deleteProduct(id);

    }
    @GetMapping("/getProductByCategory")//localhost:8080/product/getProductByCategory
    public List<ProductResponse> findAllByCategory_CategoryId(int id){
        return this.productManager.findAllByCategory_CategoryId(id);
    }






}
