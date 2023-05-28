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
public class KhachHangModel {
    protected int MaKH;
    protected String HoTen, SDT, DiaChi, GioiTinh, GhiChu, CCCD;
    protected LocalDate NgSinh, NgTao;
    DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public KhachHangModel() {
    }

    public KhachHangModel(int MaKH, String HoTen, String SDT, String DiaChi, String GioiTinh, String GhiChu, LocalDate NgSinh, LocalDate NgTao, String CCCD) {
        this.MaKH = MaKH;
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.GhiChu = GhiChu;
        this.NgSinh = NgSinh;
        this.NgTao = NgTao;
        this.CCCD = CCCD;
    }

    public KhachHangModel(String HoTen, String SDT, String DiaChi, String GioiTinh, String GhiChu, String CCCD, LocalDate NgSinh, LocalDate NgTao) {
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.GhiChu = GhiChu;
        this.CCCD = CCCD;
        this.NgSinh = NgSinh;
        this.NgTao = NgTao;
    }
    
    

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public LocalDate getNgSinh() {
        return NgSinh;
    }

    public void setNgSinh(LocalDate NgSinh) {
        this.NgSinh = NgSinh;
    }

    public LocalDate getNgTao() {
        return NgTao;
    }

    public void setNgTao(LocalDate NgTao) {
        this.NgTao = NgTao;
    }
    
    public String toString(LocalDate dateformat) {
        return dtformat.format(dateformat);
    }
}
