/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.ConnectDB;
import Model.KhachHangModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;

public class KhachHangController {
    
    public void Add(ArrayList<KhachHangModel> arrkhmodel, DefaultTableModel table){
        for(KhachHangModel i : arrkhmodel){
            Object[] obj = {i.getMaKH(), i.getHoTen(), i.toString(i.getNgSinh()), i.getDiaChi(), i.getSDT(), i.getCCCD(), i.toString(i.getNgTao()), i.getGioiTinh()};
            table.addRow(obj);
        }
    }
    
    public ArrayList<KhachHangModel> getTCKhachHang() {
        ArrayList<KhachHangModel> khModel = new ArrayList<KhachHangModel>();
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
            sql = "{call  GETTCKH(?)}";
            callsql = conn.prepareCall(sql);
            callsql.registerOutParameter(1, OracleTypes.CURSOR);
            callsql.execute();
            rs = (ResultSet) callsql.getObject(1);
            while (rs.next()) {
                KhachHangModel kh = new KhachHangModel(rs.getInt("MAKH"), rs.getString("HOTEN"), rs.getString("SDT"),
                        rs.getString("DIACHI"), rs.getString("GIOITINH"), rs.getDate("NGAYSINH").toLocalDate(),
                        rs.getDate("NGAYTAO").toLocalDate(), rs.getString("CCCD"));
                khModel.add(kh);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khModel;
    }

    public ArrayList<KhachHangModel> TimKiemKH(String choice, String search) {
        ArrayList<KhachHangModel> khModel = new ArrayList<KhachHangModel>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        try {
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (choice.equals("Mã khách hàng")) {
                sql = "{call GETKHTHEOMA(?, ?)}";
            } else {
                sql = "{call GETKHTHEOTEN(?, ?)}";
            }
            callsql = conn.prepareCall(sql);
            callsql.setString(1, search);
            callsql.registerOutParameter(2, OracleTypes.CURSOR);
            callsql.execute();
            rs = (ResultSet) callsql.getObject(2);
            while (rs.next()) {
                KhachHangModel kh = new KhachHangModel(rs.getInt("MAKH"), rs.getString("HOTEN"), rs.getString("SDT"),
                        rs.getString("DIACHI"), rs.getString("GIOITINH"), rs.getDate("NGAYSINH").toLocalDate(),
                        rs.getDate("NGAYTAO").toLocalDate(), rs.getString("CCCD"));
                khModel.add(kh);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khModel;
    }

    public int ThemKH(KhachHangModel kh) {
        Connection conn = null;
        CallableStatement callsql = null;
        String sql = "";
        int check;
        try {
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call ThemKH(?, to_date(?, ('dd-mm-yyyy')), ?, ?, ?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setString(1, kh.getHoTen());
            callsql.setString(2, kh.toString(kh.getNgSinh()));
            callsql.setString(3, kh.getDiaChi());
            callsql.setString(4, kh.getSDT());
            callsql.setString(5, kh.getGioiTinh());
            callsql.setString(6, kh.getCCCD());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int SuaKH(KhachHangModel kh) {
        Connection conn = null;
        CallableStatement callsql = null;
        String sql;
        int check;
        try {
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call SuaKH(?, ?, to_date(?, ('dd-mm-yyyy')), ?, ?, ?, ?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, kh.getMaKH());
            callsql.setString(2, kh.getHoTen());
            callsql.setString(3, kh.toString(kh.getNgSinh()));
            callsql.setString(4, kh.getDiaChi());
            callsql.setString(5, kh.getSDT());
            callsql.setString(6, kh.getGioiTinh());
            callsql.setString(7, kh.getCCCD());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int XoaKH(KhachHangModel kh) {
        Connection conn = null;
        CallableStatement callsql = null;
        String sql;
        int check;
        try {
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sql = "{call XoaKH(?)}";
            callsql = conn.prepareCall(sql);
            callsql.setInt(1, kh.getMaKH());
            check = callsql.executeUpdate();
            conn.close();
            return check;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
