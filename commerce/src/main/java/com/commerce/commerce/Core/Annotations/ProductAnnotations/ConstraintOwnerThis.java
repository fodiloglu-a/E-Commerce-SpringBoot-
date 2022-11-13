package com.commerce.commerce.Core.Annotations.ProductAnnotations;

import com.commerce.commerce.Model.Product;
import com.commerce.commerce.Repository.Product.IProductDao;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class ConstraintOwnerThis implements ConstraintValidator<OwnerProduct,String> {
    public final IProductDao productDao;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        Product product=this.productDao.findByProductName(s);
        if (product!=null){
            return false;
        }
        return true;



    }
}
