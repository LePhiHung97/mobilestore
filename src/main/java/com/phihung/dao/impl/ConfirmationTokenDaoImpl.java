package com.phihung.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.phihung.dao.IConfirmationTokenDao;
import com.phihung.entity.ConfirmationToken;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ConfirmationTokenDaoImpl implements IConfirmationTokenDao{

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public ConfirmationToken findByConfirmationToken(String token) {
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from confirmationtoken ct where ct.token=:token");
		query.setParameter("token", token);
		ConfirmationToken confirmToken = (ConfirmationToken)query.uniqueResult();
		return confirmToken;
	}

	@Transactional
	public void add(ConfirmationToken confirmationToken){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(confirmationToken);
			
		
	}
	
	
}
