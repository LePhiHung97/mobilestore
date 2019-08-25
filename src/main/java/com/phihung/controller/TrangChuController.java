package com.phihung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phihung.entity.DanhMucSanPham;
import com.phihung.entity.SanPham;
import com.phihung.service.IDanhMucService;
import com.phihung.service.ISanPhamService;

@Controller
public class TrangChuController {
	
	@Autowired
	ISanPhamService sanPhamService;
	
	@Autowired
	IDanhMucService danhMucService;
	
	@RequestMapping(value="/")
	public String TrangChu(ModelMap modelMap) {
		List<SanPham> sanPhams =  sanPhamService.layDanhSachSanPham();
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.layDanhSachDanhMuc();
		
		modelMap.addAttribute("sanPhams", sanPhams);
		modelMap.addAttribute("danhMucSanPhams", danhMucSanPhams);
		return "home";
	}
	
}
