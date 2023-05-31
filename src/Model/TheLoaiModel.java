/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author GIA KIET
 */
public class TheLoaiModel {
    protected int MaTL;
    protected String TenTL;

    public TheLoaiModel() {
    }

    public TheLoaiModel(int MaTL, String TenTL) {
        this.MaTL = MaTL;
        this.TenTL = TenTL;
    }
    
    public TheLoaiModel(String TenTL){
        this.TenTL = TenTL;
    }

    public int getMaTL() {
        return MaTL;
    }

    public void setMaTL(int MaTL) {
        this.MaTL = MaTL;
    }

    public String getTenTL() {
        return TenTL;
    }

    public void setTenTL(String TenTL) {
        this.TenTL = TenTL;
    }
}
