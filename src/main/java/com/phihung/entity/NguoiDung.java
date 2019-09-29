package com.phihung.entity;

import javax.persistence.*;
import java.io.Serializable;
import com.phihung.entity.ChucVu;

@Entity(name = "nguoidung")
public class NguoiDung implements Serializable {

	public NguoiDung() {
	}

	public NguoiDung(String hoten, String diachi) {
		this.hoten = hoten;
		this.diachi = diachi;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "manguoidung")
	private int manguoidung;
	private String hoten;
	private String diachi;
	private String sodienthoai;

	private String email;
	private String tendangnhap;
	private String matkhau;

	@OneToOne
	@JoinColumn(name = "machucvu")
	private ChucVu chucvu;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTendangnhap() {
		return tendangnhap;
	}

	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public ChucVu getChucvu() {
		return chucvu;
	}

	public void setChucvu(ChucVu chucvu) {
		this.chucvu = chucvu;
	}

	public int getManguoidung() {
		return manguoidung;
	}

	public void setManguoidung(int manguoidung) {
		this.manguoidung = manguoidung;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

}
