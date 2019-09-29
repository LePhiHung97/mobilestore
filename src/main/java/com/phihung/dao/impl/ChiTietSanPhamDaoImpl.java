package com.phihung.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phihung.dao.IChiTietSanPhamDao;
import com.phihung.entity.ChiTietSanPham;
import com.phihung.entity.SanPham;


@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietSanPhamDaoImpl implements IChiTietSanPhamDao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Transactional
	public ChiTietSanPham layChiTietSanPhamTheoMa(int machitietsanpham) {
		Session session = sessionFactory.getCurrentSession();
		String query = "from chitietsanpham ctsp where ctsp.machitietsanpham =" + machitietsanpham;
		ChiTietSanPham chiTietSanPham = (ChiTietSanPham) session.createQuery(query).getSingleResult();
		return chiTietSanPham;
	}

	

}
