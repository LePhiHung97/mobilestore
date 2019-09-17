package com.phihung.dao;

import java.util.List;

import com.phihung.entity.SanPham;

public interface ISanPhamDao {
	public List<SanPham> layDanhSachSanPham();
	
	public void xoaSanPham();
	
}
