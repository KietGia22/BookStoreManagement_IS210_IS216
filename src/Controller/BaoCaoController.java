/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.ConnectDB;
import Model.BaoCaoTonModel;
import Model.HoaDonModel;
import Model.SachModel;
import Model.BaoCaoDoanhThuModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javax.naming.spi.DirStateFactory.Result;

/**
 *
 * @author nosc
 */
public class BaoCaoController {

    Connection conn = null;
    Statement state = null;
    ResultSet rs = null;
    Calendar calendar = Calendar.getInstance();
    int currentMonth = calendar.get(Calendar.MONTH) + 1;
    int currentYear = calendar.get(Calendar.YEAR);
    int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

    public void Close() throws SQLException {
        conn.close();
        state.close();
        rs.close();
    }

    // Lấy ra danh sách tất cả Sách
    public ArrayList<SachModel> GetAllBook() {
        ArrayList<SachModel> listsachModel = new ArrayList<SachModel>();
        try {
            Connection connect = ConnectDB.getJDBCConnection();
            Statement st = connect.createStatement();
            ResultSet rs_sach = st.executeQuery("SELECT * FROM SACH");
            while (rs_sach.next()) {
                SachModel sach = new SachModel(
                        rs_sach.getInt("MASACH"),
                        rs_sach.getInt("SLHIENCO"),
                        rs_sach.getInt("MATL"),
                        rs_sach.getString("TENSACH"),
                        rs_sach.getString("TENTG"),
                        rs_sach.getString("NXB"),
                        rs_sach.getString("ANHSACH"),
                        rs_sach.getLong("GIATIEN"),
                        GetCategoryName(rs_sach.getInt("MATL")));
                listsachModel.add(sach);
            }
            System.out.println("Get all book success");
            connect.close();
            st.close();
            rs_sach.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listsachModel;
    }

    // Lấy ra hóa đơn theo mã sách và khoảng thời gian
    public HoaDonModel GetHoaDonByMaSach(int MaSach, int month, int year) {
        HoaDonModel hd = new HoaDonModel();
        try {
            Connection connect = ConnectDB.getJDBCConnection();
            Statement st = connect.createStatement();
            ResultSet rs_hd = st.executeQuery("SELECT * FROM HOADON WHERE EXTRACT(MONTH FROM NGAYTAOHD) = " + month
                    + " AND EXTRACT(YEAR FROM NGAYTAOHD) = " + year);
            while (rs_hd.next()) {
                Statement state = connect.createStatement();
                ResultSet rs_cthd = state.executeQuery(
                        "SELECT * FROM CTHD WHERE MAHD = " + rs_hd.getInt("MAHD") + " AND MASACH = " + MaSach);
                hd.setMaSach(MaSach);
                while (rs_cthd.next()) {
                    hd.setMaHD(rs_cthd.getInt("MAHD"));
                    hd.setSoluong(hd.getSoluong() + rs_cthd.getInt("SOLUONGMUATUNGCUONSACH"));
                }
            }
            connect.close();
            st.close();
            rs_hd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;
    }

    // Lấy ra báo cáo tồn mới nhất của một cuốn sách
    public BaoCaoTonModel GetLastBCTByMaSach(int MaSach, int month, int year) {
        BaoCaoTonModel bctModel = new BaoCaoTonModel();
        try {
            Connection connect = ConnectDB.getJDBCConnection();
            Statement st = connect.createStatement();
            ResultSet rs1 = st.executeQuery(
                    "SELECT * FROM BAOCAOTON WHERE MASACH =" + MaSach + "AND  THANG = " + month + "AND NAM = " + year);
            if (rs1.next()) {
                BaoCaoTonModel bct = new BaoCaoTonModel(
                        rs1.getInt("MABAOCAO"),
                        rs1.getInt("THANG"),
                        rs1.getInt("NAM"),
                        rs1.getInt("MASACH"),
                        GetBookName(rs1.getInt("MASACH")),
                        GetCategoryName(rs1.getInt("MASACH")),
                        rs1.getInt("TONDAU"),
                        rs1.getInt("PHATSINH"),
                        rs1.getInt("TONCUOI"));
                bctModel = bct;
            }
            connect.close();
            st.close();
            rs1.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return bctModel;
    }

    // Lấy ra báo cáo doanh thu mới nhất của một cuốn sách
    public BaoCaoDoanhThuModel GetLastBCDTByMaSach(int MaSach, int month, int year) {
        BaoCaoDoanhThuModel bcdtModel = new BaoCaoDoanhThuModel();
        try {
            Connection connect = ConnectDB.getJDBCConnection();
            Statement st = connect.createStatement();
            ResultSet rs1 = st.executeQuery("SELECT * FROM BAOCAODOANHTHU WHERE MASACH =" + MaSach + "AND  THANG = "
                    + month + "AND NAM = " + year);
            if (rs1.next()) {
                BaoCaoDoanhThuModel bcdt = new BaoCaoDoanhThuModel(
                        rs1.getInt("MABAOCAO"),
                        rs1.getInt("THANG"),
                        rs1.getInt("NAM"),
                        rs1.getInt("MASACH"),
                        GetBookName(rs1.getInt("MASACH")),
                        GetCategoryName(rs1.getInt("MASACH")),
                        rs1.getInt("SOLUONG"),
                        rs1.getBigDecimal("GIATIEN"),
                        rs1.getBigDecimal("TONGTIEN"));
                bcdtModel = bcdt;
            }
            connect.close();
            st.close();
            rs1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bcdtModel;
    }

    // Tạo báo cáo tồn mới
    public void CreateBaoCaoTon() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, -1);
            int month = calendar.get(Calendar.MONTH) + 1;
            int year = calendar.get(Calendar.YEAR);

            calendar.add(Calendar.MONTH, -1);
            int lastMonth = calendar.get(Calendar.MONTH) + 1;
            int lastYear = calendar.get(Calendar.YEAR);

            ArrayList<SachModel> listsach = GetAllBook();
            for (SachModel sachModel : listsach) {
                BaoCaoTonModel last_bct = GetLastBCTByMaSach(sachModel.getMaSach(), lastMonth, lastYear);
                BaoCaoTonModel bct = GetLastBCTByMaSach(sachModel.getMaSach(), month, year);
                // Nếu sách không có trong báo cáo tồn tháng trước và ngày hiện tại là ngày 1
                // thì tạo mới
                if (currentDay == 8 && bct.getThang() != month && bct.getNam() != year) {
                    Connection connect = ConnectDB.getJDBCConnection();
                    String insertQuery = "INSERT INTO BAOCAOTON (MaBaoCao, Thang, Nam, MaSach, TonDau, PhatSinh, TonCuoi) VALUES (BCT_ID.nextval, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = connect.prepareStatement(insertQuery);
                    pstmt.setInt(1, month);
                    pstmt.setInt(2, year);
                    pstmt.setInt(3, sachModel.getMaSach());
                    pstmt.setInt(4, last_bct.getTonCuoi());
                    pstmt.setInt(5, (sachModel.getSlHienCo() - last_bct.getTonCuoi()));
                    pstmt.setInt(6, sachModel.getSlHienCo());
                    pstmt.executeUpdate();
                    System.out.println("Tạo báo cáo tồn mới thành công");
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // Tạo báo cáo doanh thu mới
    public void CreateBaoCaoDT() {
        try {
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH) + 1;
            int year = calendar.get(Calendar.YEAR);
            ArrayList<SachModel> listsach = GetAllBook();
            for (SachModel sachModel : listsach) {
                BaoCaoDoanhThuModel bcdt = GetLastBCDTByMaSach(sachModel.getMaSach(), month, year);
                try {
                    Connection connect = ConnectDB.getJDBCConnection();
                    if (bcdt.getThang() == month && bcdt.getNam() == year) {
                        String deleteQuery = "DELETE FROM BAOCAODOANHTHU WHERE THANG = " + month + "AND NAM = " + year;
                        PreparedStatement pstmt1 = connect.prepareStatement(deleteQuery);
                        pstmt1.executeUpdate();
                    }
                    String insertQuery = "INSERT INTO BAOCAODOANHTHU (MaBaoCao, Thang, Nam, MaSach, GiaTien, SoLuong, TongTien) VALUES (BCDT_ID.nextval, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = connect.prepareStatement(insertQuery);
                    pstmt.setInt(1, month);
                    pstmt.setInt(2, year);
                    pstmt.setInt(3, sachModel.getMaSach());
                    pstmt.setLong(4, sachModel.getGiaTien());
                    HoaDonModel hd = GetHoaDonByMaSach(sachModel.getMaSach(), month, year);
                    pstmt.setInt(5, hd.getSoluong());
                    pstmt.setLong(6, hd.getSoluong() * sachModel.getGiaTien());
                    pstmt.executeUpdate();
                    System.out.println("Tạo báo cáo doanh thu mới thành công");
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public int GetMinYear() {
        int year = 0;
        try {
            conn = ConnectDB.getJDBCConnection();
            state = conn.createStatement();
            rs = state.executeQuery("SELECT MIN(NAM) AS NAM FROM BAOCAOTON");
            if (rs.next()) {
                year = rs.getInt("NAM");
                System.out.println("sucess");
            } else {
                year = Calendar.getInstance().get(Calendar.YEAR);
            }
            Close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return year;
    }

    // Get book name
    public String GetBookName(int MaSach) {
        String TenSach = "";
        try {
            conn = ConnectDB.getJDBCConnection();
            Statement statement = conn.createStatement();
            ResultSet rset = statement.executeQuery("SELECT * FROM SACH WHERE MASACH = " + MaSach);
            while (rset.next()) {
                TenSach = rset.getString("TENSACH");
            }
            statement.close();
            rset.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TenSach;
    }

    // Get book category name
    public String GetCategoryName(int MaSach) {
        String TenTheLoai = "";
        try {
            conn = ConnectDB.getJDBCConnection();
            Statement stat_sach = conn.createStatement();
            ResultSet rset1 = stat_sach.executeQuery("SELECT * FROM SACH WHERE MASACH = " + MaSach);
            while (rset1.next()) {
                int MaTheLoai = rset1.getInt("MATL");
                Statement stat_theloai = conn.createStatement();
                ResultSet rset2 = stat_theloai.executeQuery("SELECT * FROM THELOAI WHERE MATL = " + MaTheLoai);
                while (rset2.next()) {
                    TenTheLoai = rset2.getString("TENTHELOAI");
                }
                rset2.close();
            }
            rset1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TenTheLoai;
    }

    public ArrayList<BaoCaoTonModel> GetListBaoCaoTon(int month, int year) {
        ArrayList<BaoCaoTonModel> list_bctModel = new ArrayList<BaoCaoTonModel>();
        try {
            conn = ConnectDB.getJDBCConnection();
            state = conn.createStatement();
            rs = state.executeQuery(
                    "SELECT * FROM BAOCAOTON WHERE THANG = " + month + " AND NAM = " + year + "ORDER BY MaBaoCao ASC");
            while (rs.next()) {
                String bookname = GetBookName(rs.getInt("MASACH"));
                BaoCaoTonModel bctModel = new BaoCaoTonModel(
                        rs.getInt("MABAOCAO"),
                        rs.getInt("THANG"),
                        rs.getInt("NAM"),
                        rs.getInt("MASACH"),
                        GetBookName(rs.getInt("MASACH")),
                        GetCategoryName(rs.getInt("MASACH")),
                        rs.getInt("TONDAU"),
                        rs.getInt("PHATSINH"),
                        rs.getInt("TONCUOI"));
                list_bctModel.add(bctModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_bctModel;
    }

    public ArrayList<BaoCaoDoanhThuModel> GetListBaoCaoDoanhThu(int month, int year) {
        ArrayList<BaoCaoDoanhThuModel> list_bcdtModel = new ArrayList<BaoCaoDoanhThuModel>();
        try {

            conn = ConnectDB.getJDBCConnection();
            state = conn.createStatement();
            rs = state.executeQuery("SELECT * FROM BAOCAODOANHTHU WHERE THANG = " + month + " AND NAM = " + year
                    + "ORDER BY MaBaoCao ASC");
            while (rs.next()) {
                BaoCaoDoanhThuModel bcdtModel = new BaoCaoDoanhThuModel(
                        rs.getInt("MABAOCAO"),
                        rs.getInt("THANG"),
                        rs.getInt("NAM"),
                        rs.getInt("MASACH"),
                        GetBookName(rs.getInt("MASACH")),
                        GetCategoryName(rs.getInt("MASACH")),
                        rs.getInt("SOLUONG"),
                        rs.getBigDecimal("GIATIEN"),
                        rs.getBigDecimal("TONGTIEN"));
                list_bcdtModel.add(bcdtModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_bcdtModel;
    }
}
