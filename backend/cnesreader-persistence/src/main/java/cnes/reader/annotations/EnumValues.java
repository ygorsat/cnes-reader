package cnes.reader.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cnes.reader.annotations.validator.EnumListValidator;
import cnes.reader.annotations.validator.EnumValidator;

/**
 * @author ygor.satiro
 * Annotation para verificação de valores válidos em Enum
 */

@Documented
@Constraint(validatedBy = {EnumValidator.class, EnumListValidator.class})
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumValues {
	
	public abstract String message() default "Invalid format for Enum.";
    
    public abstract Class<?>[] groups() default {};
  
    public abstract Class<? extends Payload>[] payload() default {};
     
    public abstract Class<? extends java.lang.Enum<?>> enumClass();
     
    public abstract boolean ignoreCase() default false;
    
    public abstract boolean acceptNull() default false;
}
