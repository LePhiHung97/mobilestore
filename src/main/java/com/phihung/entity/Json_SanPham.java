package com.phihung.entity;
import java.util.Set;

public class Json_SanPham {
    int masanpham;
    DanhMucSanPham danhMucSanPham;
    String tensanpham;
    String giatien;
    String mota;
    String hinhsanpham;
    Set<ChiTietSanPham>chiTietSanPhamSet;

    public Json_SanPham(){}

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public DanhMucSanPham getDanhMucSanPham() {
        return danhMucSanPham;
    }

    public void setDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
        this.danhMucSanPham = danhMucSanPham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHinhsanpham() {
        return hinhsanpham;
    }

    public void setHinhsanpham(String hinhsanpham) {
        this.hinhsanpham = hinhsanpham;
    }

    public Set<ChiTietSanPham> getChiTietSanPhamSet() {
        return chiTietSanPhamSet;
    }

    public void setChiTietSanPhamSet(Set<ChiTietSanPham> chiTietSanPhamSet) {
        this.chiTietSanPhamSet = chiTietSanPhamSet;
    }
}
