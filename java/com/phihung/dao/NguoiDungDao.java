package com.phihung.dao;

import com.phihung.entity.NguoiDung;

public interface NguoiDungDao {
    void themNguoiDung(NguoiDung nguoiDung);
    boolean kiemTraNguoiDung(NguoiDung nguoiDung);
    int layMaNguoiDungMoiNhat();
}
