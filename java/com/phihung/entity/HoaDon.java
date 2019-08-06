package com.phihung.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="hoadon")
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mahoadon;
    private String tenkhachhang;
    private String sodienthoai;
    private String diachigiaohang;
    Boolean tinhtrang;
    String ngaylap;
    String ghichu;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="mahoadon")
    Set<ChiTietHoaDon> chiTietHoaDonSet;

    public HoaDon(){

    }

    public HoaDon(int mahoadon,String tenkhachhang,String sodienthoai,String diachigiaohang,String ghichu)
    {
        this.mahoadon = mahoadon;
        this.tenkhachhang = tenkhachhang;
        this.sodienthoai = sodienthoai;
        this.diachigiaohang = diachigiaohang;
        this.ghichu = ghichu;
    }

    public Set<ChiTietHoaDon> getChiTietHoaDonSet() {
        return chiTietHoaDonSet;
    }

    public void setChiTietHoaDonSet(Set<ChiTietHoaDon> chiTietHoaDonSet) {
        this.chiTietHoaDonSet = chiTietHoaDonSet;
    }

    public int getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(int mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
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

    public Boolean getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(Boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }


}
