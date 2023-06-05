/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author nosc
 */
public class BaoCaoTonModel {
    private int MaBaoCaoTon, Thang, Nam, MaSach, TonDau, PhatSinh, TonCuoi;
    private String TenSach;
    private String TenTheLoai;
    
    public BaoCaoTonModel() {
    }
    
    public BaoCaoTonModel(int MaBaoCaoTon, int Thang, int Nam, int MaSach, String TenSach, String TenTheLoai , int TonDau, int PhatSinh, int TonCuoi) {
        this.MaBaoCaoTon = MaBaoCaoTon;
        this.Thang = Thang;
        this.Nam = Nam;
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TenTheLoai = TenTheLoai;
        this.TonDau = TonDau;
        this.PhatSinh = PhatSinh;
        this.TonCuoi = TonCuoi;
    }

    public int getMaBaoCaoTon() {
        return MaBaoCaoTon;
    }

    public void setMaBaoCaoTon(int MaBaoCaoTon) {
        this.MaBaoCaoTon = MaBaoCaoTon;
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

    public int getTonDau() {
        return TonDau;
    }

    public void setTonDau(int TonDau) {
        this.TonDau = TonDau;
    }

    public int getPhatSinh() {
        return PhatSinh;
    }

    public void setPhatSinh(int PhatSinh) {
        this.PhatSinh = PhatSinh;
    }

    public int getTonCuoi() {
        return TonCuoi;
    }

    public void setTonCuoi(int TonCuoi) {
        this.TonCuoi = TonCuoi;
    }
}
