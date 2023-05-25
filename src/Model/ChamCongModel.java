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
public class ChamCongModel {
    protected int MaTK;
    protected double SoGioLamViec;
    protected LocalDateTime BatDauLam, Ketthuc;
    DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public ChamCongModel() {
    }

    public ChamCongModel(int MaTK, double SoGioLamViec, LocalDateTime BatDauLam, LocalDateTime Ketthuc) {
        this.MaTK = MaTK;
        this.SoGioLamViec = SoGioLamViec;
        this.BatDauLam = BatDauLam;
        this.Ketthuc = Ketthuc;
    }

    public int getMaTK() {
        return MaTK;
    }

    public void setMaTK(int MaTK) {
        this.MaTK = MaTK;
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
  
     public String toString(LocalDateTime hourformat) {
        return dtformat.format(hourformat);
    }
}
