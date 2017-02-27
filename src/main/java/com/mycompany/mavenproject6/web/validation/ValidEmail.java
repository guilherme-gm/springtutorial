package com.mycompany.mavenproject6.web.validation;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD, METHOD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidEmailImpl.class)
@Documented
public @interface ValidEmail {

    String message() default "This does not appear to be a valid email address";

    // Temos que ter
    Class<?>[] groups() default { };

    // Temos que ter
    Class<? extends Payload>[] payload() default { };

    // Definir tamanho minimo
    int min() default 5;
}