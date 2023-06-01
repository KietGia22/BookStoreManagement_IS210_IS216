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
    protected int MaSach, SlHienCo, MaTL;
    protected String TenSach, TenTG, NXB, AnhSach, TenTheLoai;
    protected long GiaTien;

    public SachModel() {
    }

    public SachModel(int MaSach, int SlHienCo, int MaTL, String TenSach, String TenTG, String NXB, String AnhSach, long GiaTien, String TenTheLoai) {
        this.MaSach = MaSach;
        this.SlHienCo = SlHienCo;
        this.MaTL = MaTL;
        this.TenSach = TenSach;
        this.TenTG = TenTG;
        this.NXB = NXB;
        this.AnhSach = AnhSach;
        this.GiaTien = GiaTien;
        this.TenTheLoai = TenTheLoai;
    }
    
    public SachModel(int SlHienCo, int MaTL, String TenSach, String TenTG, String NXB, String AnhSach, String TenTheLoai, long GiaTien) {
        this.SlHienCo = SlHienCo;
        this.MaTL = MaTL;
        this.TenSach = TenSach;
        this.TenTG = TenTG;
        this.NXB = NXB;
        this.AnhSach = AnhSach;
        this.TenTheLoai = TenTheLoai;
        this.GiaTien = GiaTien;
    }

    
    
    public int getMaSach() {
        return MaSach;
    }

    public void setMaSach(int MaSach) {
        this.MaSach = MaSach;
    }

    public int getSlHienCo() {
        return SlHienCo;
    }

    public void setSlHienCo(int SlHienCo) {
        this.SlHienCo = SlHienCo;
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

    public long getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(long GiaTien) {
        this.GiaTien = GiaTien;
    }

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String TenTheLoai) {
        this.TenTheLoai = TenTheLoai;
    }
}
