package com.phihung.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String submitLogin(@ModelAttribute("nguoidung") NguoiDung nguoiDung, BindingResult bindingResult,
			ModelMap model,HttpSession session) {
		dangNhapValidator.validate(nguoiDung, bindingResult);
		if (bindingResult.hasErrors())
			return "/login";

		NguoiDung existNguoiDung = nguoiDungService.timTheoEmail(nguoiDung.getEmail());
		if (existNguoiDung != null && nguoiDungService.kiemTraNguoiDung(nguoiDung, existNguoiDung)) {
			if (existNguoiDung.getChucvu().getTenchucvu().equals("ADMIN")) {
				session.setAttribute("user", existNguoiDung);
				return "redirect:/manage";
			} else {
				session.setAttribute("user", existNguoiDung);
				return "redirect:/";
			}
		} else {
			model.addAttribute("incorrect_account", "Tài khoản hoặc mật khẩu không chính xác!");
			return "/login";
		}
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
			model.addAttribute("email_exists","Email đã tồn tại !");
			return "/registration";
		} else {
			nguoiDungService.themNguoiDung(nguoiDung);
			ConfirmationToken confirmationToken = new ConfirmationToken(nguoiDung);
			confirmationTokenService.add(confirmationToken);

			model.addAttribute("email", nguoiDung.getEmail());
			String message = "To confirm your account, please click here : "
					+ "http://localhost:8080/mobilestore/confirm-account?token=" + confirmationToken.getToken();
			EmailUtil.sendMail(nguoiDung.getEmail(), message);
			return "confirm-mail";
		}

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}

	@RequestMapping(value = "/confirm-account", method = RequestMethod.GET)
	public String confirmAccount(@RequestParam String token, ModelMap model) {

		ConfirmationToken confirmToken = confirmationTokenService.findByConfirmationToken(token);

		if (confirmToken != null) {
			NguoiDung nguoiDung = nguoiDungService.timTheoEmail(confirmToken.getNguoiDung().getEmail());
			if (nguoiDung != null) {
				return "confirm-success";
			} else {
				model.addAttribute("user-confirm-invalid", "Tài khoản xác thực email không đúng !");
				return "confirm-fail";
			}
		} else {
			model.addAttribute("token-invalid", "Đường dẫn không chính xác ! ");
			return "confirm-fail";
		}
	}

}
