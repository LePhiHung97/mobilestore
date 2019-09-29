package com.phihung.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phihung.entity.ChiTietDonHang;
import com.phihung.entity.DonHang;
import com.phihung.entity.GioHang;
import com.phihung.entity.NguoiDung;
import com.phihung.service.IChiTietDonHangService;
import com.phihung.service.IChiTietSanPhamService;
import com.phihung.service.IDatHangService;
import com.phihung.service.ISanPhamService;
import com.phihung.validator.DatHangValidator;

@Controller
public class ThanhToanController {

	@Autowired(required=true)
	DatHangValidator dathangValidator;
	
	@Autowired
	IDatHangService datHangService;	
	
	@Autowired
	ISanPhamService sanPhamService;
	
	@Autowired
	IChiTietSanPhamService chitietsanphamService;
	
	@Autowired
	IChiTietDonHangService chiTietDonHangService;
	
	
	@RequestMapping(value="/payment")
	public String Default(HttpSession httpSession,ModelMap modelMap) {
		if (null != httpSession.getAttribute("mycart") && null != httpSession.getAttribute("user")) {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("mycart");
			modelMap.addAttribute("soluongsanphammua", gioHangs.size());
			modelMap.addAttribute("gioHangs", gioHangs);
			int tongTien = 0;
			for(GioHang item : gioHangs)
				tongTien += Integer.parseInt(item.getGiatien());
			modelMap.addAttribute("tongtien",tongTien);
			modelMap.addAttribute("dathang", new DonHang());
			return "payment";
		}
		else
			return "/mycart";
	}
	
	@RequestMapping(value="/payment",method=RequestMethod.POST)	
	public String xacNhanDatHang(@ModelAttribute("dathang") DonHang donDatHang, BindingResult bindingResult,
			ModelMap model,HttpSession httpSession) {
		if (null != httpSession.getAttribute("mycart") && null != httpSession.getAttribute("user")) {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("mycart");
			NguoiDung nguoiDung = (NguoiDung) httpSession.getAttribute("user");
		
			if (bindingResult.hasErrors())
				return "/payment";
			
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			System.out.println(formatter.format(date));
			
			donDatHang.setNguoidung(nguoiDung);
			donDatHang.setNgaytao(date.toString());
			int maDatHang = datHangService.themDonDatHang(donDatHang);
			if(maDatHang > 0)
				System.out.println("Them don dat hang thanh cong , ma dat hang : " + maDatHang);
			
			ChiTietDonHang chiTietDonHang = null;
			
			for(GioHang item : gioHangs) {
				chiTietDonHang = new ChiTietDonHang();
				chiTietDonHang.setDonhang(donDatHang);
				chiTietDonHang.setChitietsanpham(chitietsanphamService.layChiTietSanPhamTheoMa(item.getMachitietsanpham()));
				chiTietDonHang.setSoluong(item.getSoluong());
				chiTietDonHang.setGiatien(item.getGiatien());
				int thanhTien = item.getSoluong() * Integer.parseInt(item.getGiatien());
				chiTietDonHang.setThanhtien(thanhTien +"");
				
				chiTietDonHangService.themChiTietDonHang(chiTietDonHang);
			}
			
			httpSession.removeAttribute("mycart");
			return "redirect:/";
		}
		return "redirect:/home";
	}
}
