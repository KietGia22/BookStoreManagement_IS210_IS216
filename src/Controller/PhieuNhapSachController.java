/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.ConnectDB;
import Model.PhieuNhapSachModel;
import Model.SachModel;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;
import View.Them_PN;
import java.util.Hashtable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author GIA KIET
 */
public class PhieuNhapSachController {
    
    public TaiKhoanController tk = new TaiKhoanController();
    public NhaPhanPhoiController npp = new NhaPhanPhoiController();
    
    public void Add(ArrayList<PhieuNhapSachModel> pnModel, DefaultTableModel table){
        for(PhieuNhapSachModel i : pnModel){
            Object[] obj = {i.getMaPNS(), i.getTenNV(), i.getTenNPP(), i.toString(i.getNgNhap()), i.getTongTien()};
            table.addRow(obj);
        }
    }
    
    public ArrayList<PhieuNhapSachModel> getThongTinPhieuNhap(){
        ArrayList<PhieuNhapSachModel> pn = new ArrayList<PhieuNhapSachModel>();
        
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        
        try {
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PhieuNhapSachController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            sql = "{call GETTCPNS(?)}";
            callsql = conn.prepareCall(sql);
            callsql.registerOutParameter(1, OracleTypes.CURSOR);
            callsql.execute();
            rs =  (ResultSet) callsql.getObject(1);
            while(rs.next()) {
                PhieuNhapSachModel pnModel = new PhieuNhapSachModel(
                                         rs.getInt("MAPNS"),
                                         rs.getLong("TONGTIENNHAPSACH"),
                                         rs.getDate("NGAYNHAPSACH").toLocalDate(),
                                         rs.getString("TENNPP"),
                                         rs.getString("HOTEN")
                                         );
                pn.add(pnModel);
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return pn;
    }
    
    public ArrayList<PhieuNhapSachModel> TimKiem(String choice, String search){
        ArrayList<PhieuNhapSachModel> pn = new ArrayList<PhieuNhapSachModel>();
        
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        
        try {
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PhieuNhapSachController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(choice.equals("Mã phiếu nhập sách")){
                sql = "{call GETPNSTHEOMA(?,?)}";
                callsql = conn.prepareCall(sql);
                callsql.setString(1, search);
                callsql.registerOutParameter(2, OracleTypes.CURSOR);
            }
                
            else if(choice.equals("Tên nhân viên")){
                int MaTk = tk.GetMaTKTheoTen(search);
                sql = "{call GETPNSTHEONV(?,?)}";
                callsql = conn.prepareCall(sql);
                callsql.setInt(1, MaTk);
                callsql.registerOutParameter(2, OracleTypes.CURSOR);
            }
            else if(choice.equals("Tên nhà phân phối")){
                int MaPnn = npp.GetNPPTheoTen(search);
                sql = "{call GETPNSTHEONPP(?, ?)}";
                callsql = conn.prepareCall(sql);
                callsql.setInt(1, MaPnn);
                callsql.registerOutParameter(2, OracleTypes.CURSOR);
            }
           
            callsql.execute();
            rs =  (ResultSet) callsql.getObject(2);
           while(rs.next()) {
                PhieuNhapSachModel pnModel = new PhieuNhapSachModel(
                                         rs.getInt("MAPNS"),
                                         rs.getLong("TONGTIENNHAPSACH"),
                                         rs.getDate("NGAYNHAPSACH").toLocalDate(),
                                         rs.getString("TENNPP"),
                                         rs.getString("HOTEN")
                                         );
                 pn.add(pnModel);
            }   
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return pn;
    }
    
    public ArrayList<SachModel> GetSachTheoMaPNS(int MaPNS){
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
            sql = "{call GETSACHTHEOPNS(?, ?)}";
                
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, MaPNS);
            callsql.registerOutParameter(2, OracleTypes.CURSOR);
            callsql.execute();
            rs = (ResultSet) callsql.getObject(2);
            while(rs.next()){
                SachModel s = new
                    SachModel(rs.getInt("MASACH"), 
                            rs.getInt("SOLUONGNHAPTUNGCUONSACH"), 
                            rs.getInt("MATL"), 
                            rs.getString("TENSACH"),
                            rs.getString("TENTG"), 
                            rs.getString("NXB"), 
                            rs.getString("ANHSACH"), 
                            rs.getLong("GIASACHNHAP"), 
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
    
    public int ThemPN(PhieuNhapSachModel pns){
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
            sql = "{call ThemPNS(?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, pns.getMaNPP());
            callsql.setInt(2, pns.getMaTK());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public int PhieuNhapSachVuaTao(){
        Connection conn = null;
        CallableStatement callsql = null;
        ResultSet rs = null;
        String sql = "";
        int PNSVuaTao = 0;
        try{
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call GETMaPNS(?)}";
            callsql = conn.prepareCall(sql);
            callsql.registerOutParameter(1, OracleTypes.CURSOR);
            callsql.execute();
            rs = (ResultSet) callsql.getObject(1);
            if(rs.next()){
                PNSVuaTao  = rs.getInt("MAX(MAPNS)");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return PNSVuaTao ;
    }
    
    public int ThemCTPNS(PhieuNhapSachModel pns){
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
            sql = "{call ThemCTPNSACH(?, ?, ?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, pns.getMaPNS());
            callsql.setInt(2, pns.getMaSach());
            callsql.setInt(3, pns.getSoLuong());
            callsql.setLong(4, pns.getTongTien());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public void XuatHoaDonChoPN(int Ma){
        try {
            Hashtable hashtable = new Hashtable();
            JasperReport hdonPN = JasperCompileManager.compileReport("src\\Report\\reportPN.jrxml");
            hashtable.put("mpn", Ma);
            JasperPrint jsprint = JasperFillManager.fillReport(hdonPN, hashtable, ConnectDB.getJDBCConnection());
            JasperViewer.viewReport(jsprint, false);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
