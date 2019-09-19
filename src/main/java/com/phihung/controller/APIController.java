package com.phihung.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
			@RequestParam int machitietsanpham, HttpSession httpSession) {
		System.out.println("THem vao gio hang");

		// Nếu session chưa tồn tại -> Thêm mới
		if (null == httpSession.getAttribute("mycart")) {
			List<GioHang> lstGioHang = new ArrayList<GioHang>();
			GioHang objGioHang = new GioHang(masanpham, masize, mamau, tensp, giatien, tenmau, tensize, 1,
					machitietsanpham);
			lstGioHang.add(objGioHang);
			httpSession.setAttribute("mycart", lstGioHang);

			List<GioHang> test = (List<GioHang>) httpSession.getAttribute("mycart");
			for(GioHang i : test)
				System.out.println(i.getMasp() +"-"+i.getTenmau() + "-"+i.getTensize()+"-"+i.getSoluong());
			return "";
		}
		// Nếu nhấn thêm một sản phẩm 2 lần ( tức là mua với số lượng là 2)
		else {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("mycart");

			int vitrisanpham = KiemTraSanPhamTonTai(gioHangs, httpSession, masanpham, masize, mamau);
			if (vitrisanpham == -1) {
				GioHang objGioHang = new GioHang(masanpham, masize, mamau, tensp, giatien, tenmau, tensize, 1,
						machitietsanpham);
				gioHangs.add(objGioHang);
			} else {
				int soluongcu = gioHangs.get(vitrisanpham).getSoluong();
				gioHangs.get(vitrisanpham).setSoluong(soluongcu + 1);
			}

			List<GioHang> gioHangTest = (List<GioHang>) httpSession.getAttribute("mycart");
			for(GioHang i : gioHangTest)
				System.out.println(i.getMasp() +"-"+i.getTenmau() + "-"+i.getTensize()+"-"+i.getSoluong());
			return "";
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

}
