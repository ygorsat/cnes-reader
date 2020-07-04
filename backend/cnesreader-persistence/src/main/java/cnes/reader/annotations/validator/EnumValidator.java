package cnes.reader.annotations.validator;

import javax.validation.ConstraintValidator;

import javax.validation.ConstraintValidatorContext;

import cnes.reader.annotations.EnumValues;
/**
 * @author ygor.satiro
 * Validator da {@link EnumValues} para Enum
 */
public class EnumValidator implements ConstraintValidator<EnumValues, String> {
	
	private EnumValues annotation;

	@Override
	public void initialize(EnumValues annotation) {
		this.annotation = annotation;
	}

	@Override
	public boolean isValid(String valueForValidation, ConstraintValidatorContext constraintValidatorContext) {
		boolean result = false;

		Object[] enumValues = this.annotation.enumClass().getEnumConstants();

		if (enumValues != null) {
			for (Object enumValue : enumValues) {
				if (this.annotation.acceptNull() && valueForValidation == null
						|| enumValue.toString().equals(valueForValidation)
						|| (this.annotation.ignoreCase() && enumValue.toString().equalsIgnoreCase(valueForValidation))) {
					result = true;
					break;
				}
			}
		}

		return result;
	}
}
