package com.phihung.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.phihung.entity.DanhMucSanPham;
import com.phihung.entity.NguoiDung;
import com.phihung.entity.SanPham;
import com.phihung.service.IDanhMucService;
import com.phihung.service.ISanPhamService;

@Controller
public class BaseController {
	
	@Autowired
	ISanPhamService sanPhamService;
	
	@Autowired
	IDanhMucService danhMucService;
	
	@RequestMapping(value="/")
	public String TrangChu(ModelMap modelMap,HttpSession session) {
		List<SanPham> sanPhams =  sanPhamService.layDanhSachSanPham();
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.layDanhSachDanhMuc();
		
		modelMap.addAttribute("sanPhams", sanPhams);
		modelMap.addAttribute("danhMucSanPhams", danhMucSanPhams);
		NguoiDung nguoiDung = (NguoiDung) session.getAttribute("user");
		if(nguoiDung != null)
			modelMap.addAttribute("user", nguoiDung.getTendangnhap());
		return "home";
	}
	@RequestMapping(value="/access-denied")
	public String AccessDenied(ModelMap modelMap) {
		return "access-denied";
	}
	
}
