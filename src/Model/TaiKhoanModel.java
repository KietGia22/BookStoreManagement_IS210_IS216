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
public class TaiKhoanModel {
    protected int MaTK; 
    protected String TenDN, MK, HoTen, DiaChi, SDT, Gmail, ChucVu;
    protected LocalDate NgSinh, NgTaoTK;
    protected long Luong;
    DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public TaiKhoanModel() {}

    public TaiKhoanModel(int MaTK, long Luong, String TenDN, String MK, String HoTen, String DiaChi, String SDT, String Gmail, String ChucVu, LocalDate NgSinh, LocalDate NgTaoTK) {
        this.MaTK = MaTK;
        this.Luong = Luong;
        this.TenDN = TenDN;
        this.MK = MK;
        this.HoTen = HoTen;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Gmail = Gmail;
        this.ChucVu = ChucVu;
        this.NgSinh = NgSinh;
        this.NgTaoTK = NgTaoTK;
    }
    
    public TaiKhoanModel(long Luong, String TenDN, String MK, String HoTen, String DiaChi, String SDT, String Gmail, String ChucVu, LocalDate NgSinh, LocalDate NgTaoTK) {
        this.Luong = Luong;
        this.TenDN = TenDN;
        this.MK = MK;
        this.HoTen = HoTen;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Gmail = Gmail;
        this.ChucVu = ChucVu;
        this.NgSinh = NgSinh;
        this.NgTaoTK = NgTaoTK;
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

    public String getTenDN() {
        return TenDN;
    }

    public void setTenDN(String TenDN) {
        this.TenDN = TenDN;
    }

    public String getMK() {
        return MK;
    }

    public void setMK(String MK) {
        this.MK = MK;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String Gmail) {
        this.Gmail = Gmail;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public LocalDate getNgSinh() {
        return NgSinh;
    }

    public void setNgSinh(LocalDate NgSinh) {
        this.NgSinh = NgSinh;
    }

    public LocalDate getNgTaoTK() {
        return NgTaoTK;
    }

    public void setNgTaoTK(LocalDate NgTaoTK) {
        this.NgTaoTK = NgTaoTK;
    }
    
    public String toString(LocalDate dateformat) {
        return dtformat.format(dateformat);
    }
}
