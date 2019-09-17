package com.phihung.entity;
import java.util.Set;

import javax.persistence.*;

@Entity(name = "sanpham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int masanpham;
    private String tensanpham;
    private String giatien;
    private String mota;
    private String hinhsanpham;

    @OneToOne
    @JoinColumn(name="madanhmuc")
    DanhMucSanPham danhmucsanpham;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="masanpham")
    Set<ChiTietSanPham> chitietsanpham;

	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name="chitietkhuyenmai",joinColumns = {@JoinColumn(name =
	 * "masanpham",referencedColumnName = "masanpham")}, inverseJoinColumns =
	 * {@JoinColumn(name="makhuyenmai",referencedColumnName = "makhuyenmai")})
	 * Set<KhuyenMai> danhsachkhuyenmai;
	 */

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
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

    public DanhMucSanPham getDanhMucSanPham() {
        return danhmucsanpham;
    }

    public void setDanhMucSanPham(DanhMucSanPham danhmucsanpham) {
        this.danhmucsanpham = danhmucsanpham;
    }
    public Set<ChiTietSanPham> getChitietsanpham() {
        return chitietsanpham;
    }

    public void setChitietsanpham(Set<ChiTietSanPham> chitietsanpham) {
        this.chitietsanpham = chitietsanpham;
    }
}
