package com.phihung.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phihung.dao.IChiTietDonHangDao;
import com.phihung.entity.ChiTietDonHang;
import com.phihung.service.IChiTietDonHangService;

@Service
public class ChiTietDonHangServiceImpl implements IChiTietDonHangService {

	@Autowired
	IChiTietDonHangDao chiTietDonHangDao;
	
	public void themChiTietDonHang(ChiTietDonHang ctdh) {
		chiTietDonHangDao.themChiTietDonHang(ctdh);
		
	}
	
}
