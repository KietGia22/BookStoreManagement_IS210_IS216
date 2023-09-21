/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.ConnectDB;
import Model.HoaDonModel;
import Model.SachModel;
import java.util.ArrayList;
import java.sql.*;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author GIA KIET
 */

public class HoaDonController {
    
    public SachController s = new SachController();
    
    public void Add(ArrayList<HoaDonModel> hdModel, DefaultTableModel table){
        for(HoaDonModel i : hdModel){
            Object[] objTemp = null;
            if(i.getMaKH() == 0){
                String TenNV = GetTenNV(i.getMaTK());
                Object[] obj = {i.getMaHD(), "Khách vãng lai", TenNV, i.toString(i.getNgTaoHD()), i.getTongTien()};
                objTemp = obj;
            } else if(i.getMaKH() > 0) {
                String TenNV = GetTenNV(i.getMaTK());
                String TenKH = GetTenKH(i.getMaKH());
                Object[] obj = {i.getMaHD(), TenKH, TenNV, i.toString(i.getNgTaoHD()), i.getTongTien()};
                objTemp = obj;
            }
            table.addRow(objTemp);
        }
    }
    
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
                            rs.getLong("TONGTIENHD"), 
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
                            rs.getLong("TONGTIENHD"), 
                            rs.getDate("NGAYTAOHD").toLocalDate());
                hdModel.add(hd);
            }
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return hdModel;
    }
    
    public ArrayList<SachModel> GetSachTheoMaHD(int MaHD){
        ArrayList<SachModel> sModel = new ArrayList<SachModel>();
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
            sql = "{call GETSACHTHEOHD(?, ?)}";
                
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, MaHD);
            callsql.registerOutParameter(2, OracleTypes.CURSOR);
            callsql.execute();
            rs = (ResultSet) callsql.getObject(2);
            while(rs.next()){
                SachModel s = new
                    SachModel(rs.getInt("MASACH"), 
                            rs.getInt("SOLUONGMUATUNGCUONSACH"), 
                            rs.getInt("MATL"), 
                            rs.getString("TENSACH"),
                            rs.getString("TENTG"), 
                            rs.getString("NXB"), 
                            rs.getString("ANHSACH"), 
                            rs.getLong("GIATIEN"), 
                            rs.getString("TENTHELOAI"));
                sModel.add(s);
            }
            rs.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return sModel;
    }
    
    public int HoaDonVuaTao(){
        Connection conn = null;
        CallableStatement callsql = null;
        ResultSet rs = null;
        String sql = "";
        int HDVuaTao = 0;
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call GETMaHD(?)}";
            callsql = conn.prepareCall(sql);
            callsql.registerOutParameter(1, OracleTypes.CURSOR);
            callsql.execute();
            rs = (ResultSet) callsql.getObject(1);
            if(rs.next()){
                HDVuaTao = rs.getInt("MAX(MAHD)");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return HDVuaTao;
    }
    
    public int ThemHD(HoaDonModel hd){
        Connection conn = null;
        CallableStatement callsql = null;
        String sql = "";
        int check = 0;
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call ThemHD(?, ?)}";
            callsql = conn.prepareCall(sql);
            if(hd.getMaKH() != 0)
                callsql.setInt(1,(Integer) hd.getMaKH());
            else 
                callsql.setObject(1, null);
            callsql.setInt(2, hd.getMaTK());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public int ThemCTHD(HoaDonModel hd){
        Connection conn = null;
        CallableStatement callsql = null;
        String sql = "";
        int check = 0;
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call ThemCTHD(?, ?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, hd.getMaHD());
            callsql.setInt(2, hd.getMaSach());
            callsql.setInt(3, hd.getSoluong());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public int XoaHD(HoaDonModel hd){
        Connection conn = null;
        CallableStatement callsql = null;
        String sql = "";
        int check = 0;
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call XoaHD(?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, hd.getMaHD());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public void XuatHoaDonChoKH(int MaHD){
        try {
            Hashtable hashtable = new Hashtable();
            JasperReport hdonKH = JasperCompileManager.compileReport("src\\Report\\reportHD.jrxml");
            hashtable.put("mhd", MaHD);
            JasperPrint jsprint = JasperFillManager.fillReport(hdonKH, hashtable, ConnectDB.getJDBCConnection());
            JasperViewer.viewReport(jsprint, false);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void XuatHoaDonChoKHVL(int MaHD){
        try {
            Hashtable hashtable = new Hashtable();
            JasperReport hdonKH = JasperCompileManager.compileReport("src\\Report\\reportKHVL.jrxml");
            hashtable.put("mhd", MaHD);
            JasperPrint jsprint = JasperFillManager.fillReport(hdonKH, hashtable, ConnectDB.getJDBCConnection());
            JasperViewer.viewReport(jsprint, false);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
