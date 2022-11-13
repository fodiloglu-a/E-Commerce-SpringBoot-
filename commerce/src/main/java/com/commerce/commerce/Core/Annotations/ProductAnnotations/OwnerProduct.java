package com.commerce.commerce.Core.Annotations.ProductAnnotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;



@Target({  FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = {ConstraintOwnerThis.class })
public @interface OwnerProduct {//Bu @Annotations eklenen ürünün aynnsından elimizde varmı kotrolü yapar.

    String message() default ">>>You already own a product by this name";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };



}
