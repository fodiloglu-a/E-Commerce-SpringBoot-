package com.commerce.commerce.Controller.CategoryApi;

import com.commerce.commerce.Dtos.Category.CategoryRequest;
import com.commerce.commerce.Dtos.Category.CategoryResponse;
import com.commerce.commerce.Model.Category;
import com.commerce.commerce.Model.Product;
import com.commerce.commerce.Services.Category.Concrate.CategoryManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")//localhost:8080/category
@RequiredArgsConstructor
public class CategoryApi {
    private final CategoryManager categoryManager;




    @GetMapping("/getCategoryAll")//localhost:8080/category/getCategoryAll
    public List<CategoryResponse> getCategoryAll(){
        return this.categoryManager.getAllCategory();
    }





    @GetMapping("/getCategoryById")//localhost:8080/category/getCategoryById

    public CategoryResponse getCategoryById(@RequestParam int id){
        return this.categoryManager.getCategoryById(id);

    }




    @GetMapping("/getCategoryByName")//localhost:8080/category/getCategoryByName
    public CategoryResponse getCategoryByName(@RequestParam String name){
        return this.categoryManager.getCategoryByName(name);
    }



    @PostMapping("/addCategory")//localhost:8080/category/addCategory
    public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryRequest categoryRequest){
         this.categoryManager.addCategory(categoryRequest);
         return ResponseEntity.ok().build();
             }
    @GetMapping("/deleteCategory")//localhost:8080/category/addCategory/deleteCategory

    public String deleteCategory(@RequestParam String categoryName){
        return this.categoryManager.deleteCategory(categoryName);
    }
    @GetMapping("/updateCategory")//localhost:8080/category/addCategory/updateCategory

    public String updateCategory(@RequestParam int categoryId,@RequestParam String updateName){
        return this.categoryManager.updateCategory(categoryId,updateName);
    }
























}
