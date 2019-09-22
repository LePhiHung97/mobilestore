package com.phihung.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phihung.entity.ChiTietSanPham;
import com.phihung.entity.DanhMucSanPham;
import com.phihung.entity.GioHang;
import com.phihung.entity.MauSanPham;
import com.phihung.entity.SanPham;
import com.phihung.entity.Size;
import com.phihung.service.ISanPhamService;

@Controller
@RequestMapping("api/")
@SessionAttributes("mycart")
public class APIController {

	@Autowired
	ISanPhamService sanPhamService;

	@GetMapping("delete-product")
	@ResponseBody
	public void XoaSanPham(@RequestParam int masanpham) {
		System.out.println("Xoa san pham");
		sanPhamService.XoaSanPham(masanpham);
	}

	@PostMapping(path = "add-product", produces = "application/json;charset=utf8")
	@ResponseBody
	public void ThemSanPham(@RequestParam String dataJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		JsonNode jsonObject;
		try {
			jsonObject = objectMapper.readTree(dataJson);
			SanPham sanpham = objectMapper.readValue(dataJson, SanPham.class);
			DanhMucSanPham danhmucsanpham = new DanhMucSanPham();
			danhmucsanpham.setMadanhmuc(1);

			JsonNode jsonChiTiet = jsonObject.get("chitietsanpham");
			Set<ChiTietSanPham> chiTietSanPhamSet = new HashSet<ChiTietSanPham>();
			for (JsonNode objChiTiet : jsonChiTiet) {
				ChiTietSanPham chiTietSanPham = new ChiTietSanPham();

				MauSanPham mauSanPham = new MauSanPham();
				mauSanPham.setMamau(objChiTiet.get("mausanpham").asInt());

				Size size = new Size();
				size.setMasize(objChiTiet.get("size").asInt());

				chiTietSanPham.setMau(mauSanPham);
				chiTietSanPham.setSize(size);
				chiTietSanPham.setSoluong(objChiTiet.get("soluong").asInt());

				chiTietSanPhamSet.add(chiTietSanPham);
			}
			String tensanpham = jsonObject.get("tensanpham").asText();
			String giatien = jsonObject.get("giatien").asText();
			String hinhsanpham = jsonObject.get("hinhsanpham").asText();

			sanpham.setChitietsanpham(chiTietSanPhamSet);
			sanpham.setDanhMucSanPham(danhmucsanpham);
			sanpham.setTensanpham(tensanpham);
			sanpham.setGiatien(giatien);
			sanpham.setHinhsanpham(hinhsanpham);

			sanPhamService.themSanPham(sanpham);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@GetMapping("add-to-cart")
	@ResponseBody
	public String ThemSanPhamVaoGioHang(@RequestParam int masanpham, @RequestParam String tensp,
			@RequestParam int mamau, @RequestParam String tenmau, @RequestParam int masize,
			@RequestParam String tensize, @RequestParam String giatien, @RequestParam int soluong,
			@RequestParam int machitietsanpham,@RequestParam String hinhsanpham, HttpSession httpSession) {
			

		// Nếu session chưa tồn tại -> Thêm mới
		if (null == httpSession.getAttribute("mycart")) {
			List<GioHang> lstGioHang = new ArrayList<GioHang>();
			GioHang objGioHang = new GioHang(masanpham, masize, mamau, tensp, giatien, tenmau, tensize, 1,
					machitietsanpham,hinhsanpham);
			lstGioHang.add(objGioHang);
			httpSession.setAttribute("mycart", lstGioHang);

			List<GioHang> totalProduct = (List<GioHang>) httpSession.getAttribute("mycart");
			for(GioHang sanpham : totalProduct)
				System.out.println(sanpham.getMasp() +"-"+sanpham.getTenmau() + "-"+sanpham.getTensize()+"-"+sanpham.getSoluong());
			return totalProduct.size()+"";
		}
		// Nếu nhấn thêm một sản phẩm 2 lần ( tức là mua với số lượng là 2)
		else {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("mycart");

			int vitrisanpham = KiemTraSanPhamTonTai(gioHangs, httpSession, masanpham, masize, mamau);
			if (vitrisanpham == -1) {
				GioHang objGioHang = new GioHang(masanpham, masize, mamau, tensp, giatien, tenmau, tensize, 1,
						machitietsanpham,hinhsanpham);
				gioHangs.add(objGioHang);
			} else {
				int soluongcu = gioHangs.get(vitrisanpham).getSoluong();
				gioHangs.get(vitrisanpham).setSoluong(soluongcu + 1);
			}

			List<GioHang> totalProduct = (List<GioHang>) httpSession.getAttribute("mycart");
			for(GioHang product : totalProduct)
				System.out.println(product.getMasp() +"-"+product.getTenmau() + "-"+product.getTensize()+"-"+product.getSoluong());
			return totalProduct.size() +"";
		}
	}

	// Kiểm tra sản phẩm tồn tại trong giỏ hàng
	private int KiemTraSanPhamTonTai(List<GioHang> gioHangList, HttpSession httpSession, int masp, int masize,
			int mamau) {
		for (int i = 0; i < gioHangList.size(); i++) {
			if (gioHangList.get(i).getMasp() == masp && gioHangList.get(i).getMasize() == masize
					&& gioHangList.get(i).getMamau() == mamau)
				return i;
		}
		return -1;
	}
	
	//Xóa sản phẩm trong giỏ hàng
	@GetMapping("delete-cart")
    @ResponseBody
	public String XoaSanPhamTrongGio(HttpSession httpSession, @RequestParam int masp, @RequestParam int mamau,
			@RequestParam int masize) {
		List<GioHang> gioHangs = null;
		if (null != httpSession.getAttribute("mycart")) {
			 gioHangs = (List<GioHang>) httpSession.getAttribute("mycart");
			int vitrisanpham = KiemTraSanPhamTonTai(gioHangs, httpSession, masp, masize, mamau);
			gioHangs.remove(vitrisanpham);
		}
		return gioHangs.size()+"";
	}
	
	//Cập nhật số sản phẩm trong giỏ hàng nếu xóa 
	@GetMapping("update-cart")
	@ResponseBody
    public void CapNhatGioHang(HttpSession httpSession, @RequestParam int soluong, @RequestParam int masp, @RequestParam int mamau, @RequestParam int masize){
		if (null != httpSession.getAttribute("mycart")) {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("mycart");
			int vitrisanpham = KiemTraSanPhamTonTai(listGioHang, httpSession, masp, masize, mamau);
			listGioHang.get(vitrisanpham).setSoluong(soluong);
		}
    }
	
	@GetMapping("update-session-cart")
	@ResponseBody
	public String soLuongSanPhamTrongGio(HttpSession httpSession,ModelMap model) {
		List<GioHang> gioHangs = null;
		if (null != httpSession.getAttribute("mycart")) {
			gioHangs = (List<GioHang>) httpSession.getAttribute("mycart");
		}
		return gioHangs.size() +"";
	}
	
	
	

}
