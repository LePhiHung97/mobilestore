package com.phihung.service;

import com.phihung.entity.NguoiDung;

public interface NguoiDungService {
    void themNguoiDung(NguoiDung nguoiDung);
    boolean kiemTraNguoiDung(NguoiDung nguoiDung);
}
