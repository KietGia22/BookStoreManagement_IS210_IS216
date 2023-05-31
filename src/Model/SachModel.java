/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author GIA KIET
 */
public class SachModel {
    protected int MaSach, SlTon, MaTL;
    protected String TenSach, TenTG, NXB, AnhSach, TenTheLoai;
    protected long Gia;

    public SachModel() {
    }

    public SachModel(int MaSach, int SlTon, int MaTL, String TenSach, String TenTG, String NXB, String AnhSach, long Gia, String TenTheLoai) {
        this.MaSach = MaSach;
        this.SlTon = SlTon;
        this.MaTL = MaTL;
        this.TenSach = TenSach;
        this.TenTG = TenTG;
        this.NXB = NXB;
        this.AnhSach = AnhSach;
        this.Gia = Gia;
        this.TenTheLoai = TenTheLoai;
    }
    
    public SachModel(int SlTon, int MaTL, String TenSach, String TenTG, String NXB, String AnhSach, String TenTheLoai, long Gia) {
        this.SlTon = SlTon;
        this.MaTL = MaTL;
        this.TenSach = TenSach;
        this.TenTG = TenTG;
        this.NXB = NXB;
        this.AnhSach = AnhSach;
        this.TenTheLoai = TenTheLoai;
        this.Gia = Gia;
    }

    
    
    public int getMaSach() {
        return MaSach;
    }

    public void setMaSach(int MaSach) {
        this.MaSach = MaSach;
    }

    public int getSlTon() {
        return SlTon;
    }

    public void setSlTon(int SlTon) {
        this.SlTon = SlTon;
    }

    public int getMaTL() {
        return MaTL;
    }

    public void setMaTL(int MaTL) {
        this.MaTL = MaTL;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public String getTenTG() {
        return TenTG;
    }

    public void setTenTG(String TenTG) {
        this.TenTG = TenTG;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public String getAnhSach() {
        return AnhSach;
    }

    public void setAnhSach(String AnhSach) {
        this.AnhSach = AnhSach;
    }

    public long getGia() {
        return Gia;
    }

    public void setGia(long Gia) {
        this.Gia = Gia;
    }

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String TenTheLoai) {
        this.TenTheLoai = TenTheLoai;
    }
}
