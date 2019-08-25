package com.phihung.event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.phihung.entity.NguoiDung;

public class OnRegistrationCompleteEvent extends ApplicationEvent {

	private String appUrl;
	private Locale locale;
	private NguoiDung nguoiDung;

	public OnRegistrationCompleteEvent(NguoiDung nguoiDung, Locale locale, String appUrl) {
		super(nguoiDung);

		this.nguoiDung = nguoiDung;
		this.locale = locale;
		this.appUrl = appUrl;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public NguoiDung getNguoidung() {
		return nguoiDung;
	}

	public void setNguoidung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

}
