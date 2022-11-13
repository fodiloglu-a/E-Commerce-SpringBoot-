package com.commerce.commerce.Core.Annotations.CategoryAnnotations;

import com.commerce.commerce.Model.Category;
import com.commerce.commerce.Repository.Category.ICategoryDao;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@RequiredArgsConstructor
public class ConstraintOwnerCategory implements ConstraintValidator<OwnerCategory,String> {

    public  final ICategoryDao categoryDao;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        Category category=this.categoryDao.findByCategoryName(s);
        if (category!=null){
            return false;
        }
        return true;



    }
}
