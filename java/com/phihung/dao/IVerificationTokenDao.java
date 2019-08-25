package com.phihung.dao;

import com.phihung.entity.NguoiDung;
import com.phihung.entity.VerificationToken;

public interface IVerificationTokenDao {
	VerificationToken findByToken(String token);
	VerificationToken findByUser(NguoiDung nguoidung);
	void save(VerificationToken token);
}
