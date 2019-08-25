package com.phihung.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		ConfirmationToken confirmationToken = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			confirmationToken = session.get(ConfirmationToken.class, token);
		} catch (Exception ex) {
			System.out.println("Can't not find token");
			return null;
		}
		return confirmationToken;
	}

	@Transactional
	public void add(ConfirmationToken confirmationToken){
		Session session = sessionFactory.getCurrentSession();
		session.save(confirmationToken);
			
		
	}
	
	
}
