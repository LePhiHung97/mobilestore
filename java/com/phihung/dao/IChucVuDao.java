package com.phihung.dao;

import com.phihung.entity.ChucVu;

public interface IChucVuDao {
	ChucVu layTheoMaChucVu(int maChucVu);

	ChucVu layTheoTenChucVu(String tenChucVu);
}
