/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.NhaPhanPhoiController;
import Controller.PhieuNhapSachController;
import Controller.SachController;
import Controller.TaiKhoanController;
import Model.PhieuNhapSachModel;
import Model.SachModel;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GIA KIET
 */
public class Them_PN extends javax.swing.JFrame {

    /**
     * Creates new form Them_PN
     */
    public Them_PN() {
        initComponents();
        GetTCSach();
    }
    
    String TenDNHome, MatKhauHome;
    int MaNPP;
    public DefaultTableModel table = new DefaultTableModel();
    public SachController s = new SachController();
    public TaiKhoanController tk = new TaiKhoanController();
    public PhieuNhapSachController pns = new PhieuNhapSachController();
    public NhaPhanPhoiController npp = new NhaPhanPhoiController();
    public String TLSach, TenSach;
    public int SLSachHienCo;
    public long GiaTienSach;
    public long TongTien = 0;
    public ArrayList<Object> Arrtemp = new ArrayList<Object>();
    
    public Them_PN(String TenDN, String MatKhau, int ID){
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.TenDNHome = TenDN;
        this.MatKhauHome = MatKhau;
        this.MaNPP = ID;
        GetTCSach();
    }
    
    public boolean CheckNumberOrNot(String regax){
        return regax.matches("-?\\d+(\\.\\d+)?");
    }
    
