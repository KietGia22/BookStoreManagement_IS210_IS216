/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.ConnectDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
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
}