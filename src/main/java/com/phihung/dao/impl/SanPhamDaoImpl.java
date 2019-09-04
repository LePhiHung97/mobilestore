package com.phihung.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.phihung.dao.ISanPhamDao;
import com.phihung.entity.DanhMucSanPham;
import com.phihung.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDaoImpl implements ISanPhamDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<SanPham> layDanhSachSanPham() {
		List<SanPham> sanphams = new ArrayList<SanPham>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("select sp from sanpham sp");
			sanphams = (List<SanPham>) query.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sanphams;
	}

	@Transactional
	public List<SanPham> LaySanPhamTheoMaDanhMuc(int madanhmuc) {
		Session session = sessionFactory.getCurrentSession();
		String query = "from sanpham  sp where sp.danhmucsanpham.madanhmuc =" + madanhmuc;
		List<SanPham> sanphams = (List<SanPham>) session.createQuery(query).getResultList();
		return sanphams;

	}

	@Transactional
	public SanPham LayChiTietSanPhamTheoMa(int masanpham) {
		Session session = sessionFactory.getCurrentSession();
		String query = "from sanpham sp where sp.masanpham =" + masanpham;
		SanPham sanPham = (SanPham) session.createQuery(query).getSingleResult();
		return sanPham;
	}

}
