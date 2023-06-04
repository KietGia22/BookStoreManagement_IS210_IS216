/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author GIA KIET
 */
public class LuongModel {
    protected int Thang, Nam, MaTK;
    protected long Luong;
    protected double TongSoGioLamViec;
    protected double SoGioLamViec;
    protected LocalDateTime BatDauLam, Ketthuc;
    protected String TenNV;
    DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public LuongModel() {
    }

    public LuongModel(int Thang, int Nam, int MaTK, long Luong, double TongSoGioLamViec, double SoGioLamViec, LocalDateTime BatDauLam, LocalDateTime Ketthuc) {
        this.Thang = Thang;
        this.Nam = Nam;
        this.MaTK = MaTK;
        this.Luong = Luong;
        this.TongSoGioLamViec = TongSoGioLamViec;
        this.SoGioLamViec = SoGioLamViec;
        this.BatDauLam = BatDauLam;
        this.Ketthuc = Ketthuc;
    }

    public LuongModel(int MaTK, double SoGioLamViec, String TenNV) {
        this.MaTK = MaTK;
        this.SoGioLamViec = SoGioLamViec;
        this.TenNV = TenNV;
    }
    
    

    public int getThang() {
        return Thang;
    }

    public void setThang(int Thang) {
        this.Thang = Thang;
    }

    public int getNam() {
        return Nam;
    }

    public void setNam(int Nam) {
        this.Nam = Nam;
    }

    public int getMaTK() {
        return MaTK;
    }

    public void setMaTK(int MaTK) {
        this.MaTK = MaTK;
    }

    public long getLuong() {
        return Luong;
    }

    public void setLuong(long Luong) {
        this.Luong = Luong;
    }

    public double getTongSoGioLamViec() {
        return TongSoGioLamViec;
    }

    public void setTongSoGioLamViec(double TongSoGioLamViec) {
        this.TongSoGioLamViec = TongSoGioLamViec;
    }

    public double getSoGioLamViec() {
        return SoGioLamViec;
    }

    public void setSoGioLamViec(double SoGioLamViec) {
        this.SoGioLamViec = SoGioLamViec;
    }

    public LocalDateTime getBatDauLam() {
        return BatDauLam;
    }

    public void setBatDauLam(LocalDateTime BatDauLam) {
        this.BatDauLam = BatDauLam;
    }

    public LocalDateTime getKetthuc() {
        return Ketthuc;
    }

    public void setKetthuc(LocalDateTime Ketthuc) {
        this.Ketthuc = Ketthuc;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }
    
    
    
}
