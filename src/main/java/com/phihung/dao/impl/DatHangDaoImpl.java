package com.phihung.dao.impl;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.phihung.dao.IDatHangDao;
import com.phihung.entity.DonHang;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DatHangDaoImpl implements IDatHangDao{

	@Autowired
	SessionFactory sessionFactory;

	
	@Transactional
	public int themDonDatHang(DonHang datHang) {
		Session session = sessionFactory.getCurrentSession();
		Integer maDatHang = (Integer) session.save(datHang);
		return maDatHang;
	}



}
