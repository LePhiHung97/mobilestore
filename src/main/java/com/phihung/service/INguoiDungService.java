package com.phihung.service;

import com.phihung.entity.NguoiDung;


public interface INguoiDungService {
    void themNguoiDung(NguoiDung nguoiDung);
    boolean dangKiTaiKhoan(NguoiDung nguoiDung);
    boolean kiemTraNguoiDung(NguoiDung nguoiDung);
    NguoiDung timTheoEmail(String email);
    NguoiDung timTheoTenDangNhap(String tenDangNhap);
}
