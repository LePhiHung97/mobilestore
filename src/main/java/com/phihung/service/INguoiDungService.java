package com.phihung.service;

import com.phihung.entity.NguoiDung;
import com.phihung.entity.VerificationToken;

public interface INguoiDungService {
    void themNguoiDung(NguoiDung nguoiDung);
    boolean dangKiTaiKhoan(NguoiDung nguoiDung);
    boolean kiemTraNguoiDung(NguoiDung nguoiDung);
    NguoiDung timTheoEmail(String email);
    NguoiDung timTheoTenDangNhap(String tenDangNhap);
    NguoiDung timTheoToken(String verificationToken);
    void createVerificationToken(NguoiDung nguoidung, String token);
    VerificationToken getVerificationToken(String token);
}
