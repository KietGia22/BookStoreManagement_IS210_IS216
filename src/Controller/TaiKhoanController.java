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
import oracle.jdbc.OracleTypes;

/**
 *
 * @author GIA KIET
 */
public class TaiKhoanController {
    public static int DangNhap(String TenDN, String MatKhau) {
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        try {
            try{
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
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
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
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
            try{
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            String sql = "{call GETTCTK(?)}";
            callsql = conn.prepareCall(sql);
            callsql.registerOutParameter(1, OracleTypes.CURSOR);
            callsql.execute();
            rs =  (ResultSet) callsql.getObject(1);
            while(rs.next()){
                TaiKhoanModel nv = new TaiKhoanModel(rs.getInt("MATK"), rs.getLong("LUONG"), rs.getString("TENDN"), rs.getString("MATKHAU"), rs.getString("HOTEN"), rs.getString("DIACHI"), rs.getString("SDT"), rs.getString("GMAIL"), rs.getString("CHUCVU"), rs.getDate("NGAYSINH").toLocalDate(), rs.getDate("NGAYTAOTAIKHOAN").toLocalDate());
                tkModel.add(nv);
            }
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
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
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
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tkModel;
    }
    
    
    public int XoaTK(String ID_S) {
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        int check = 0;
        try {
            try{
                conn = ConnectDB.getJDBCConnection();
                conn.setAutoCommit(false);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            sql = "{call XoaTK(?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, ID_S);
            check = callsql.executeUpdate();
            conn.commit();
            conn.close();
            return check;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}