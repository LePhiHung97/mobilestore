package com.phihung.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phihung.dao.IDanhMucDao;
import com.phihung.entity.DanhMucSanPham;
import com.phihung.service.IDanhMucService;

@Service
public class DanhMucServiceImpl implements IDanhMucService {

	@Autowired
	IDanhMucDao danhMucDao;
	
	public List<DanhMucSanPham> layDanhSachDanhMuc() {
		return danhMucDao.layDanhSachDanhMuc();
	}
	
}
