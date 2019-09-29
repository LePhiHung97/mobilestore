package com.phihung.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phihung.dao.IDatHangDao;
import com.phihung.entity.DonHang;
import com.phihung.service.IDatHangService;

@Service
public class DatHangServiceImpl implements IDatHangService {
	
	@Autowired
	IDatHangDao datHangDao;
	
	public int themDonDatHang(DonHang datHang) {
		return datHangDao.themDonDatHang(datHang);
	}

}
