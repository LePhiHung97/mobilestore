package com.phihung.entity;

import javax.persistence.*;

@Entity(name="chitietsanpham")
public class ChiTietSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int machitietsanpham;

    @OneToOne
    @JoinColumn(name="masanpham")
    SanPham sanpham;

    @OneToOne
    @JoinColumn(name="masize")
    Size size;

    @OneToOne
    @JoinColumn(name="mamau")
    MauSanPham mau;

    private int soluong;
    private String ngaynhap;

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public MauSanPham getMau() {
        return mau;
    }

    public void setMau(MauSanPham mau) {
        this.mau = mau;
    }

    public int getMachitietsanpham() {
        return machitietsanpham;
    }

    public void setMachitietsanpham(int machitietsanpham) {
        this.machitietsanpham = machitietsanpham;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }

}
