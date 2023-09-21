/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.ConnectDB;
import Model.SachModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author GIA KIET
 */
public class SachController {
    
    public void Add(ArrayList<SachModel> SModel, DefaultTableModel table){
        for(SachModel i : SModel){
            Object[] obj = {i.getMaSach(), i.getTenSach(), i.getTenTheLoai(), i.getTenTG(), i.getNXB(), i.getGiaTien(), i.getSlHienCo()};
            table.addRow(obj);
        }
    }
    public void AddSachCTHD(ArrayList<SachModel> SModel, DefaultTableModel table) {
        for(SachModel i : SModel){
            Object[] obj = {i.getMaSach(), i.getTenSach(), i.getSlHienCo(), i.getGiaTien()};
            table.addRow(obj);
        }
    }
    
    public void AddSachCTPNS(ArrayList<SachModel> SModel, DefaultTableModel table){
        for(SachModel i : SModel){
            Object[] obj = {i.getMaSach(), i.getTenSach(), i.getTenTheLoai() ,i.getSlHienCo(), i.getGiaTien()};
            table.addRow(obj);
        }
    }
    
    public ArrayList<SachModel> getTCSach(){
        ArrayList<SachModel> sachModel = new ArrayList<SachModel>();
        Connection conn = null;
        //ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SachController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call GET_TL_CHO_SACH(?)}";
            callsql = conn.prepareCall(sql);
            callsql.registerOutParameter(1, OracleTypes.CURSOR);
            callsql.execute();
            ResultSet rs =  (ResultSet) callsql.getObject(1);
            while(rs.next()){
                SachModel SM = new 
                    SachModel(rs.getInt("MASACH"), 
                            rs.getInt("SLHIENCO"), 
                            rs.getInt("MATL"), 
                            rs.getString("TENSACH"), 
                            rs.getString("TENTG"), 
                            rs.getString("NXB"), 
                            rs.getString("ANHSACH"), 
                            rs.getLong("GIATIEN"), 
                            rs.getString("TENTHELOAI"));
                sachModel.add(SM);
            }
        } catch(Exception e){
            e.printStackTrace();
        } 
        return sachModel;
    }
    
    public ArrayList<SachModel> TimKiemSach(String choice, String search){
        ArrayList<SachModel> sachModel = new ArrayList<SachModel>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SachController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(choice.equals("Mã sách"))
                sql = "{call GETSACHTHEOMA(?, ?)}";
            else 
                sql = "{call GETSACHTHEOTEN(?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, search);
            callsql.registerOutParameter(2, OracleTypes.CURSOR);
            callsql.execute();
            rs =  (ResultSet) callsql.getObject(2);
            while(rs.next()){
                SachModel SM = new 
                    SachModel(rs.getInt("MASACH"), 
                            rs.getInt("SLHIENCO"), 
                            rs.getInt("MATL"), 
                            rs.getString("TENSACH"),
                            rs.getString("TENTG"), 
                            rs.getString("NXB"), 
                            rs.getString("ANHSACH"), 
                            rs.getLong("GIATIEN"), 
                            rs.getString("TENTHELOAI"));
                sachModel.add(SM);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return sachModel;
    }
    
    public String GETAnh(int MaSach){
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        String AnhSach = "";
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SachController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call GETSACHTHEOMA(?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, MaSach);
            callsql.registerOutParameter(2, OracleTypes.CURSOR);
            callsql.execute();
            rs =  (ResultSet) callsql.getObject(2);
            if(rs.next()){
                AnhSach = rs.getString("ANHSACH");
            }
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return AnhSach;
    }
    
    public int GetMaTL(String TenTheLoai){
        int MaTL = 0;
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SachController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call GETTLTHEOTEN(?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, TenTheLoai);
            callsql.registerOutParameter(2, OracleTypes.CURSOR);
            callsql.execute();
            rs =  (ResultSet) callsql.getObject(2);
            if(rs.next()){
                MaTL = rs.getInt("MATL");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return MaTL;
    }
    
    public int ThemSach(SachModel sm){
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
            sql = "{call ThemSACH(?, ?, ?, ?, ?, ?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, sm.getTenSach());
            callsql.setString(2, sm.getTenTG());
            callsql.setString(3, sm.getNXB());
            callsql.setInt(4, sm.getMaTL());
            callsql.setInt(5, sm.getSlHienCo());
            callsql.setString(6, sm.getAnhSach());
            callsql.setLong(7, sm.getGiaTien());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public int SuaSach(SachModel sm){
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
            sql = "{call SuaSACH(?, ?, ?, ?, ?, ?, ?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, sm.getMaSach());
            callsql.setString(2, sm.getTenSach());
            callsql.setString(3, sm.getTenTG());
            callsql.setString(4, sm.getNXB());
            callsql.setInt(5, sm.getMaTL());
            callsql.setInt(6, sm.getSlHienCo());
            callsql.setString(7, sm.getAnhSach());
            callsql.setLong(8, sm.getGiaTien());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public int XoaSach(SachModel sm){
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
            sql = "{call XoaSACH(?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, sm.getMaSach());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public String LayThongTinTacGia(String ten){
        String TG = "";
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SachController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call GETSACHTHEOTEN(?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, ten);
            callsql.registerOutParameter(2, OracleTypes.CURSOR);
            callsql.execute();
            rs =  (ResultSet) callsql.getObject(2);
            if(rs.next()){
                TG = rs.getString("TENTG");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return TG;
    }
    
    public String LayThongTinNXB(String ten){
        String NXB = "";
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SachController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call GETSACHTHEOTEN(?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, ten);
            callsql.registerOutParameter(2, OracleTypes.CURSOR);
            callsql.execute();
            rs =  (ResultSet) callsql.getObject(2);
            if(rs.next()){
                NXB = rs.getString("NXB");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return NXB;
    }
    
    public int LayMaSach(String ten){
        int MaS = 0;
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SachController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call GETSACHTHEOTEN(?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, ten);
            callsql.registerOutParameter(2, OracleTypes.CURSOR);
            callsql.execute();
            rs =  (ResultSet) callsql.getObject(2);
            if(rs.next()){
                MaS = rs.getInt("MASACH");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return MaS;
    }
}
