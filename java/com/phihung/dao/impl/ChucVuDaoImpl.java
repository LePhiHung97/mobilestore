package com.phihung.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.phihung.dao.IChucVuDao;
import com.phihung.entity.ChucVu;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChucVuDaoImpl implements IChucVuDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public ChucVu layTheoMaChucVu(int maChucVu) {
		ChucVu chucVu = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			chucVu = session.get(ChucVu.class, maChucVu);
		} catch (Exception ex) {
			return null;
		}
		return chucVu;
	}

	@Transactional
	public ChucVu layTheoTenChucVu(String tenChucVu) {
		ChucVu chucVu = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			chucVu = session.get(ChucVu.class, tenChucVu);
		} catch (Exception ex) {
			return null;
		}
		return chucVu;
	}
}
