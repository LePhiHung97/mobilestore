package com.phihung.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.phihung.dao.INguoiDungDao;
import com.phihung.entity.ConfirmationToken;
import com.phihung.entity.NguoiDung;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NguoiDungDaoImpl implements INguoiDungDao {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void themNguoiDung(NguoiDung nguoiDung) {
		Session session = sessionFactory.getCurrentSession();
		session.save(nguoiDung);
	}

	@Transactional
	public NguoiDung kiemTraNguoiDung(NguoiDung nguoiDung) {
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from nguoidung nd where nd.tendangnhap=:tendangnhap and nd.matkhau=:matkhau");
		query.setParameter("tendangnhap", nguoiDung.getTendangnhap());
		query.setParameter("matkhau", nguoiDung.getMatkhau());
		NguoiDung existNguoiDung  = (NguoiDung)query.uniqueResult();
		return existNguoiDung;
		
	}

	@Transactional
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

	@Transactional
	public NguoiDung timTheoTenDangNhap(String tenDangNhap) {
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from nguoidung nd where nd.tendangnhap=:tendangnhap");
		query.setParameter("tendangnhap", tenDangNhap);
		NguoiDung nguoiDung  = (NguoiDung)query.uniqueResult();
		return nguoiDung;
	}

	@Transactional
	public NguoiDung timTheoEmail(String email) {
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from nguoidung nd where nd.email=:email");
		query.setParameter("email", email);
		NguoiDung nguoiDung  = (NguoiDung)query.uniqueResult();
		return nguoiDung;
	}

	@Transactional
	public boolean dangKiTaiKhoan(NguoiDung nguoiDung) {
		Session session = sessionFactory.getCurrentSession();
		Integer maNguoiDung = (Integer) session.save(nguoiDung);
		if(maNguoiDung >0)
			return true;
		return false;
	}

	

}
