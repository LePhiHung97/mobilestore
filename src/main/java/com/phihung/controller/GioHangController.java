package com.phihung.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phihung.entity.GioHang;

@Controller
public class GioHangController {
	@RequestMapping(value="/mycart")
    public String DanhSachSanPhamTrongGio(HttpSession httpSession , ModelMap modelMap){
		if (null != httpSession.getAttribute("mycart")) {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("mycart");
			modelMap.addAttribute("soluongsanphammua", gioHangs.size());
			modelMap.addAttribute("gioHangs", gioHangs);
			return "mycart";
		}
        return "redirect:/";
    }
}
