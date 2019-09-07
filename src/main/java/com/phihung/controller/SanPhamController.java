package com.phihung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phihung.entity.DanhMucSanPham;
import com.phihung.entity.SanPham;
import com.phihung.service.IDanhMucService;
import com.phihung.service.ISanPhamService;

@Controller
public class SanPhamController {
	
	@Autowired
	ISanPhamService sanPhamService;
	
	@Autowired 
	IDanhMucService danhMucService;
	
	@RequestMapping(value="/product/{madanhmuc}/{tendanhmuc}")
	public String laySanPhamTheoDanhMuc(ModelMap modelMap, @PathVariable int madanhmuc,@PathVariable String tendanhmuc) {
		List<DanhMucSanPham> danhMucSanPhamList= danhMucService.layDanhSachDanhMuc();
        modelMap.addAttribute("danhmucsanpham",danhMucSanPhamList);

        List<SanPham> sanPhamList = sanPhamService.LaySanPhamTheoMaDanhMuc(madanhmuc);
        modelMap.addAttribute("danhsachsanpham",sanPhamList);
        modelMap.addAttribute("tendanhmuc",tendanhmuc);
        
        List<DanhMucSanPham> danhMucSanPhams = danhMucService.layDanhSachDanhMuc();
		modelMap.addAttribute("danhMucSanPhams", danhMucSanPhams);
        
        
        return "product";
	}
	
}
