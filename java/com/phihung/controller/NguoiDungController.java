package com.phihung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phihung.entity.NguoiDung;
import com.phihung.service.NguoiDungService;
import com.phihung.validator.NguoiDungValidator;

@Controller
public class NguoiDungController {

	@Autowired
	NguoiDungValidator nguoidungValidator;
	
	@Autowired
	NguoiDungService nguoidungService;


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		modelMap.addAttribute("nguoidung", new NguoiDung());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submitLogin(@ModelAttribute("nguoidung") NguoiDung nguoidung,BindingResult bindingResult) {
		 nguoidungValidator.validate(nguoidung, bindingResult); 
			if (bindingResult.hasErrors())
				return "/login";
		return "success";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(ModelMap modelMap) {
		modelMap.addAttribute("nguoidung", new NguoiDung());
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String submiRegistration(@ModelAttribute("nguoidung") NguoiDung nguoidung, BindingResult bindingResult,
			ModelMap modelMap) {
		 nguoidungValidator.validate(nguoidung, bindingResult); 

		if (bindingResult.hasErrors())
			return "/registration";

		nguoidungService.themNguoiDung(nguoidung);
		return "redirect:/login";
	}

}
