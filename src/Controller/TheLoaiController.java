/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.ConnectDB;
import Model.TheLoaiModel;
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
public class TheLoaiController {
    
    public void Add(ArrayList<TheLoaiModel> tlModel, DefaultTableModel table){
        for(TheLoaiModel i : tlModel){
            Object[] obj = {i.getMaTL(), i.getTenTL()};
            table.addRow(obj);
        }
    }
    
    public ArrayList<TheLoaiModel> getTCTL(){
        ArrayList<TheLoaiModel> tlModel = new ArrayList<TheLoaiModel>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TheLoaiController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call GETTCTL(?)}";
            callsql = conn.prepareCall(sql);
            callsql.registerOutParameter(1, OracleTypes.CURSOR);
            callsql.execute();
            rs = (ResultSet) callsql.getObject(1);
            while(rs.next()){
                TheLoaiModel TheLoaiM = new TheLoaiModel(rs.getInt("MATL"), rs.getString("TENTHELOAI"));
                tlModel.add(TheLoaiM);
            }
            rs.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return tlModel;
    }
    
    public ArrayList<TheLoaiModel> TimKiemTL(String choice, String search){
        ArrayList<TheLoaiModel> tlModel = new ArrayList<TheLoaiModel>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TheLoaiController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(choice.equals("Mã thể loại"))
                sql = "{call GETTLTHEOMA(?, ?)}";
            else 
                sql = "{call GETTLTHEOTEN(?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, search);
            callsql.registerOutParameter(2, OracleTypes.CURSOR);
            callsql.execute();
            rs = (ResultSet) callsql.getObject(2);
            while(rs.next()){
                TheLoaiModel TheLoaiM = new TheLoaiModel(rs.getInt("MATL"), rs.getString("TENTHELOAI"));
                tlModel.add(TheLoaiM);
            }
            rs.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return tlModel;
    }
    
    public int ThemTL(TheLoaiModel tl){
        Connection conn = null;
        CallableStatement callsql = null;
        String sql;
        int check;
        try {
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TheLoaiController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call ThemTL(?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, tl.getTenTL());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public int SuaTL(TheLoaiModel tl){
        Connection conn = null;
        CallableStatement callsql = null;
        String sql;
        int check;
        try {
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TheLoaiController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call SuaTL(?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, tl.getMaTL());
            callsql.setString(2, tl.getTenTL());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public int XoaTL(TheLoaiModel tl){
        Connection conn = null;
        CallableStatement callsql = null;
        String sql;
        int check;
        try {
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TheLoaiController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call XoaTL(?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, tl.getMaTL());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
