package com.phihung.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phihung.entity.GioHang;

@Controller
public class ThanhToanController {

	@RequestMapping(value="/payment")
	public String Default(HttpSession httpSession,ModelMap modelMap) {
		if (null != httpSession.getAttribute("mycart")) {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("mycart");
			modelMap.addAttribute("soluongsanphammua", gioHangs.size());
			modelMap.addAttribute("gioHangs", gioHangs);
			
		}
		return "payment";
		
		
		
	}
}
