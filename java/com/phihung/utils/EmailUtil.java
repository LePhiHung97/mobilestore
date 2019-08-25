package com.phihung.utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.MultiPartEmail;

public class EmailUtil {
	public static final String MAIL_FROM = "hunglp52@wru.vn";
	public static final String PASSWORD = "hung9397";

	public static void sendMail(String mailTo, String message) {

		try {

			// Create mail object 
			MultiPartEmail email = new MultiPartEmail();

			// Config email.setHostName("smtp.googlemail.com"); email.setSmtpPort(587);
			email.setSSLOnConnect(true);
			email.setAuthenticator(new DefaultAuthenticator(MAIL_FROM, PASSWORD));

			email.setFrom(MAIL_FROM, "YG-SHOP.Bot");

			email.setSubject("Xin chào, Để xác thực tài khoản YG-SHOP mời bạn truy cập vào đường link sau để xác thực");
			email.setMsg(message);

			// Send mail email.send();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
