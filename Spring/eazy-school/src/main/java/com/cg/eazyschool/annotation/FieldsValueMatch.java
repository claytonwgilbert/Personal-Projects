package com.cg.eazyschool.annotation;

import com.cg.eazyschool.validation.FieldsValueMatchValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FieldsValueMatchValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsValueMatch {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "Fields values don't match!";

    //All code below is needed when validating more than one field such as our email and confirm email field
    String field();
    String fieldMatch();
    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List { //Gets populated when using annotation on class
        FieldsValueMatch[] value();
    }
}
