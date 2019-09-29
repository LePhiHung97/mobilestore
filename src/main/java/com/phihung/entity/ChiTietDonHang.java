package com.phihung.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "chitietdonhang")
public class ChiTietDonHang {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "machitietdonhang")
	private int machitietdonhang;

	@OneToOne
	@JoinColumn(name = "madonhang")
	private DonHang donhang;

	@OneToOne
	@JoinColumn(name = "machitietsanpham")
	private ChiTietSanPham chitietsanpham;

	private int soluong;

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	private String giatien;

	private String thanhtien;

	public int getMachitietdonhang() {
		return machitietdonhang;
	}

	public void setMachitietdonhang(int machitietdonhang) {
		this.machitietdonhang = machitietdonhang;
	}

	public DonHang getDonhang() {
		return donhang;
	}

	public void setDonhang(DonHang donhang) {
		this.donhang = donhang;
	}

	public ChiTietSanPham getChitietsanpham() {
		return chitietsanpham;
	}

	public void setChitietsanpham(ChiTietSanPham chitietsanpham) {
		this.chitietsanpham = chitietsanpham;
	}

	public String getGiatien() {
		return giatien;
	}

	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}

	public String getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(String thanhtien) {
		this.thanhtien = thanhtien;
	}

}
