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

import com.phihung.dao.IMauSanPhamDao;
import com.phihung.entity.DanhMucSanPham;
import com.phihung.entity.MauSanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MauSanPhamDaoImpl implements IMauSanPhamDao {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<MauSanPham> LayDanhSachMau() {
		List<MauSanPham> mausanphams = new ArrayList<MauSanPham>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(" select mau from mausanpham mau ");

			mausanphams = (List<MauSanPham>) query.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mausanphams;
	}

}
