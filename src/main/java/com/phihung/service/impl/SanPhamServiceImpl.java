package com.phihung.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phihung.dao.SanPhamDao;
import com.phihung.entity.SanPham;
import com.phihung.service.SanPhamService;

@Service
public class SanPhamServiceImpl implements SanPhamService {

	@Autowired
	SanPhamDao sanPhamDao;
	
	public List<SanPham> layDanhSachSanPham() {
		return sanPhamDao.layDanhSachSanPham();
	}
	
}
