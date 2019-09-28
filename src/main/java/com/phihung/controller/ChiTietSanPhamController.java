package com.phihung.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.phihung.entity.ChiTietSanPham;
import com.phihung.entity.DanhMucSanPham;
import com.phihung.entity.GioHang;
import com.phihung.entity.SanPham;
import com.phihung.service.IDanhMucService;
import com.phihung.service.ISanPhamService;

@Controller
@SessionAttributes("cart-list")
public class ChiTietSanPhamController {
	@Autowired
    ISanPhamService sanPhamService;

    @Autowired
    IDanhMucService danhMucService;

    @GetMapping("/detail/{masanpham}")
    public String Default(@PathVariable int masanpham,ModelMap modelMap,HttpSession httpSession){
    	
        SanPham sanPham =  sanPhamService.LayChiTietSanPhamTheoMa(masanpham);
        Set<ChiTietSanPham> chiTietSanPham = sanPham.getChitietsanpham();
        List<DanhMucSanPham> danhMucSanPhamList = danhMucService.layDanhSachDanhMuc();

        if(null != httpSession.getAttribute("mycart")) {
            List<GioHang> gioHangList = (List<GioHang>) httpSession.getAttribute("mycart");
            modelMap.addAttribute("soluongsanphammua",gioHangList.size());
        }
        modelMap.addAttribute("sanpham",sanPham);
        modelMap.addAttribute("danhmucsanpham",danhMucSanPhamList);

        return "product-detail";
    }
    
    
}
