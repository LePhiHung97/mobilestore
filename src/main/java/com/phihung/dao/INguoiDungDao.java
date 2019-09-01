package com.phihung.dao;

import com.phihung.entity.NguoiDung;

public interface INguoiDungDao {
	boolean dangKiTaiKhoan(NguoiDung nguoiDung);
    void themNguoiDung(NguoiDung nguoiDung);
    NguoiDung kiemTraNguoiDung(NguoiDung nguoiDung);
    int layMaNguoiDungMoiNhat();
    NguoiDung timTheoTenDangNhap(String tenDangNhap);
    NguoiDung timTheoEmail(String email);
}
