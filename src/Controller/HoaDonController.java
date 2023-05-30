/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.ConnectDB;
import Model.HoaDonModel;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author GIA KIET
 */
public class HoaDonController {
    public ArrayList<HoaDonModel> getTCHoaDon(){
        ArrayList<HoaDonModel> hdModel = new ArrayList<HoaDonModel>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call GETTCHD(?)}";
            callsql = conn.prepareCall(sql);
            callsql.registerOutParameter(1, OracleTypes.CURSOR);
            callsql.execute();
            rs = (ResultSet) callsql.getObject(1);
            while(rs.next()){
                HoaDonModel hd = new
                    HoaDonModel(rs.getInt("MAHD"), 
                            rs.getInt("MAKH"), 
                            rs.getInt("MATK"), 
                            rs.getLong("TONGTIEN"), 
                            rs.getDate("NGAYTAOHD").toLocalDate());
                hdModel.add(hd);
            }
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return hdModel;
    }
    
    public String GetTenKH(int MaKH){
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        String TenKH = "";
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call  GETKHTHEOMA(?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, MaKH);
            callsql.registerOutParameter(2, OracleTypes.CURSOR);
            callsql.execute();
            rs = (ResultSet) callsql.getObject(2);
            if(rs.next()){
                TenKH = rs.getString("HOTEN");
            }
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return TenKH;
    }
    
    public String GetTenNV(int MaNV){
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        String TenNV = "";
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call  GETTKTHEOMA(?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, MaNV);
            callsql.registerOutParameter(2, OracleTypes.CURSOR);
            callsql.execute();
            rs = (ResultSet) callsql.getObject(2);
            if(rs.next()){
                TenNV = rs.getString("HOTEN");
            }
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return TenNV;
    }
    
    public ArrayList<HoaDonModel> TimKiemHD(String choice, String search){
        ArrayList<HoaDonModel> hdModel = new ArrayList<HoaDonModel>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(choice.equals("Mã hoá đơn"))
                sql = "{call GETHDTHEOMA(?, ?)}";
                
            callsql = conn.prepareCall(sql);
            callsql.setString(1, search);
            callsql.registerOutParameter(2, OracleTypes.CURSOR);
            callsql.execute();
            rs = (ResultSet) callsql.getObject(2);
            while(rs.next()){
                HoaDonModel hd = new
                    HoaDonModel(rs.getInt("MAHD"), 
                            rs.getInt("MAKH"), 
                            rs.getInt("MATK"), 
                            rs.getLong("TONGTIEN"), 
                            rs.getDate("NGAYTAOHD").toLocalDate());
                hdModel.add(hd);
            }
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return hdModel;
    }
}
