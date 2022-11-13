package com.commerce.commerce.Dtos.Category;

import com.commerce.commerce.Core.Annotations.CategoryAnnotations.OwnerCategory;
import lombok.Data;

@Data
public class CategoryRequest {


    @OwnerCategory
    public String categoryName;

}
