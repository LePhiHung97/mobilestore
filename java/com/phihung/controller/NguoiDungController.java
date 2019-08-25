package com.phihung.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.phihung.entity.ConfirmationToken;
import com.phihung.entity.NguoiDung;
import com.phihung.service.IConfirmationTokenService;
import com.phihung.service.INguoiDungService;
import com.phihung.utils.EmailUtil;
import com.phihung.validator.DangKiValidator;
import com.phihung.validator.DangNhapValidator;

@Controller
public class NguoiDungController {
	@Autowired
	private MessageSource messages;

	@Autowired
	DangKiValidator dangKiValidator;

	@Autowired
	DangNhapValidator dangNhapValidator;

	@Autowired
	INguoiDungService nguoiDungService;

	@Autowired
	ApplicationEventPublisher evenPublisher;

	@Autowired
	IConfirmationTokenService confirmationTokenService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		modelMap.addAttribute("nguoidung", new NguoiDung());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submitLogin(@ModelAttribute("nguoidung") NguoiDung nguoidung, BindingResult bindingResult) {
		dangNhapValidator.validate(nguoidung, bindingResult);
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
	public String submiRegistration(HttpServletRequest request, @ModelAttribute("nguoidung") NguoiDung nguoiDung,
			BindingResult bindingResult, ModelMap model) {
		dangKiValidator.validate(nguoiDung, bindingResult);
		if (bindingResult.hasErrors()) {
			return "/registration";
		}

		NguoiDung existNguoiDung = nguoiDungService.timTheoEmail(nguoiDung.getEmail());
		if (existNguoiDung != null) {
			bindingResult.rejectValue("email", "This email already exist!");
			return "/registration";
		} else {
			nguoiDungService.themNguoiDung(nguoiDung);
			ConfirmationToken confirmationToken = new ConfirmationToken(nguoiDung);
			confirmationTokenService.add(confirmationToken);

			model.addAttribute("email", nguoiDung.getEmail());
			String message = "To confirm your account, please click here : "
					+ "http://localhost:8080/confirm-account?token=" + confirmationToken.getConfirmationToken();
			EmailUtil.sendMail(nguoiDung.getEmail(), message);
			return "confirm-account";
		}
	}
	
	public String confirmAccount(@RequestParam String token,ModelMap model) {
		
		ConfirmationToken confirmationToken = confirmationTokenService.findByConfirmationToken(token);
		if(confirmationToken != null) {
			NguoiDung nguoiDung = nguoiDungService.timTheoEmail(confirmationToken.getNguoiDung().getEmail());
			nguoiDungService.themNguoiDung(nguoiDung);
			return "account-verrified";
		}else {
			
		}
		
		return null;
	}

}
