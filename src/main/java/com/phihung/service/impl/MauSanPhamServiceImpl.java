package com.phihung.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phihung.dao.IMauSanPhamDao;
import com.phihung.entity.MauSanPham;
import com.phihung.service.IMauSanPhamService;


@Service
public class MauSanPhamServiceImpl implements IMauSanPhamService {

	@Autowired
	IMauSanPhamDao mauSanPhamDao;
	
	public List<MauSanPham> layDanhSachMau() {
		return mauSanPhamDao.LayDanhSachMau();
	}

}
