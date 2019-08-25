package com.phihung.service;

import com.phihung.entity.ConfirmationToken;

public interface IConfirmationTokenService {
	public void add(ConfirmationToken token);
	public ConfirmationToken findByConfirmationToken(String token);
}
