package com.phihung.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import java.io.Serializable;

@Embeddable
public class ChiTietHoaDonID implements Serializable {

    int mahoadon;
    int machitietsanpham;

    public int getMahoadon(){
        return this.mahoadon;
    }

    public void setMahoadon(int mahoadon)
    {
        this.mahoadon = mahoadon;
    }

    public int getMachitietsanpham() {
        return machitietsanpham;
    }

    public void setMachitietsanpham(int machitietsanpham) {
        this.machitietsanpham = machitietsanpham;
    }
}
