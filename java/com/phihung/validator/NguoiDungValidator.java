package com.phihung.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.phihung.entity.NguoiDung;

public class NguoiDungValidator implements Validator {

    public boolean supports(Class<?> clazz) {
	return NguoiDung.class.isAssignableFrom(clazz);
    }

    public void validate(Object o, Errors errors) {
	NguoiDung nguoidung = (NguoiDung) o;
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hoten", "field.required");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "diachi", "field.required");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tendangnhap", "field.required");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "matkhau", "field.required");

	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "field.required");

	if (nguoidung.getMatkhau().length() < 6 || nguoidung.getMatkhau().length() > 12)
	    errors.rejectValue("matkhau", "password.invalid");

	if (!nguoidung.getEmail().contains("@") && !nguoidung.getEmail().contains("."))
	    errors.rejectValue("email", "email.invalid");
    }

}
