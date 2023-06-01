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
    protected int MaPN, MaTK, MaSach, MaNCC, SoLuong;
    protected long TongTien, GiaNhap;
    protected LocalDate NgNhap;
    DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    protected String TenNCC, TenNV;

    public PhieuNhapSachModel() {
    }

    public PhieuNhapSachModel(int MaPN, int MaTK, int MaSach, int MaNCC, int SoLuong, long TongTien, long GiaNhap, LocalDate NgNhap) {
        this.MaPN = MaPN;
        this.MaTK = MaTK;
        this.MaSach = MaSach;
        this.MaNCC = MaNCC;
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
        this.GiaNhap = GiaNhap;
        this.NgNhap = NgNhap;
    }

    public PhieuNhapSachModel(int MaPN, long TongTien, LocalDate NgNhap, String TenNCC, String TenNV) {
        this.MaPN = MaPN;
        this.TongTien = TongTien;
        this.NgNhap = NgNhap;
        this.TenNCC = TenNCC;
        this.TenNV = TenNV;
    }
    
    
    
    public int getMaPN() {
        return MaPN;
    }

    public void setMaPN(int MaPN) {
        this.MaPN = MaPN;
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

    public int getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(int MaNCC) {
        this.MaNCC = MaNCC;
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

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }
}
