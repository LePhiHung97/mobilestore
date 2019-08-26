package com.phihung.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "confirmationtoken")
public class ConfirmationToken implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "token_id")
	private int tokenId;

	@Column(name = "token")
	private String token;

	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@OneToOne(targetEntity = NguoiDung.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "manguoidung")
	private NguoiDung nguoiDung;
	public ConfirmationToken() {
		
	}

	public ConfirmationToken(int token_id,String token,Date createdDate,NguoiDung nguoiDung){
		this.tokenId = token_id;
		this.token = token;
		this.createdDate = createdDate;
		this.nguoiDung= nguoiDung;
	}
	public ConfirmationToken(NguoiDung nguoiDung) {
		this.token = UUID.randomUUID().toString();
		this.createdDate = new Date();
		this.nguoiDung = nguoiDung;
	}

	public long getTokenId() {
		return tokenId;
	}

	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

}
