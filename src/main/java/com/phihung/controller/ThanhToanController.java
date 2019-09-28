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
			int tongTien = 0;
			for(GioHang item : gioHangs)
				tongTien += Integer.parseInt(item.getGiatien());
			modelMap.addAttribute("tongtien",tongTien);
			return "payment";
		}
		else
			return "/mycart";
		
		
		
		
	}
}
