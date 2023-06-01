/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author GIA KIET
 */
public class NhaPhanPhoiModel {
    protected int MaNPP;
    protected String TenNPP, DiaChi, SDT;

    public NhaPhanPhoiModel() {
    }

    public NhaPhanPhoiModel(int MaNPP, String TenNPP, String DiaChi, String SDT) {
        this.MaNPP = MaNPP;
        this.TenNPP = TenNPP;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
    }

    public NhaPhanPhoiModel(String TenNPP, String DiaChi, String SDT) {
        this.TenNPP = TenNPP;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
    }
    
    

    public int getMaNPP() {
        return MaNPP;
    }

    public void setMaNPP(int MaNPP) {
        this.MaNPP = MaNPP;
    }

    public String getTenNPP() {
        return TenNPP;
    }

    public void setTenNPP(String TenNPP) {
        this.TenNPP = TenNPP;
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

}
