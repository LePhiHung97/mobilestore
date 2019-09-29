package com.phihung.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "donhang")
public class DonHang {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "madonhang")
	private int madonhang;

	@OneToOne
	@JoinColumn(name = "manguoidung")
	private NguoiDung nguoidung;

	private String tennguoinhan;
	private String sodienthoai;
	private String diachigiaohang;
	private String ngaytao;

	public String getTennguoinhan() {
		return tennguoinhan;
	}

	public void setTennguoinhan(String tennguoinhan) {
		this.tennguoinhan = tennguoinhan;
	}

	public int getMadonhang() {
		return madonhang;
	}

	public void setMadonhang(int madonhang) {
		this.madonhang = madonhang;
	}

	public NguoiDung getNguoidung() {
		return nguoidung;
	}

	public void setNguoidung(NguoiDung nguoidung) {
		this.nguoidung = nguoidung;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public String getDiachigiaohang() {
		return diachigiaohang;
	}

	public void setDiachigiaohang(String diachigiaohang) {
		this.diachigiaohang = diachigiaohang;
	}

	public String getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(String ngaytao) {
		this.ngaytao = ngaytao;
	}

}
