/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author GIA KIET
 */
public class LuongModel {
    protected int Thang, Nam, MaTK;
    protected long Luong;
    protected double SoGioLamViec;

    public LuongModel() {
    }

    public LuongModel(int Thang, int Nam, int MaTK, long Luong, double SoGioLamViec) {
        this.Thang = Thang;
        this.Nam = Nam;
        this.MaTK = MaTK;
        this.Luong = Luong;
        this.SoGioLamViec = SoGioLamViec;
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

    public double getSoGioLamViec() {
        return SoGioLamViec;
    }

    public void setSoGioLamViec(double SoGioLamViec) {
        this.SoGioLamViec = SoGioLamViec;
    }
    
    
}
