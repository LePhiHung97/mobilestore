package com.phihung.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phihung.dao.ISanPhamDao;
import com.phihung.entity.SanPham;
import com.phihung.service.ISanPhamService;

@Service
public class SanPhamServiceImpl implements ISanPhamService {

	@Autowired
	ISanPhamDao sanPhamDao;
	
	public List<SanPham> layDanhSachSanPham() {
		return sanPhamDao.layDanhSachSanPham();
	}
	
}
