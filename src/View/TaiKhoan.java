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
public class TaiKhoan extends javax.swing.JFrame {

    /**
     * Creates new form TaiKhoan
     */
    public TaiKhoan() {
        initComponents();
        GetAllNhanVien();
    }
    
    public String TenDNHome, MatKhauHome;
    public int ID;
    
    public TaiKhoan(String TenDN, String MatKhau){
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.TenDNHome = TenDN;
        this.MatKhauHome = MatKhau;
        GetAllNhanVien();
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
    public int ChucVu = tk.TraVeChucVu(TenDNHome, MatKhauHome);
    DefaultTableModel table = new DefaultTableModel();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        Search_txt1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        SearchBtn1 = new javax.swing.JButton();
        QlaiBtn1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        AddTKBtn = new javax.swing.JButton();
        UpdateTKBtn = new javax.swing.JButton();
        DelTKBtn = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        HoTen_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        NgSinh = new com.github.lgooddatepicker.components.DatePicker();
        jLabel9 = new javax.swing.JLabel();
        gmail_txt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        DC_txt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        SDT_txt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        NgTao = new com.github.lgooddatepicker.components.DatePicker();
        jLabel10 = new javax.swing.JLabel();
        Luong_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CV_txt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Danh sách tài khoản nhân viên cửa hàng");

        jPanel3.setBackground(new java.awt.Color(173, 216, 230));

        Search_txt1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Search_txt1.setBackground(new java.awt.Color(173, 216, 230));
        Search_txt1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã nhân viên", "Tên nhân viên" }));
        jComboBox2.setBackground(new java.awt.Color(0, 204, 204));
        jComboBox2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        SearchBtn1.setText("Tìm nhân viên");
        SearchBtn1.setBackground(new java.awt.Color(0, 204, 204));
        SearchBtn1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        SearchBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtn1ActionPerformed(evt);
            }
        });

        QlaiBtn1.setText("Quay lại");
        QlaiBtn1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 2, true));
        QlaiBtn1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        QlaiBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QlaiBtn1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã TK", "Họ tên", "Ngày sinh ", "Gmail", "Địa chỉ", "SĐT", "Lương", "Ngày tạo", "Chức vụ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setBackground(new java.awt.Color(0, 204, 204));
        jTable2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jTable2.setShowGrid(true);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(330);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(6).setResizable(false);
            jTable2.getColumnModel().getColumn(7).setResizable(false);
            jTable2.getColumnModel().getColumn(8).setResizable(false);
        }

        AddTKBtn.setText("Thêm nhân viên");
        AddTKBtn.setBackground(new java.awt.Color(0, 204, 204));
        AddTKBtn.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        AddTKBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTKBtnActionPerformed(evt);
            }
        });

        UpdateTKBtn.setText("Sửa nhân viên");
        UpdateTKBtn.setBackground(new java.awt.Color(0, 204, 204));
        UpdateTKBtn.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        UpdateTKBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateTKBtnActionPerformed(evt);
            }
        });

        DelTKBtn.setText("Xoá nhân viên");
        DelTKBtn.setBackground(new java.awt.Color(0, 204, 204));
        DelTKBtn.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        DelTKBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelTKBtnActionPerformed(evt);
            }
        });

        ResetBtn.setText("Làm mới");
        ResetBtn.setBackground(new java.awt.Color(0, 204, 204));
        ResetBtn.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Họ Tên");
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        HoTen_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        HoTen_txt.setBackground(new java.awt.Color(173, 216, 230));
        HoTen_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Ngày sinh");
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        NgSinh.setBackground(new java.awt.Color(173, 216, 230));
        NgSinh.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        NgSinh.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel9.setText("Gmail");
        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        gmail_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        gmail_txt.setBackground(new java.awt.Color(173, 216, 230));
        gmail_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        jLabel6.setText("Địa chỉ");
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        DC_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DC_txt.setBackground(new java.awt.Color(173, 216, 230));
        DC_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Số điện thoại");
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        SDT_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        SDT_txt.setBackground(new java.awt.Color(173, 216, 230));
        SDT_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        jLabel8.setText("Ngày tạo tài khoản");
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        NgTao.setBackground(new java.awt.Color(173, 216, 230));
        NgTao.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        NgTao.setEnabled(false);
        NgTao.setFocusable(false);
        NgTao.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel10.setText("Lương");
        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        Luong_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Luong_txt.setBackground(new java.awt.Color(173, 216, 230));
        Luong_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Chức vụ");
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        CV_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        CV_txt.setBackground(new java.awt.Color(173, 216, 230));
        CV_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Search_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(HoTen_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                    .addComponent(DC_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Luong_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CV_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NgSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SDT_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gmail_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NgTao, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(AddTKBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(UpdateTKBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DelTKBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(QlaiBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(HoTen_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(NgSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gmail_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DC_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SDT_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NgTao, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Luong_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CV_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Search_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddTKBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateTKBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelTKBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(QlaiBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 100, 100));

        jLabel2.setText("Danh sách nhân viên");
        jLabel2.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(419, 419, 419)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddTKBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTKBtnActionPerformed
        // TODO add your handling code here:
        new Them_TK(TenDNHome, MatKhauHome);
        dispose();
    }//GEN-LAST:event_AddTKBtnActionPerformed

    private void UpdateTKBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTKBtnActionPerformed
        // TODO add your handling code here:
        LocalDate date1 = NgSinh.getDate();
        LocalDate date2 = NgTao.getDate();
        String NgayTaoTK = "";
        LocalDate NgTaoLC = null;
        String NgaySinh = "";
        LocalDate NgSinhLC = null;
        
        if(date1 != null){
            NgaySinh = date1.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            NgSinhLC = LocalDate.parse(NgaySinh, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }    
        if(date2 != null){
            NgayTaoTK = date2.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            NgTaoLC = LocalDate.parse(NgayTaoTK, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
        if(HoTen_txt.getText().isEmpty() || gmail_txt.getText().isEmpty() || SDT_txt.getText().isEmpty() || DC_txt.getText().isEmpty() || CV_txt.getText().isEmpty() || Luong_txt.getText().isEmpty() || NgaySinh.isEmpty() || NgayTaoTK.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(CheckSDT(SDT_txt.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Sai định dạng SDT", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(CheckEmail(gmail_txt.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Sai định dạng Email", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(CheckNumberOrNot(HoTen_txt.getText()) == true || CheckNumberOrNot(CV_txt.getText()) == true){
            JOptionPane.showMessageDialog(this, "Họ tên hoặc chức vụ không chứa số", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(CheckNumberOrNot(SDT_txt.getText()) == false || CheckNumberOrNot(Luong_txt.getText()) == false){
            JOptionPane.showMessageDialog(this, "Lương hoặc SĐT phải là số", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (Long.parseLong(Luong_txt.getText()) <=0){
            JOptionPane.showMessageDialog(this, "Lương phải lớn hơn 0", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int opt = JOptionPane.showConfirmDialog(this, "Bạn có chắc là muốn cập nhập thông tin nhân viên này", "Chỉnh sửa nhân viên", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == JOptionPane.YES_OPTION) {
            TaiKhoanModel tkm = new TaiKhoanModel(ID, Long.parseLong(Luong_txt.getText()), TenDNHome, MatKhauHome, HoTen_txt.getText(), DC_txt.getText(), SDT_txt.getText(), gmail_txt.getText(), CV_txt.getText(), NgSinhLC, NgTaoLC);
            if(tk.SuaTK(tkm) != 0){
                JOptionPane.showMessageDialog(this, "Chỉnh sửa thành công");
                Reset();
                GetAllNhanVien();
            } else {
                JOptionPane.showMessageDialog(this, "Chỉnh sửa thất bại", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }//GEN-LAST:event_UpdateTKBtnActionPerformed

    private void DelTKBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelTKBtnActionPerformed
        // TODO add your handling code here:
        LocalDate date1 = NgSinh.getDate();
        LocalDate date2 = NgTao.getDate();
        String NgayTaoTK = "";
        LocalDate NgTaoLC = null;
        String NgaySinh = "";
        LocalDate NgSinhLC = null;
        
        if(date1 != null){
            NgaySinh = date1.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            NgSinhLC = LocalDate.parse(NgaySinh, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }    
        if(date2 != null){
            NgayTaoTK = date2.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            NgTaoLC = LocalDate.parse(NgayTaoTK, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
        if(HoTen_txt.getText().isEmpty() || gmail_txt.getText().isEmpty() || SDT_txt.getText().isEmpty() || DC_txt.getText().isEmpty() || CV_txt.getText().isEmpty() || Luong_txt.getText().isEmpty() || NgaySinh.isEmpty() || NgayTaoTK.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
       
       int opt = JOptionPane.showConfirmDialog(this, "Bạn có chắc là muốn xoá nhân viên này", "Xoá nhân viên", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       if (opt == JOptionPane.YES_OPTION) {
            TaiKhoanModel tkm = new TaiKhoanModel(ID, Long.parseLong(Luong_txt.getText()), TenDNHome, MatKhauHome, HoTen_txt.getText(), DC_txt.getText(), SDT_txt.getText(), gmail_txt.getText(), CV_txt.getText(), NgSinhLC, NgTaoLC);
            if(tk.XoaTK(tkm) != 0){
                JOptionPane.showMessageDialog(this, "Xoá thành công");
                Reset();
                GetAllNhanVien();
            } else {
                JOptionPane.showMessageDialog(this, "Xoá thất bại", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }//GEN-LAST:event_DelTKBtnActionPerformed

    private void QlaiBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QlaiBtn1ActionPerformed
        // TODO add your handling code here:
        new Home(TenDNHome, MatKhauHome);
        dispose();
    }//GEN-LAST:event_QlaiBtn1ActionPerformed

    private void SearchBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtn1ActionPerformed
        // TODO add your handling code here:
        String search = Search_txt1.getText();
        String choice = jComboBox2.getSelectedItem().toString();
        DefaultTableModel Table_for_search = (DefaultTableModel) jTable2.getModel();
        Table_for_search.setRowCount(0);
        ArrayList<TaiKhoanModel> tkmodel = new ArrayList<TaiKhoanModel>();
        if(CheckNumberOrNot(search) == false && choice.equals("Mã nhân viên")){
            JOptionPane.showMessageDialog(this, "Mã nhân viên phải là số", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            tkmodel = tk.TimKiemTK(choice, search);
            Add(tkmodel, Table_for_search);
        }
    }//GEN-LAST:event_SearchBtn1ActionPerformed

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        // TODO add your handling code here:
        Reset();
        GetAllNhanVien();
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        try {
            // TODO add your handling code here:
            int selectedRow = jTable2.getSelectedRow();
            DefaultTableModel temp = (DefaultTableModel) jTable2.getModel();
            
            HoTen_txt.setText(temp.getValueAt(selectedRow, 1).toString());
            gmail_txt.setText(temp.getValueAt(selectedRow, 3).toString());
            DC_txt.setText(temp.getValueAt(selectedRow, 4).toString());
            SDT_txt.setText(temp.getValueAt(selectedRow, 5).toString());
            Luong_txt.setText(temp.getValueAt(selectedRow, 6).toString());
            CV_txt.setText(temp.getValueAt(selectedRow, 8).toString());
            
            SimpleDateFormat dtformat = new SimpleDateFormat("dd-MM-yyyy");
   
            Date date1 = dtformat.parse((String)temp.getValueAt(selectedRow, 2).toString());
            Date date2 = dtformat.parse((String)temp.getValueAt(selectedRow, 7).toString());
            LocalDate NgSinhLocal = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate NgTaoTKLocal = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            
            NgSinh.setDate(NgSinhLocal);
            NgTao.setDate(NgTaoTKLocal);
            
            ID = Integer.parseInt(temp.getValueAt(selectedRow, 0).toString());
        } catch (ParseException ex) {
            Logger.getLogger(TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    public void Add(ArrayList<TaiKhoanModel> tkmodel, DefaultTableModel table){
        for(TaiKhoanModel i : tkmodel){
            Object[] obj = {i.getMaTK(), i.getHoTen(), i.toString(i.getNgSinh()), i.getGmail(), i.getDiaChi(), i.getSDT(), i.getLuong(), i.toString(i.getNgTaoTK()), i.getChucVu()};
            table.addRow(obj);
        }
    }
    
    public void GetAllNhanVien(){
        String[] title = {"Mã TK", "Họ Tên", "Ngày sinh", "Gmail", "Địa chỉ", "SĐT", "Lương", "Ngày tạo", "Chức vụ"};
        table.setColumnIdentifiers(title);
        table.setRowCount(0);
        ArrayList<TaiKhoanModel> tkmodel = new ArrayList<TaiKhoanModel>();
        tkmodel = tk.getTCTaiKhoan();
        Add(tkmodel, table);
        jTable2.setModel(table);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(35);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(350);
        jTable2.getColumnModel().getColumn(5).setPreferredWidth(35);
        jTable2.getColumnModel().getColumn(6).setPreferredWidth(10);
        jTable2.getColumnModel().getColumn(7).setPreferredWidth(35);
    }
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
            java.util.logging.Logger.getLogger(TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaiKhoan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddTKBtn;
    private javax.swing.JTextField CV_txt;
    private javax.swing.JTextField DC_txt;
    private javax.swing.JButton DelTKBtn;
    private javax.swing.JTextField HoTen_txt;
    private javax.swing.JTextField Luong_txt;
    private com.github.lgooddatepicker.components.DatePicker NgSinh;
    private com.github.lgooddatepicker.components.DatePicker NgTao;
    private javax.swing.JButton QlaiBtn1;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JTextField SDT_txt;
    private javax.swing.JButton SearchBtn1;
    private javax.swing.JTextField Search_txt1;
    private javax.swing.JButton UpdateTKBtn;
    private javax.swing.JTextField gmail_txt;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
