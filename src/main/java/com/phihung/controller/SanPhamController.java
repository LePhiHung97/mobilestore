package com.phihung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phihung.entity.DanhMucSanPham;
import com.phihung.entity.MauSanPham;
import com.phihung.entity.SanPham;
import com.phihung.entity.Size;
import com.phihung.service.IDanhMucService;
import com.phihung.service.IMauSanPhamService;
import com.phihung.service.ISanPhamService;
import com.phihung.service.ISizeService;

@Controller
public class SanPhamController {

	@Autowired
	ISanPhamService sanPhamService;

	@Autowired
	IDanhMucService danhMucService;
	
	@Autowired
	ISizeService sizeService;
	
	@Autowired
	IMauSanPhamService mauSanPhamService;
	

	@RequestMapping(value = "/product/{madanhmuc}/{tendanhmuc}")
	public String laySanPhamTheoDanhMuc(ModelMap modelMap, @PathVariable int madanhmuc,
			@PathVariable String tendanhmuc) {
		List<DanhMucSanPham> danhMucSanPhamList = danhMucService.layDanhSachDanhMuc();
		modelMap.addAttribute("danhmucsanpham", danhMucSanPhamList);

		List<SanPham> sanPhamList = sanPhamService.LaySanPhamTheoMaDanhMuc(madanhmuc);
		modelMap.addAttribute("danhsachsanpham", sanPhamList);
		modelMap.addAttribute("tendanhmuc", tendanhmuc);

		List<DanhMucSanPham> danhMucSanPhams = danhMucService.layDanhSachDanhMuc();
		modelMap.addAttribute("danhMucSanPhams", danhMucSanPhams);

		return "product";
	}

	@RequestMapping(value = "/list-product")
	public String layDanhSachSanpham(ModelMap modelMap) {
		List<SanPham> sanphams = sanPhamService.layDanhSachSanPham();
		modelMap.addAttribute("sanphams", sanphams);

		List<DanhMucSanPham> danhMucSanPhams = danhMucService.layDanhSachDanhMuc();
		modelMap.addAttribute("danhMucSanPhams", danhMucSanPhams);

		double tongSoPage = Math.ceil((double) sanphams.size() / 5);
		modelMap.addAttribute("tongsopage", tongSoPage);

		List<Size> sizes = sizeService.layDanhSachSize();
		modelMap.addAttribute("sizes", sizes);

		List<MauSanPham> mauSanPhams = mauSanPhamService.layDanhSachMau();
		modelMap.addAttribute("mauSanPhams", mauSanPhams);

		return "list-product";
	}

}
