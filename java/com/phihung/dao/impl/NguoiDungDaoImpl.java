package com.phihung.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.phihung.dao.NguoiDungDao;
import com.phihung.entity.NguoiDung;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NguoiDungDaoImpl implements NguoiDungDao {
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

}
