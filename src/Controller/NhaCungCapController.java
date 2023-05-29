/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.ConnectDB;
import Model.NhaCungCapModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author GIA KIET
 */
public class NhaCungCapController {
    public ArrayList<NhaCungCapModel> getTCNCC(){
        ArrayList<NhaCungCapModel> nccModel = new ArrayList<NhaCungCapModel>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call GETTCNCC(?)}";
            callsql = conn.prepareCall(sql);
            callsql.registerOutParameter(1, OracleTypes.CURSOR);
            callsql.execute();
            rs =  (ResultSet) callsql.getObject(1);
            while(rs.next()){
                NhaCungCapModel ncc = new 
                             NhaCungCapModel(rs.getInt("MANCC"), rs.getString("TENNCC"), rs.getString("DiaChi"), rs.getString("SDT"));
                nccModel.add(ncc);
            }
            rs.close();
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return nccModel;
    }
    
    public ArrayList<NhaCungCapModel> TimKiemNCC(String choice, String search){
        ArrayList<NhaCungCapModel> nccModel = new ArrayList<NhaCungCapModel>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(choice.equals("Mã nhà cung cấp"))
                sql = "{call GETNCCTHEOMA(?, ?)}";
            else 
                sql = "{call GETNCCTHEOTEN(?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, search);
            callsql.registerOutParameter(2, OracleTypes.CURSOR);
            callsql.execute();
            rs =  (ResultSet) callsql.getObject(2);
            while(rs.next()){
                NhaCungCapModel ncc = new 
                             NhaCungCapModel(rs.getInt("MANCC"), rs.getString("TENNCC"), rs.getString("DiaChi"), rs.getString("SDT"));
                nccModel.add(ncc);
            }
            rs.close();
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return nccModel;
    }
    
    public int ThemNCC(NhaCungCapModel ncc){
        Connection conn = null;
        CallableStatement callsql = null;
        String sql;
        int check;
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call ThemNCC(?, ?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, ncc.getTenNCC());
            callsql.setString(2, ncc.getDiaChi());
            callsql.setString(3, ncc.getSDT());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public int SuaNCC(NhaCungCapModel ncc){
        Connection conn = null;
        CallableStatement callsql = null;
        String sql;
        int check;
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call SuaNCC(?, ?, ?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, ncc.getMaNCC());
            callsql.setString(2, ncc.getTenNCC());
            callsql.setString(3, ncc.getDiaChi());
            callsql.setString(4, ncc.getSDT());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public int XoaNCC(NhaCungCapModel ncc){
        Connection conn = null;
        CallableStatement callsql = null;
        String sql;
        int check;
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NhaCungCapController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call XoaNCC(?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, ncc.getMaNCC());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
