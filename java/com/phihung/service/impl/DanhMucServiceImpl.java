package com.phihung.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phihung.dao.DanhMucDao;
import com.phihung.entity.DanhMucSanPham;
import com.phihung.service.DanhMucService;

@Service
public class DanhMucServiceImpl implements DanhMucService {

	@Autowired
	DanhMucDao danhMucDao;
	
	public List<DanhMucSanPham> layDanhSachDanhMuc() {
		return danhMucDao.layDanhSachDanhMuc();
	}
	
}
