/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author GIA KIET
 */
public class PhieuNhapSachModel {
    protected int MaPNS, MaTK, MaSach, MaNPP, SoLuong;
    protected long TongTien, GiaNhap;
    protected LocalDate NgNhap;
    DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    protected String TenNPP, TenNV;

    public PhieuNhapSachModel() {
    }

    public PhieuNhapSachModel(int MaPNS, int MaTK, int MaSach, int MaNPP, int SoLuong, long TongTien, long GiaNhap, LocalDate NgNhap) {
        this.MaPNS = MaPNS;
        this.MaTK = MaTK;
        this.MaSach = MaSach;
        this.MaNPP = MaNPP;
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
        this.GiaNhap = GiaNhap;
        this.NgNhap = NgNhap;
    }

    public PhieuNhapSachModel(int MaPNS, long TongTien, LocalDate NgNhap, String TenNPP, String TenNV) {
        this.MaPNS = MaPNS;
        this.TongTien = TongTien;
        this.NgNhap = NgNhap;
        this.TenNPP = TenNPP;
        this.TenNV = TenNV;
    }

    public PhieuNhapSachModel(int MaTK, int MaNPP, long TongTien, LocalDate NgNhap) {
        this.MaTK = MaTK;
        this.MaNPP = MaNPP;
        this.TongTien = TongTien;
        this.NgNhap = NgNhap;
    }

    public PhieuNhapSachModel(int MaPNS, int MaSach, int SoLuong, long TongTien) {
        this.MaPNS = MaPNS;
        this.MaSach = MaSach;
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
    }
  
    public int getMaPNS() {
        return MaPNS;
    }

    public void setMaPNS(int MaPNSS) {
        this.MaPNS = MaPNS;
    }

    public int getMaTK() {
        return MaTK;
    }

    public void setMaTK(int MaTK) {
        this.MaTK = MaTK;
    }

    public int getMaSach() {
        return MaSach;
    }

    public void setMaSach(int MaSach) {
        this.MaSach = MaSach;
    }

    public int getMaNPP() {
        return MaNPP;
    }

    public void setMaNPP(int MaNPP) {
        this.MaNPP = MaNPP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public long getTongTien() {
        return TongTien;
    }

    public void setTongTien(long TongTien) {
        this.TongTien = TongTien;
    }

    public long getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(long GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public LocalDate getNgNhap() {
        return NgNhap;
    }

    public void setNgNhap(LocalDate NgNhap) {
        this.NgNhap = NgNhap;
    }

    public String toString(LocalDate dateformat) {
        return dtformat.format(dateformat);
    }

    public String getTenNPP() {
        return TenNPP;
    }

    public void setTenNPP(String TenNPP) {
        this.TenNPP = TenNPP;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }
}
