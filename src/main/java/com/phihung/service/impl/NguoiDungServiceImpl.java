package com.phihung.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.phihung.dao.INguoiDungDao;
import com.phihung.dao.IVerificationTokenDao;
import com.phihung.entity.NguoiDung;
import com.phihung.entity.VerificationToken;
import com.phihung.service.INguoiDungService;

@Service
public class NguoiDungServiceImpl implements INguoiDungService {

	@Autowired
	INguoiDungDao nguoiDungDao;
	
	@Autowired
	IVerificationTokenDao verificationTokenDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public void themNguoiDung(NguoiDung nguoiDung) {
		nguoiDung.setMatkhau(passwordEncoder.encode(nguoiDung.getMatkhau()));
		nguoiDungDao.themNguoiDung(nguoiDung);
	}

	public boolean kiemTraNguoiDung(NguoiDung nguoiDung) {
		return false;
	}

	public NguoiDung timTheoTenDangNhap(String tenDangNhap) {
		NguoiDung nguoiDung = nguoiDungDao.timTheoTenDangNhap(tenDangNhap);
		return nguoiDung;
	}

	public void createVerificationToken(NguoiDung nguoidung, String token) {
		VerificationToken myToken = new VerificationToken(token,nguoidung);
		verificationTokenDao.save(myToken);
		
	}

	public NguoiDung timTheoToken(String token) {
		NguoiDung nguoidung = verificationTokenDao.findByToken(token).getNguoidung();
		return nguoidung;
	}

	public VerificationToken getVerificationToken(String token) {
		return verificationTokenDao.findByToken(token);
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
		if(emailExist(nguoiDung.getEmail())) {
			return false;
		}
		return nguoiDungDao.dangKiTaiKhoan(nguoiDung);
	}
	
	
}