    public void Reset(){
        DefaultTableModel dm = (DefaultTableModel)jTable2.getModel();
        while(dm.getRowCount() > 0)
        {
            dm.removeRow(0);
        }
        Arrtemp.clear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Search_txt = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        SearchBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        GN_txt = new javax.swing.JTextField();
        DelBtn = new javax.swing.JButton();
        TaoHDBtn = new javax.swing.JButton();
        QlaiBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ThemBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        SL_txt1 = new javax.swing.JTextField();
        TTN_txt = new javax.swing.JTextField();
        ResetBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tạo phiếu nhập");

        jPanel1.setBackground(new java.awt.Color(173, 216, 230));

        jTable1.setBackground(new java.awt.Color(0, 204, 204));
        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Thể loại", "Số lượng hiện có", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setShowGrid(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setBackground(new java.awt.Color(0, 204, 204));
        jTable2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên sách", "Thể loại", "Tác giả", "Nhà sản xuất", "Nhà phân phối", "Số lượng nhập", "Đơn giá nhập", "Giá nhập"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Long.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setShowGrid(true);
        jScrollPane2.setViewportView(jTable2);

        Search_txt.setBackground(new java.awt.Color(173, 216, 230));
        Search_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Search_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));

        jComboBox1.setBackground(new java.awt.Color(0, 204, 204));
        jComboBox1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã sách", "Tên sách" }));

        SearchBtn.setBackground(new java.awt.Color(0, 204, 204));
        SearchBtn.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        SearchBtn.setText("Tìm sách muốn nhập");
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Giá nhập sách");

        GN_txt.setBackground(new java.awt.Color(173, 216, 230));
        GN_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        GN_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        DelBtn.setBackground(new java.awt.Color(0, 204, 204));
        DelBtn.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        DelBtn.setText("Xoá sách trong phiếu nhập");
        DelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelBtnActionPerformed(evt);
            }
        });

        TaoHDBtn.setBackground(new java.awt.Color(0, 204, 204));
        TaoHDBtn.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        TaoHDBtn.setText("Tạo phiếu nhập");
        TaoHDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaoHDBtnActionPerformed(evt);
            }
        });

        QlaiBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        QlaiBtn.setText("Quay lại");
        QlaiBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 51), 2, true));
        QlaiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QlaiBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Tổng tiền nhập:");

        ThemBtn.setBackground(new java.awt.Color(0, 204, 204));
        ThemBtn.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ThemBtn.setText("Thêm sách chọn vào phiếu nhập");
        ThemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Số lượng nhập");

        SL_txt1.setBackground(new java.awt.Color(173, 216, 230));
        SL_txt1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        SL_txt1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        TTN_txt.setBackground(new java.awt.Color(173, 216, 230));
        TTN_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        TTN_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        ResetBtn.setBackground(new java.awt.Color(0, 204, 204));
        ResetBtn.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ResetBtn.setText("Làm mới");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(SearchBtn))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(ResetBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TaoHDBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(SL_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TTN_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(GN_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ThemBtn)
                            .addComponent(DelBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(QlaiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TaoHDBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SL_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GN_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TTN_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ThemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(QlaiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))))
        );

        jPanel2.setBackground(new java.awt.Color(0, 100, 100));

        jLabel1.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tạo phiếu nhập sách");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(584, 584, 584)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel Table_for_search = (DefaultTableModel) jTable1.getModel();
        Table_for_search.setRowCount(0);
        ArrayList<SachModel> SModel = new ArrayList<SachModel>();
        if(CheckNumberOrNot(Search_txt.getText()) == false && jComboBox1.getSelectedItem().toString() == "Mã sách"){
            JOptionPane.showMessageDialog(this, "Mã sách phải là số", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            SModel = s.TimKiemSach(jComboBox1.getSelectedItem().toString(), Search_txt.getText());
                Add(SModel, Table_for_search);
        }
    }//GEN-LAST:event_SearchBtnActionPerformed

    private void ThemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemBtnActionPerformed
        // TODO add your handling code here:
        long TongTienChuaHoanChinh = 0;
        if(SL_txt1.getText().isEmpty() || GN_txt.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn đang để trống số lượng sách muốn mua hoặc giá nhập sách");
            return;
        } else if(CheckNumberOrNot(SL_txt1.getText()) == false || Integer.parseInt(SL_txt1.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số và có giá trị lớn hơn 0");
            return;
        } else if(GiaTienSach < Long.parseLong(GN_txt.getText())){
            JOptionPane.showMessageDialog(this, "Giá nhập phải nhỏ hơn Đơn giá của cuốn sách");
            return;
        }
        String title[] = {"Tên sách", "Thể loại", "Tác giả", "NXB", "Nhà phân phối", "Số lượng nhập", "Đơn giá", "Tổng tiền nhập"};
        DefaultTableModel tablePNS = new DefaultTableModel();
        tablePNS.setColumnIdentifiers(title);
        tablePNS.setRowCount(0);
        String GiaMua = Long.toString(Long.parseLong(GN_txt.getText()) * Integer.parseInt(SL_txt1.getText()));
        
        int opt = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm vào phiếu nhập", "Thêm vào phiếu nhập sách", JOptionPane.YES_NO_OPTION);
        if(opt == JOptionPane.YES_OPTION){
            String TG = s.LayThongTinTacGia(TenSach);
            String NXB = s.LayThongTinNXB(TenSach); 
            String TenNPP = npp.GetTenNPPTheoMa(MaNPP);
            Object[] obj = {TenSach, TLSach, TG, NXB, TenNPP, SL_txt1.getText(), GN_txt.getText(), GiaMua};
            Object[] tablenhap = null;
        
            for(Object i : Arrtemp){
                tablenhap = (Object[])i;
                if(tablenhap[0].toString().equals(obj[0].toString())){
                    JOptionPane.showMessageDialog(this, "Sách đã được chọn");
                    return;
                }
            }      
             Arrtemp.add(obj);
            for(Object i : Arrtemp){
                tablenhap = (Object[])i;
                tablePNS.addRow(tablenhap);
                TongTienChuaHoanChinh += Long.parseLong(tablenhap[7].toString());
            }    
            TongTien = TongTienChuaHoanChinh;
            System.out.println(TongTien);
            SL_txt1.setText("");
            GN_txt.setText("");
            TTN_txt.setText(Long.toString(TongTien));
            jTable2.setModel(tablePNS);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(240);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(45);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(55);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable2.setRowHeight(30);
        }
    }//GEN-LAST:event_ThemBtnActionPerformed

    private void TaoHDBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaoHDBtnActionPerformed
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(this, "Bạn muốn tạo phiếu nhập sách", "Tạo phiếu nhập sách", JOptionPane.YES_NO_OPTION);
        if(opt == JOptionPane.YES_OPTION){
                int MaTK = tk.GetMaTK(TenDNHome, MatKhauHome);
                PhieuNhapSachModel pnsModel;
                pnsModel = new PhieuNhapSachModel(MaTK, MaNPP, 0, null);
                if(pns.ThemPN(pnsModel) != 0){
                    int MaPNS = pns.PhieuNhapSachVuaTao();
                    System.out.println(MaPNS);
                    Object[] tablenhap;
                    ArrayList<Object> tempArr = new ArrayList<>(Arrtemp);
                    for(Object i : tempArr){
                        tablenhap = (Object[]) i;
                        int MaS = s.LayMaSach(tablenhap[0].toString());
                        int SL = Integer.parseInt(tablenhap[5].toString());
                        long GiaTienNhap = Long.parseLong(tablenhap[6].toString());
                        PhieuNhapSachModel chitiet = new PhieuNhapSachModel (MaPNS, MaS, SL, GiaTienNhap);
                        if(pns.ThemCTPNS(chitiet) == 0){
                            JOptionPane.showMessageDialog(this, "Tạo phiếu nhập thất bại", "Error", JOptionPane.ERROR_MESSAGE);
                            GetTCSach();
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(this, "Tạo phiếu nhập thành công");
                    GetTCSach();
                    Reset();
                }  
            }
    }//GEN-LAST:event_TaoHDBtnActionPerformed

    private void QlaiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QlaiBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new Chon_NPP_cho_PNS(TenDNHome, MatKhauHome);
        
    }//GEN-LAST:event_QlaiBtnActionPerformed

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        // TODO add your handling code here:
        GN_txt.setText("");
        TTN_txt.setText("");
        TongTien=0;
        SL_txt1.setText("");
        Reset();
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try {
            int selectedRow = jTable1.getSelectedRow();
            DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
            TenSach = temp.getValueAt(selectedRow, 1).toString();
            TLSach = temp.getValueAt(selectedRow, 2).toString();
            SLSachHienCo = Integer.parseInt(temp.getValueAt(selectedRow, 3).toString()) ;
            GiaTienSach = Long.parseLong(temp.getValueAt(selectedRow, 4).toString());  
            System.out.println(TenSach);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void DelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelBtnActionPerformed
        // TODO add your handling code here:
        long TongTienChuaHoanChinh = TongTien;
        int selectedRow = jTable2.getSelectedRow();
        DefaultTableModel temp = (DefaultTableModel) jTable2.getModel();
        if(selectedRow != -1){
           int opt = JOptionPane.showConfirmDialog(this, "Bạn có chắc là muốn xoá", "Xoá hàng đã chọn", JOptionPane.YES_NO_OPTION);
           if(opt == JOptionPane.YES_OPTION){
               String TenS = temp.getValueAt(selectedRow, 0).toString();
               Object[] check;
               Iterator<Object> iterator = Arrtemp.iterator();
               while (iterator.hasNext()) {
                    check = (Object[]) iterator.next();
                    if(TenS.equals(check[0].toString())){
                        TongTienChuaHoanChinh -= Long.parseLong(check[6].toString());
                        iterator.remove(); // Xóa phần tử hiện tại một cách an toàn
                    }     
                }
                TongTien = TongTienChuaHoanChinh;
                temp.removeRow(selectedRow);
                TTN_txt.setText(Long.toString(TongTien));
           } 
        } else {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hàng để xoá");
        }
    }//GEN-LAST:event_DelBtnActionPerformed

    
    public void Add(ArrayList<SachModel> SModel, DefaultTableModel table){
        for(SachModel i : SModel){
            Object[] obj = {i.getMaSach(), i.getTenSach(), i.getTenTheLoai() ,i.getSlHienCo(), i.getGiaTien()};
            table.addRow(obj);
        }
    }
    
    public void GetTCSach(){
        String title[] = {"Mã sách", "Tên sách", "Thể loại", "Số lượng hiện tại", "Đơn giá sách"};
        table.setColumnIdentifiers(title);
        table.setRowCount(0);
        ArrayList<SachModel> SModel = new ArrayList<SachModel>();
        SModel = s.getTCSach();
        Add(SModel, table);
        jTable1.setModel(table);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(240);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(30);
        jTable1.setRowHeight(30);
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
            java.util.logging.Logger.getLogger(Them_PN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Them_PN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Them_PN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Them_PN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Them_PN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DelBtn;
    private javax.swing.JTextField GN_txt;
    private javax.swing.JButton QlaiBtn;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JTextField SL_txt1;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JTextField Search_txt;
    private javax.swing.JTextField TTN_txt;
    private javax.swing.JButton TaoHDBtn;
    private javax.swing.JButton ThemBtn;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
