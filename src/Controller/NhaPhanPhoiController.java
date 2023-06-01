/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.ConnectDB;
import Model.NhaPhanPhoiModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author GIA KIET
 */
public class NhaPhanPhoiController {
    public ArrayList<NhaPhanPhoiModel> getTCNCC(){
        ArrayList<NhaPhanPhoiModel> nppModel = new ArrayList<NhaPhanPhoiModel>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NhaPhanPhoiController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call GETTCNPP(?)}";
            callsql = conn.prepareCall(sql);
            callsql.registerOutParameter(1, OracleTypes.CURSOR);
            callsql.execute();
            rs =  (ResultSet) callsql.getObject(1);
            while(rs.next()){
                NhaPhanPhoiModel npp = new 
                             NhaPhanPhoiModel(rs.getInt("MANPP"), rs.getString("TENNPP"), rs.getString("DiaChi"), rs.getString("SDT"));
                nppModel.add(npp);
            }
            rs.close();
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return nppModel;
    }
    
    public ArrayList<NhaPhanPhoiModel> TimKiemNCC(String choice, String search){
        ArrayList<NhaPhanPhoiModel> nppModel = new ArrayList<NhaPhanPhoiModel>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NhaPhanPhoiController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(choice.equals("Mã nhà phân phối"))
                sql = "{call GETNPPTHEOMA(?, ?)}";
            else 
                sql = "{call GETNPPTHEOTEN(?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, search);
            callsql.registerOutParameter(2, OracleTypes.CURSOR);
            callsql.execute();
            rs =  (ResultSet) callsql.getObject(2);
            while(rs.next()){
                NhaPhanPhoiModel npp = new 
                             NhaPhanPhoiModel(rs.getInt("MANPP"), rs.getString("TENNPP"), rs.getString("DiaChi"), rs.getString("SDT"));
                nppModel.add(npp);
            }
            rs.close();
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return nppModel;
    }
    
    public int ThemNPP(NhaPhanPhoiModel npp){
        Connection conn = null;
        CallableStatement callsql = null;
        String sql;
        int check;
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NhaPhanPhoiController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call ThemNPP(?, ?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, npp.getTenNPP());
            callsql.setString(2, npp.getDiaChi());
            callsql.setString(3, npp.getSDT());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public int SuaNPP(NhaPhanPhoiModel npp){
        System.out.println(npp.getMaNPP() + " " + npp.getTenNPP() + " " + npp.getSDT() + " " + npp.getDiaChi());
        Connection conn = null;
        CallableStatement callsql = null;
        String sql;
        int check;
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NhaPhanPhoiController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call SuaNPP_FIX(?, ?, ?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, npp.getMaNPP());
            callsql.setString(2, npp.getTenNPP());
            callsql.setString(3, npp.getDiaChi());
            callsql.setString(4, npp.getSDT());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public int XoaNPP(NhaPhanPhoiModel npp){
        Connection conn = null;
        CallableStatement callsql = null;
        String sql;
        int check;
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NhaPhanPhoiController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call XoaNPP(?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, npp.getMaNPP());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
