/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;

/**
 *
 * @author nosc
 */
public class BaoCaoDoanhThuModel {
    private int MaBaoCao, Thang, Nam, MaSach, SoLuong;
    private String TenSach, TenTheLoai;
    private BigDecimal GiaTien, TongTien;

    public BaoCaoDoanhThuModel() {
        this.MaBaoCao = 0;
        this.Thang = 0;
        this.Nam = 0;
        this.MaSach = 0;
        this.TenSach = "";
        this.TenTheLoai = "";
        this.SoLuong = 0;
        this.GiaTien = BigDecimal.ZERO;
        this.TongTien = BigDecimal.ZERO;
    }

    public BaoCaoDoanhThuModel(int MaBaoCao, int Thang, int Nam, int MaSach, String TenSach, String TenTheLoai,
            int SoLuong, BigDecimal GiaTien, BigDecimal TongTien) {
        this.MaBaoCao = MaBaoCao;
        this.Thang = Thang;
        this.Nam = Nam;
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TenTheLoai = TenTheLoai;
        this.SoLuong = SoLuong;
        this.GiaTien = GiaTien;
        this.TongTien = TongTien;
    }

    public int getMaBaoCao() {
        return MaBaoCao;
    }

    public void setMaBaoCao(int MaBaoCao) {
        this.MaBaoCao = MaBaoCao;
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

    public int getMaSach() {
        return MaSach;
    }

    public void setMaSach(int MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String TenTheLoai) {
        this.TenTheLoai = TenTheLoai;
    }

    public BigDecimal getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(BigDecimal GiaTien) {
        this.GiaTien = GiaTien;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public BigDecimal getTongTien() {
        return TongTien;
    }

    public void setTongTien(BigDecimal TongTien) {
        this.TongTien = TongTien;
    }
}
