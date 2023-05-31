/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.ConnectDB;
import Model.PhieuNhapModel;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author GIA KIET
 */
public class PhieuNhapController {
    public ArrayList<PhieuNhapModel> getThongTinPhieuNhap(){
        ArrayList<PhieuNhapModel> pn = new ArrayList<PhieuNhapModel>();
        
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement callsql = null;
        String sql = "";
        
        try {
            try {
                conn = ConnectDB.getJDBCConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PhieuNhapController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            sql = "{call GETTCPN(?)}";
            callsql = conn.prepareCall(sql);
            callsql.registerOutParameter(1, OracleTypes.CURSOR);
            callsql.execute();
            rs =  (ResultSet) callsql.getObject(1);
            while(rs.next()) {
                PhieuNhapModel pnModel = new PhieuNhapModel(
                                         rs.getInt("MAPN"),
                                         rs.getLong("TONGTIENNHAP"),
                                         rs.getDate("NGAYNHAP").toLocalDate(),
                                         rs.getString("TENNCC"),
                                         rs.getString("HOTEN")
                                         );
                pn.add(pnModel);
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return pn;
    }
}
