package com.cg.eazyschool.validation;

import com.cg.eazyschool.annotation.FieldsValueMatch;
import org.springframework.beans.BeanWrapperImpl;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldsValueMatchValidator implements ConstraintValidator<FieldsValueMatch, Object> { //Object is the 2nd arg here because we want access to not just a field, but the entire object so that we can access multiple fields to perform validation against, you only provide String when one field is being validated against like the case with the password validator
    private String field;
    private String fieldMatch;

    @Override
    public void initialize(FieldsValueMatch constraintAnnotation) {
        this.field = constraintAnnotation.field(); //filed() and fieldMatch() are methods in the FieldsValueMatch annotation that will be populated when using the annotation on a class...see person class to see how the annotation is used and populated
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) { //The object value will have the whole pojo in order to access its fields for this validation check
        Object fieldValue = new BeanWrapperImpl(value)
                .getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value)
                .getPropertyValue(fieldMatch);
        if (fieldValue != null) {
            return fieldValue.equals(fieldMatchValue);
        } else {
            return fieldMatchValue == null;
        }
    }
}
