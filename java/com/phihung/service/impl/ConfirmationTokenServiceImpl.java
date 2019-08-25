package com.phihung.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phihung.dao.IConfirmationTokenDao;
import com.phihung.entity.ConfirmationToken;
import com.phihung.service.IConfirmationTokenService;


@Service
public class ConfirmationTokenServiceImpl implements IConfirmationTokenService {

	@Autowired
	IConfirmationTokenDao confirmationTokenDao;
	
	public void add(ConfirmationToken token) {
		confirmationTokenDao.add(token);
		
	}

	
	public ConfirmationToken findByConfirmationToken(String token) {
		return confirmationTokenDao.findByConfirmationToken(token);
	}

}
