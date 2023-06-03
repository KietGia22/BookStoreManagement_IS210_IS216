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

/**
 *
 * @author GIA KIET
 */
public class PhieuNhapSachController {
    
    public TaiKhoanController tk = new TaiKhoanController();
    public NhaPhanPhoiController npp = new NhaPhanPhoiController();
    
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
}
