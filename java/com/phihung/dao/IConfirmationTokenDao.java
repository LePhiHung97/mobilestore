package com.phihung.dao;

import com.phihung.entity.ConfirmationToken;

public interface IConfirmationTokenDao {
	ConfirmationToken findByConfirmationToken(String confirmationToken);
	void add(ConfirmationToken confirmationToken);
}
