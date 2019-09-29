package com.phihung.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.phihung.entity.DonHang;
import com.phihung.entity.NguoiDung;

@Component
public class DatHangValidator implements Validator{
	public boolean supports(Class<?> clazz) {
		return NguoiDung.class.equals(clazz);
	}

	public void validate(Object o, Errors errors) {
		DonHang dathang = (DonHang) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tennguoinhan", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sodienthoai", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "diachigiaohang", "field.required");

		

	}
}
