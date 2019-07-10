package com.phihung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phihung.entity.DanhMucSanPham;
import com.phihung.entity.SanPham;
import com.phihung.service.DanhMucService;
import com.phihung.service.SanPhamService;

@Controller
public class TrangChuController {
	
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucService danhMucService;
	
	@RequestMapping(value="/")
	public String TrangChu(ModelMap modelMap) {
		List<SanPham> sanPhams =  sanPhamService.layDanhSachSanPham();
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.layDanhSachDanhMuc();
		
		modelMap.addAttribute("sanPhams", sanPhams);
		modelMap.addAttribute("danhMucSanPhams", danhMucSanPhams);
		return "trangchu";
	}
	
}
