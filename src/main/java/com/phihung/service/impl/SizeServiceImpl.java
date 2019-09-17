package com.phihung.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phihung.dao.ISizeDao;
import com.phihung.entity.Size;
import com.phihung.service.ISizeService;


@Service
public class SizeServiceImpl implements ISizeService{

	@Autowired
	ISizeDao sizeDao;
	
	public List<Size> layDanhSachSize() {
		return sizeDao.LayDanhSachSize();
	}

}
