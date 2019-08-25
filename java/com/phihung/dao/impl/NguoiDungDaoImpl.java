package com.phihung.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.phihung.dao.INguoiDungDao;
import com.phihung.entity.NguoiDung;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NguoiDungDaoImpl implements INguoiDungDao {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void themNguoiDung(NguoiDung nguoiDung) {
		Session session = sessionFactory.getCurrentSession();
		session.save(nguoiDung);
	}

	public boolean kiemTraNguoiDung(NguoiDung nguoiDung) {
		return true;
	}

	public int layMaNguoiDungMoiNhat() {
		int maNguoiDungMax;
		try {
			Session session = sessionFactory.getCurrentSession();
			maNguoiDungMax = (Integer) session.createQuery("select max(manguoidung) from nguoidung ").uniqueResult();
		} catch (Exception ex) {
			return 0;
		}
		return maNguoiDungMax;
	}

	@Transactional
	public NguoiDung timTheoTenDangNhap(String tenDangNhap) {
		NguoiDung nguoiDung = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			nguoiDung = session.get(NguoiDung.class, tenDangNhap);
		} catch (Exception ex) {
			System.out.println("Can't not find user with this username!");
			return null;
		}
		return nguoiDung;
	}

	@Transactional
	public NguoiDung timTheoEmail(String email) {
		NguoiDung nguoiDung = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			nguoiDung = session.get(NguoiDung.class, email);
		} catch (Exception ex) {
			System.out.println("Can't not find user with this email!");
			return null;
		}
		return nguoiDung;
	}

	public boolean dangKiTaiKhoan(NguoiDung nguoiDung) {
		Session session = sessionFactory.getCurrentSession();
		Integer maNguoiDung = (Integer) session.save(nguoiDung);
		if(maNguoiDung >0)
			return true;
		return false;
	}

	

}
