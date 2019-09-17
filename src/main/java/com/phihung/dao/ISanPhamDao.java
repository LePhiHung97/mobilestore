package com.phihung.dao;

import java.util.List;

import com.phihung.entity.SanPham;

public interface ISanPhamDao {
	public List<SanPham> layDanhSachSanPham();
	
	public List<SanPham>LaySanPhamTheoMaDanhMuc(int madanhmuc);
	
	public SanPham LayChiTietSanPhamTheoMa(int masanpham);
	
	public void xoaSanPham(int masanpham);
}
