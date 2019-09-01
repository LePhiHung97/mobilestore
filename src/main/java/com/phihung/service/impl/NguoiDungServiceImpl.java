package com.phihung.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.phihung.dao.INguoiDungDao;
import com.phihung.entity.NguoiDung;
import com.phihung.service.INguoiDungService;

@Service
public class NguoiDungServiceImpl implements INguoiDungService {

	@Autowired
	INguoiDungDao nguoiDungDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public void themNguoiDung(NguoiDung nguoiDung) {
		nguoiDung.setMatkhau(passwordEncoder.encode(nguoiDung.getMatkhau()));
		nguoiDungDao.themNguoiDung(nguoiDung);
	}

	public boolean kiemTraNguoiDung(NguoiDung nguoiDungTemp,NguoiDung existNguoiDung) {
		if (existNguoiDung != null
				&& passwordEncoder.matches(nguoiDungTemp.getMatkhau(), existNguoiDung.getMatkhau())) {
			return true;
		}
		return false;
		
	}

	public NguoiDung timTheoTenDangNhap(String tenDangNhap) {
		NguoiDung nguoiDung = nguoiDungDao.timTheoTenDangNhap(tenDangNhap);
		return nguoiDung;
	}
	
	private boolean emailExist(String email) {
		NguoiDung nguoiDung = timTheoEmail(email);
		if(nguoiDung != null)
			return true;
		return false;
	}

	public NguoiDung timTheoEmail(String email) {
		return nguoiDungDao.timTheoEmail(email);
	}

	public boolean dangKiTaiKhoan(NguoiDung nguoiDung) {
		nguoiDung.setMatkhau(passwordEncoder.encode(nguoiDung.getMatkhau()));
		return nguoiDungDao.dangKiTaiKhoan(nguoiDung);
	}

	public NguoiDung timTheoToken(String verificationToken) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createVerificationToken(NguoiDung nguoidung, String token) {
		// TODO Auto-generated method stub
		
	}
	
	
}
