package com.phihung.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.phihung.dao.NguoiDungDao;
import com.phihung.entity.NguoiDung;
import com.phihung.service.NguoiDungService;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {

    @Autowired
    NguoiDungDao nguoiDungDao;

    public void themNguoiDung(NguoiDung nguoiDung) {
	nguoiDungDao.themNguoiDung(nguoiDung);
    }

    public void kiemTraNguoiDung(NguoiDung nguoiDung) {
	// TODO Auto-generated method stub
	
    }

}
