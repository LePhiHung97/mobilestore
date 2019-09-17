package com.phihung.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phihung.dao.ISizeDao;
import com.phihung.entity.MauSanPham;
import com.phihung.entity.Size;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SizeDaoImpl implements ISizeDao {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<Size> LayDanhSachSize() {
		List<Size> sizes = new ArrayList<Size>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(" select sz from size sz ");
			sizes = (List<Size>) query.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sizes;
	}

}
