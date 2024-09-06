package az.kibrit.library.validation;


import jakarta.servlet.annotation.HttpConstraint;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidateBook {

}
