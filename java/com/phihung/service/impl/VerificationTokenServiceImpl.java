package com.phihung.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phihung.dao.IVerificationTokenDao;
import com.phihung.entity.NguoiDung;
import com.phihung.entity.VerificationToken;
import com.phihung.service.IVerificationTokenService;

@Service
public class VerificationTokenServiceImpl implements IVerificationTokenService {

	@Autowired
	IVerificationTokenDao verificationTokenDao;

	public VerificationToken findByToken(String token) {
		return verificationTokenDao.findByToken(token);
	}

	public VerificationToken findByUser(NguoiDung nguoidung) {
		return verificationTokenDao.findByUser(nguoidung);
	}

	public void save(VerificationToken token) {
		verificationTokenDao.save(token);
		
	}
}
