/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.ConnectDB;
import Model.TaiKhoanModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author GIA KIET
 */
public class TaiKhoanController {
    
    public void Add(ArrayList<TaiKhoanModel> tkmodel, DefaultTableModel table){
        for(TaiKhoanModel i : tkmodel){
            Object[] obj = {i.getMaTK(), i.getHoTen(), i.toString(i.getNgSinh()), i.getGmail(), i.getDiaChi(), i.getSDT(), i.getLuong(), i.toString(i.getNgTaoTK()), i.getChucVu()};
            table.addRow(obj);
        }
    }
    
    public static int DangNhap(String TenDN, String MatKhau) {
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        try {
            try{
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "{call GET_DANG_NHAP(?, ?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, TenDN);
            callsql.setString(2, MatKhau);
            callsql.registerOutParameter(3, OracleTypes.CURSOR);
            callsql.execute();
            rs = (ResultSet) callsql.getObject(3);
            if(rs.next())
                return 1;
            rs.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public String getChucVu(String TenDN, String MatKhau){
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String ChucVu = "";
        try {
            try{
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "{call GET_DANG_NHAP(?, ?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, TenDN);
            callsql.setString(2, MatKhau);
            callsql.registerOutParameter(3, OracleTypes.CURSOR);
            callsql.execute();
            rs = (ResultSet) callsql.getObject(3);
            if(rs.next()){
                ChucVu = rs.getString("CHUCVU");
            }
            rs.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return ChucVu;
    }
    
    public int GetMaTK(String TenDN, String MatKhau){
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        int MaTK = 0;
        try {
            try{
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "{call GET_DANG_NHAP(?, ?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, TenDN);
            callsql.setString(2, MatKhau);
            callsql.registerOutParameter(3, OracleTypes.CURSOR);
            callsql.execute();
            rs = (ResultSet) callsql.getObject(3);
            if(rs.next()){
                MaTK = rs.getInt("MATK");
            }
            rs.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return MaTK;
    }
    
    public int TraVeChucVu(String TenDN, String MatKhau){
        String chucvu = getChucVu(TenDN, MatKhau);
        if(chucvu.equals("Quản lý"))
            return 4;
        else if(chucvu.equals("Nhân viên"))
            return 3;
        else if(chucvu.equals("Nhân viên kho"))
            return 2;
        else 
            return 1;
    }
    
    public ArrayList<TaiKhoanModel> getTCTaiKhoan(){
        ArrayList<TaiKhoanModel> tkModel = new ArrayList<TaiKhoanModel>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        try {
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "{call GETTCTK(?)}";
            callsql = conn.prepareCall(sql);
            callsql.registerOutParameter(1, OracleTypes.CURSOR);
            callsql.execute();
            rs =  (ResultSet) callsql.getObject(1);
            while(rs.next()){
                TaiKhoanModel nv = new 
                                 TaiKhoanModel(rs.getInt("MATK"), rs.getLong("LUONG"), rs.getString("TENDN"), rs.getString("MATKHAU"), rs.getString("HOTEN"), rs.getString("DIACHI"), rs.getString("SDT"), rs.getString("GMAIL"), rs.getString("CHUCVU"), rs.getDate("NGAYSINH").toLocalDate(), rs.getDate("NGAYTAOTAIKHOAN").toLocalDate());
                tkModel.add(nv);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tkModel;
    }
    
    public ArrayList<TaiKhoanModel> TimKiemTK(String choice, String search){
        ArrayList<TaiKhoanModel> tkModel = new ArrayList<TaiKhoanModel>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        try {
            try{
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
               Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(choice.equals("Mã nhân viên")){
                sql = "{call GETTKTHEOMA(?, ?)}";
            } else {
                sql = "{call GETTKTHEOTEN(?, ?)}";
            }
            callsql = conn.prepareCall(sql);
            callsql.setString(1, search);
            callsql.registerOutParameter(2, OracleTypes.CURSOR);
            callsql.execute();
            rs =  (ResultSet) callsql.getObject(2);
            while(rs.next()){
                TaiKhoanModel nv = new TaiKhoanModel(rs.getInt("MATK"), rs.getLong("LUONG"), rs.getString("TENDN"), rs.getString("MATKHAU"), rs.getString("HOTEN"), rs.getString("DIACHI"), rs.getString("SDT"), rs.getString("GMAIL"), rs.getString("CHUCVU"), rs.getDate("NGAYSINH").toLocalDate(), rs.getDate("NGAYTAOTAIKHOAN").toLocalDate());
                tkModel.add(nv);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tkModel;
    }
    
    
    public int XoaTK(TaiKhoanModel tk) {
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        int check = 0;
        try {
            try{
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call XoaTK(?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, tk.getMaTK());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int SuaTK(TaiKhoanModel tk){
        Connection conn = null;
        CallableStatement callsql = null;
        String sql = "";
        int check = 0;
        try {
            try{
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call SuaTK(?, ?, to_date(?, ('dd-mm-yyyy')), ?, ?, ?, ?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, tk.getMaTK());
            callsql.setString(2, tk.getHoTen());
            callsql.setString(3, tk.toString(tk.getNgSinh()));   
            callsql.setString(4, tk.getDiaChi());
            callsql.setString(5, tk.getSDT());
            callsql.setString(6, tk.getGmail());
            callsql.setString(7, tk.getChucVu());
            callsql.setLong(8, tk.getLuong());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int ThemTK(TaiKhoanModel tk){
        Connection conn = null;
        CallableStatement callsql = null;
        String sql;
        int check;
        try {
            try{
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call ThemTK(?, ? , ?, to_date(?, ('dd-mm-yyyy')), ?, ?, ?, ?, to_date(?, ('dd-mm-yyyy')), ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, tk.getTenDN());
            callsql.setString(2, tk.getMK());
            callsql.setString(3, tk.getHoTen());
            callsql.setString(4, tk.toString(tk.getNgSinh()));            
            callsql.setString(5, tk.getDiaChi());
            callsql.setString(6, tk.getSDT());
            callsql.setString(7, tk.getGmail());
            callsql.setString(8, tk.getChucVu());
            callsql.setString(9, tk.toString(tk.getNgTaoTK()));   
            callsql.setLong(10, tk.getLuong());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int GetMaTKTheoTen(String ten){
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        int MaTK = 0;
        try {
            try{
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = sql = "{call GETTKTHEOTEN(?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, ten);
            callsql.registerOutParameter(2, OracleTypes.CURSOR);
            callsql.execute();
            rs = (ResultSet) callsql.getObject(2);
            if(rs.next()){
                MaTK = rs.getInt("MATK");
            }
            rs.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return MaTK;
    }
}