package com.commerce.commerce.Core.Annotations.CategoryAnnotations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({  FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = {ConstraintOwnerCategory.class })
//Bu @Annotation elimizde aynı kategoriden varmı kontrolü yapar

public @interface OwnerCategory {
    String message() default ">>>You already own a category by this name!!!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}

