package com.phihung.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import com.phihung.dao.IDanhMucDao;
import com.phihung.entity.DanhMucSanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucDaoImpl implements IDanhMucDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<DanhMucSanPham> layDanhSachDanhMuc() {
		List<DanhMucSanPham> danhMucSanPhams = new ArrayList<DanhMucSanPham>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(" select dm from danhmucsanpham dm ");

			danhMucSanPhams = (List<DanhMucSanPham>) query.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return danhMucSanPhams;
	}

}
