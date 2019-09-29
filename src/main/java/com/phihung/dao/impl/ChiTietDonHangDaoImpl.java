package com.phihung.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.phihung.dao.IChiTietDonHangDao;
import com.phihung.entity.ChiTietDonHang;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietDonHangDaoImpl implements IChiTietDonHangDao {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void themChiTietDonHang(ChiTietDonHang ctdh) {
		Session session = sessionFactory.getCurrentSession();
		session.save(ctdh);
	}

}
