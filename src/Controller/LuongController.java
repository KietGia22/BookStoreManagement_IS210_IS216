/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Connection.ConnectDB;
import Model.KhachHangModel;
import Model.LuongModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author GIA KIET
 */
public class LuongController {
    public int BatDauChamCong(int MaTK){
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        int check = 0;
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LuongController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            sql = "{call ThemCCONG(?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, MaTK);
            check = callsql.executeUpdate();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public int KetThucChamCong(int MaTK){
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        int check = 0;
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LuongController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            sql = "{call  SUAKETTHUCCCong(?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, MaTK);
            check = callsql.executeUpdate();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public ArrayList<LuongModel> getDSChamCong(){
        ArrayList<LuongModel> luongModel = new ArrayList<LuongModel>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        try {
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call GETCHAMCONG(?)}";
            callsql = conn.prepareCall(sql);
            callsql.registerOutParameter(1, OracleTypes.CURSOR);
            callsql.execute();
            rs =  (ResultSet) callsql.getObject(1);
            while(rs.next()){
                LuongModel lmodel = new LuongModel (rs.getInt("MATK"),
                                                    rs.getDouble("SOGIOLAM"),
                                                     rs.getString("HOTEN"));
                luongModel.add(lmodel);
            }
            rs.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return luongModel;
    }
    
    public ArrayList<LuongModel> getDSLuong(){
        ArrayList<LuongModel> luongModel = new ArrayList<LuongModel>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        try {
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call GETTCLUONG(?)}";
            callsql = conn.prepareCall(sql);
            callsql.registerOutParameter(1, OracleTypes.CURSOR);
            callsql.execute();
            rs =  (ResultSet) callsql.getObject(1);
            while(rs.next()){
                LuongModel lmodel = new LuongModel (rs.getInt("THANG"),
                                                    rs.getInt("NAM"),
                                                     rs.getInt("MATK"),
                                                     rs.getLong("LUONG"),
                                                      rs.getDouble("SOGIOLAM"),
                                                      rs.getString("HOTEN"));
                luongModel.add(lmodel);
            }
            rs.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return luongModel;
    }
}
