/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import Controller.TaiKhoanController;
import Model.TaiKhoanModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author GIA KIET
 */
public class Them_TK extends javax.swing.JFrame {

    /**
     * Creates new form Them_Tk
     */
    public Them_TK() {
        initComponents();
    }
    public String TenDNHome, MatKhauHome;
    
    public Them_TK(String TenDN, String MatKhau){
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.TenDNHome = TenDN;
        this.MatKhauHome = MatKhau;
    }

    public void Reset(){
        HoTen_txt.setText("");
        gmail_txt.setText("");
        DC_txt.setText("");
        SDT_txt.setText("");
        Luong_txt.setText("");
        CV_txt.setText("");
        NgSinh.setDate(null);
        NgTao.setDate(null);
    }
    
    public boolean CheckSDT(String regax){
        return regax.matches("^\\d{10}$");
    }
    
    public boolean CheckEmail(String regax){
        return regax.matches("^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
    }
    
    public boolean CheckNumberOrNot(String regax){
        return regax.matches("-?\\d+(\\.\\d+)?");
    }
    
    public TaiKhoanController tk = new TaiKhoanController();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        HoTen_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        NgSinh = new com.github.lgooddatepicker.components.DatePicker();
        jLabel9 = new javax.swing.JLabel();
        gmail_txt = new javax.swing.JTextField();
        DC_label = new javax.swing.JLabel();
        DC_txt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        SDT_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CV_txt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TDN_txt = new javax.swing.JTextField();
        NgTao = new com.github.lgooddatepicker.components.DatePicker();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        LuuBtn = new javax.swing.JButton();
        QlaiBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        Luong_txt = new javax.swing.JTextField();
        MK_txt = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thêm tài khoản cho nhân viên");

        jPanel1.setBackground(new java.awt.Color(173, 216, 230));

        jLabel4.setText("Họ Tên");
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        HoTen_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        HoTen_txt.setAutoscrolls(false);
        HoTen_txt.setBackground(new java.awt.Color(173, 216, 230));
        HoTen_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Ngày sinh");
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel9.setText("Gmail");
        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        gmail_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        gmail_txt.setAutoscrolls(false);
        gmail_txt.setBackground(new java.awt.Color(173, 216, 230));
        gmail_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        DC_label.setText("Địa chỉ");
        DC_label.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        DC_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DC_txt.setAutoscrolls(false);
        DC_txt.setBackground(new java.awt.Color(173, 216, 230));
        DC_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Số điện thoại");
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        SDT_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        SDT_txt.setAutoscrolls(false);
        SDT_txt.setBackground(new java.awt.Color(173, 216, 230));
        SDT_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Chức vụ");
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        CV_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        CV_txt.setAutoscrolls(false);
        CV_txt.setBackground(new java.awt.Color(173, 216, 230));
        CV_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        CV_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV_txtActionPerformed(evt);
            }
        });

        jLabel8.setText("Ngày tạo tài khoản");
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        TDN_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        TDN_txt.setAutoscrolls(false);
        TDN_txt.setBackground(new java.awt.Color(173, 216, 230));
        TDN_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        NgTao.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        NgTao.setFocusable(false);

        jLabel6.setText("Tên đăng nhập");
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel10.setText("Mật khẩu");
        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        LuuBtn.setText("Lưu lại");
        LuuBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 2, true));
        LuuBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        LuuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LuuBtnActionPerformed(evt);
            }
        });

        QlaiBtn.setText("Quay lại");
        QlaiBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 2, true));
        QlaiBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        QlaiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QlaiBtnActionPerformed(evt);
            }
        });

        jLabel11.setText("Lương theo giờ");
        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        Luong_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Luong_txt.setAutoscrolls(false);
        Luong_txt.setBackground(new java.awt.Color(173, 216, 230));
        Luong_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        MK_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        MK_txt.setBackground(new java.awt.Color(173, 216, 230));
        MK_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(DC_label, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(86, 86, 86)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(DC_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gmail_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(75, 75, 75)
                                .addComponent(CV_txt)
                                .addGap(2, 2, 2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(40, 40, 40)
                                .addComponent(SDT_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(HoTen_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NgSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(109, 109, 109)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(TDN_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(MK_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(Luong_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(NgTao, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LuuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(QlaiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HoTen_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NgSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gmail_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DC_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DC_label, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TDN_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MK_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Luong_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(NgTao, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SDT_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QlaiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LuuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 100, 100));

        jLabel1.setText("Thêm thông tin nhân viên");
        jLabel1.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CV_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CV_txtActionPerformed

    private void QlaiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QlaiBtnActionPerformed
        // TODO add your handling code here:
        new TaiKhoan(TenDNHome, MatKhauHome);
        this.dispose();
    }//GEN-LAST:event_QlaiBtnActionPerformed

    private void LuuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LuuBtnActionPerformed
        // TODO add your handling code here:
        String TenDN = TDN_txt.getText();
        String MatKhau = MK_txt.getText();
        String HoTen = HoTen_txt.getText();
        String Gmail = gmail_txt.getText();
        String SDT = SDT_txt.getText();
        String DiaChi = DC_txt.getText();
        String ChucVuNV = CV_txt.getText();
        String Luong = Luong_txt.getText();
        LocalDate date1 = NgSinh.getDate();
        LocalDate date2 = NgTao.getDate();
        String NgaySinh = date1.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String NgayTaoTK = date2.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate NgSinhLC = LocalDate.parse(NgaySinh, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate NgTaoLC = LocalDate.parse(NgayTaoTK, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        if(HoTen.isEmpty() || Gmail.isEmpty() || SDT.isEmpty() || DiaChi.isEmpty() || ChucVuNV.isEmpty() || Luong.isEmpty() || NgaySinh.isEmpty() || NgayTaoTK.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(CheckSDT(SDT) == false) {
            JOptionPane.showMessageDialog(this, "Sai định dạng SDT", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(CheckEmail(Gmail) == false) {
            JOptionPane.showMessageDialog(this, "Sai định dạng Email", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(CheckNumberOrNot(HoTen) == true || CheckNumberOrNot(ChucVuNV) == true){
            JOptionPane.showMessageDialog(this, "Họ tên hoặc chức vụ không chứa số", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(CheckNumberOrNot(SDT) == false || CheckNumberOrNot(Luong) == false){
            JOptionPane.showMessageDialog(this, "Lương hoặc SĐT phải là số", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (Long.parseLong(Luong) <=0){
            JOptionPane.showMessageDialog(this, "Lương phải lớn hơn 0", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int opt = JOptionPane.showConfirmDialog(this, "Bạn có chắc là muốn thêm thông tin nhân viên này", "Thêm nhân viên", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opt == JOptionPane.YES_OPTION) {
                TaiKhoanModel tkm = new TaiKhoanModel(Long.parseLong(Luong), TenDN, MatKhau, HoTen, DiaChi, SDT, Gmail, ChucVuNV, NgSinhLC, NgTaoLC);
                    if(tk.ThemTK(tkm) != 0){
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        Reset();
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
            }
    }//GEN-LAST:event_LuuBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Them_TK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Them_TK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Them_TK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Them_TK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Them_TK().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CV_txt;
    private javax.swing.JLabel DC_label;
    private javax.swing.JTextField DC_txt;
    private javax.swing.JTextField HoTen_txt;
    private javax.swing.JTextField Luong_txt;
    private javax.swing.JButton LuuBtn;
    private javax.swing.JPasswordField MK_txt;
    private com.github.lgooddatepicker.components.DatePicker NgSinh;
    private com.github.lgooddatepicker.components.DatePicker NgTao;
    private javax.swing.JButton QlaiBtn;
    private javax.swing.JTextField SDT_txt;
    private javax.swing.JTextField TDN_txt;
    private javax.swing.JTextField gmail_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
