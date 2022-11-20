package com.commerce.commerce.Services.Category.Abstract;

import com.commerce.commerce.Dtos.Category.CategoryRequest;
import com.commerce.commerce.Dtos.Category.CategoryResponse;
import com.commerce.commerce.Entity.Category;

import java.util.List;

public interface ICategoryServices {
    public List<CategoryResponse> getAllCategory();
    public  CategoryResponse getCategoryById(int id);
    public CategoryResponse getCategoryByName(String name);
    public void addCategory(CategoryRequest categoryRequest);
    public String deleteCategory(String categoryName);
    public String updateCategory(int categoryId,String updateName);

}
