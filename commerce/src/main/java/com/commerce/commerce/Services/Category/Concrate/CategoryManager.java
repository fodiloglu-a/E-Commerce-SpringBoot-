package com.commerce.commerce.Services.Category.Concrate;

import com.commerce.commerce.Dtos.Category.CategoryRequest;
import com.commerce.commerce.Dtos.Category.CategoryResponse;
import com.commerce.commerce.Entity.Cart;
import com.commerce.commerce.Entity.Category;
import com.commerce.commerce.Entity.Product;
import com.commerce.commerce.Repository.Category.ICategoryDao;
import com.commerce.commerce.Services.Category.Abstract.ICategoryServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@Service
@RequiredArgsConstructor

public class CategoryManager implements ICategoryServices {
    private  final ICategoryDao iCategoryDao;
    private final ModelMapper modelMapper;




    @Override
    public List<CategoryResponse> getAllCategory() {
       List<Category>categories=this.iCategoryDao.findAll();
       List<CategoryResponse>categoryResponses=new ArrayList<>();

        for (Category c:categories
             ) {
            CategoryResponse categoryResponse=this.modelMapper.map(c,CategoryResponse.class);
            categoryResponses.add(categoryResponse);


        }

       return categoryResponses;
    }

    @Override
    public CategoryResponse getCategoryById(int id) {
        Category category=this.iCategoryDao.findAll().get(id);
        CategoryResponse categoryResponse=this.modelMapper.map(category,CategoryResponse.class);

        return categoryResponse;
    }

    @Override
    public CategoryResponse getCategoryByName(String name) {
        Category category=this.iCategoryDao.findByCategoryName(name);
        CategoryResponse categoryResponse=this.modelMapper.map(category,CategoryResponse.class);


        return categoryResponse;
    }

    @Override
    public void addCategory(CategoryRequest categoryRequest) {
        Category category=this.modelMapper.map(categoryRequest,Category.class);
        this.iCategoryDao.save(category);
        this.iCategoryDao.save(category);


    }
    public String deleteCategory(String categoryName){
        if (this.iCategoryDao.findByCategoryName(categoryName)==null){
            return "You are not have this{"+categoryName+"}.";
        }
        Category category=this.iCategoryDao.findByCategoryName(categoryName);
        this.iCategoryDao.delete(category);
        return "Successful delete ";
    }
    @Override
    public String updateCategory(int categoryId,String updateName){
        Category category=this.iCategoryDao.findAll().get(categoryId);

        if (category==null){
            return "You are not have category for update!";
        }

        category.setCategoryName(updateName);
        this.iCategoryDao.save(category);
        return "Successful Update!";



    }


}
