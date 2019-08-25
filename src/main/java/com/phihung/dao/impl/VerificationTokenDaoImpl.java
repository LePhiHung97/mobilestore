package com.phihung.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import com.phihung.dao.IVerificationTokenDao;
import com.phihung.entity.NguoiDung;
import com.phihung.entity.VerificationToken;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class VerificationTokenDaoImpl implements IVerificationTokenDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public VerificationToken findByToken(String token) {
		VerificationToken verificationToken = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			verificationToken = session.get(VerificationToken.class, token);
		} catch (Exception ex) {
			System.out.println("Can't not find verification token");
			return null;
		}
		return verificationToken;
	}

	@Transactional
	public VerificationToken findByUser(NguoiDung nguoidung) {
		VerificationToken verificationToken = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			verificationToken = session.get(VerificationToken.class, nguoidung);
		} catch (Exception ex) {
			System.out.println("Can't not find verification token");
			return null;
		}
		return verificationToken;
	}

	@Transactional
	public void save(VerificationToken token) {
		Session session = sessionFactory.getCurrentSession();
		session.save(token);
		
	}

}
