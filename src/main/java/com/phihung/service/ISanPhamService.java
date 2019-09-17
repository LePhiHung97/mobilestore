package com.phihung.service;

import java.util.List;

import com.phihung.entity.SanPham;

public interface ISanPhamService {
	public List<SanPham> layDanhSachSanPham();
	
	public List<SanPham>LaySanPhamTheoMaDanhMuc(int madanhmuc);
	
	public SanPham LayChiTietSanPhamTheoMa(int masanpham);
	
	public void XoaSanPham(int masanpham);
	
}
 