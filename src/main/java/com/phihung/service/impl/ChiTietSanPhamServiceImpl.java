package com.phihung.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phihung.dao.IChiTietSanPhamDao;
import com.phihung.entity.ChiTietSanPham;
import com.phihung.service.IChiTietSanPhamService;

@Service
public class ChiTietSanPhamServiceImpl implements IChiTietSanPhamService {

	
	@Autowired 
	IChiTietSanPhamDao chitietsanphamDao;
	
	public ChiTietSanPham layChiTietSanPhamTheoMa(int machitietsanpham) {
		return chitietsanphamDao.layChiTietSanPhamTheoMa(machitietsanpham);
	}

}
