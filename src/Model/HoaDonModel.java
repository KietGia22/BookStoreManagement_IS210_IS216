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
public class HoaDonModel {
    protected int MaHD, MaKH, MaTK, MaSach, Soluong;
    protected long TongTien;
    protected String GhiChu;
    protected LocalDate NgTaoHD;
    DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public HoaDonModel() {
    }

    public HoaDonModel(int MaHD, int MaKH, int MaTK, int MaSach, int Soluong, long TongTien, String GhiChu, LocalDate NgTaoHD) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.MaTK = MaTK;
        this.MaSach = MaSach;
        this.Soluong = Soluong;
        this.TongTien = TongTien;
        this.GhiChu = GhiChu;
        this.NgTaoHD = NgTaoHD;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
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

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public long getTongTien() {
        return TongTien;
    }

    public void setTongTien(long TongTien) {
        this.TongTien = TongTien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public LocalDate getNgTaoHD() {
        return NgTaoHD;
    }

    public void setNgTaoHD(LocalDate NgTaoHD) {
        this.NgTaoHD = NgTaoHD;
    }
    
    public String toString(LocalDate dateformat) {
        return dtformat.format(dateformat);
    }
}
