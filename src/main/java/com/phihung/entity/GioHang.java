package com.phihung.entity;

public class GioHang {

    int machitietsanpham;
    int masp;
    int masize;
    int mamau;
    String tensp;
    String giatien;
    String tenmau;
    String tensize;
    int soluong;
    String hinhsanpham;

    public GioHang(){}

    public GioHang(int masp, int masize, int mamau, String tensp, String giatien, String tenmau, String tensize, int soluong,int machitietsanpham,String hinhsanpham) {
        this.masp = masp;
        this.masize = masize;
        this.mamau = mamau;
        this.tensp = tensp;
        this.giatien = giatien;
        this.tenmau = tenmau;
        this.tensize = tensize;
        this.soluong = soluong;
        this.machitietsanpham = machitietsanpham;
        this.hinhsanpham = hinhsanpham;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getMasize() {
        return masize;
    }

    public void setMasize(int masize) {
        this.masize = masize;
    }

    public int getMamau() {
        return mamau;
    }

    public void setMamau(int mamau) {
        this.mamau = mamau;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }

    public String getTenmau() {
        return tenmau;
    }

    public void setTenmau(String tenmau) {
        this.tenmau = tenmau;
    }

    public String getTensize() {
        return tensize;
    }

    public void setTensize(String tensize) {
        this.tensize = tensize;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getMachitietsanpham() {
        return machitietsanpham;
    }

    public void setMachitietsanpham(int machitietsanpham) {
        this.machitietsanpham = machitietsanpham;
    }

	public String getHinhsanpham() {
		return hinhsanpham;
	}

	public void setHinhsanpham(String hinhsanpham) {
		this.hinhsanpham = hinhsanpham;
	}
    
  


}
