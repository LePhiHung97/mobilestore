package com.phihung.service;

import com.phihung.entity.NguoiDung;
import com.phihung.entity.VerificationToken;

public interface IVerificationTokenService {
	VerificationToken findByToken(String token);
	VerificationToken findByUser(NguoiDung nguoidung);
	void save(VerificationToken token);
}
