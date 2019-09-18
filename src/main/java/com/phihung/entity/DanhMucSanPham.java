package com.phihung.entity;


import javax.persistence.*;
import java.util.Set;

@Entity(name="danhmucsanpham")
public class DanhMucSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int madanhmuc;
    private String tendanhmuc;
    

    @OneToMany
    @JoinColumn(name="madanhmuc")
    Set<SanPham> danhsachsanpham;

    public Set<SanPham> getDanhsachsanpham() {
        return danhsachsanpham;
    }

    public void setDanhsachsanpham(Set<SanPham> danhsachsanpham) {
        this.danhsachsanpham = danhsachsanpham;
    }

    public int getMadanhmuc() {
        return madanhmuc;
    }

    public void setMadanhmuc(int madanhmuc) {
        this.madanhmuc = madanhmuc;
    }

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }

   
}
