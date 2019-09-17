package com.phihung.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.phihung.dao.ISanPhamDao;
import com.phihung.entity.ChiTietSanPham;
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

	@Transactional
	public void xoaSanPham(int masanpham) {
		Session session = sessionFactory.getCurrentSession();
		SanPham sanPham = session.get(SanPham.class, masanpham);
		/*
		 * Set<ChiTietSanPham> chiTietSanPhamSet = sanPham.getChitietsanpham(); int
		 * deletedRows = 0; for (ChiTietSanPham ctsp : chiTietSanPhamSet) { String hql =
		 * "delete chitietsanpham ct where  ct.sanpham.masanpham = :masanpham"; Query
		 * query = session.createQuery(hql); query.setParameter("masanpham", masanpham);
		 * deletedRows = query.executeUpdate(); System.out.println(deletedRows); }
		 */
		session.createQuery("delete chitietsanpham where masanpham = "+masanpham).executeUpdate();
		session.createQuery("delete sanpham  where masanpham = " + masanpham).executeUpdate();
	}

}
