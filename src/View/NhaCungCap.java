/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.NhaCungCapController;
import Controller.TaiKhoanController;
import Model.NhaCungCapModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GIA KIET
 */
public class NhaCungCap extends javax.swing.JFrame {

    /**
     * Creates new form NhaCungCap
     */
    public NhaCungCap() {
        initComponents();
        GetAllNCC();
    }
    
    public String TenDNHome, MatKhauHome;
    public TaiKhoanController tk = new TaiKhoanController();
    public NhaCungCapController ncc = new NhaCungCapController();
    public int ChucVu = tk.TraVeChucVu(TenDNHome, MatKhauHome);
    DefaultTableModel table = new DefaultTableModel();
    public int ID;
    
    public NhaCungCap(String TenDN, String MatKhau){
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.TenDNHome = TenDN;
        this.MatKhauHome = MatKhau;
        GetAllNCC();
    }
    
    public void Reset(){
        NCC_txt.setText("");
        DC_txt.setText("");
        SDT_txt.setText("");
    }
    
    public boolean CheckSDT(String regax){
        return regax.matches("^\\d{10}$");
    }
    
    public boolean CheckNumberOrNot(String regax){
        return regax.matches("-?\\d+(\\.\\d+)?");
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
        jComboBox1 = new javax.swing.JComboBox<>();
        Search_txt = new javax.swing.JTextField();
        SearchBtn1 = new javax.swing.JButton();
        QlaiBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        AddNCCBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        NCC_txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        DC_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        SDT_txt = new javax.swing.JTextField();
        ResetBtn = new javax.swing.JButton();
        UpdateNCCBtn = new javax.swing.JButton();
        DelNCCBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Danh sách nhà cung cấp");

        jPanel1.setBackground(new java.awt.Color(173, 216, 230));

        jComboBox1.setBackground(new java.awt.Color(0, 204, 204));
        jComboBox1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã nhà cung cấp", "Tên nhà cung cấp" }));

        Search_txt.setBackground(new java.awt.Color(173, 216, 230));
        Search_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Search_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));

        SearchBtn1.setBackground(new java.awt.Color(0, 204, 204));
        SearchBtn1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        SearchBtn1.setText("Tìm nhà cung cấp");
        SearchBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtn1ActionPerformed(evt);
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

        jTable1.setBackground(new java.awt.Color(0, 204, 204));
        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã NCC", "Tên NCC", "SĐT", "Địa chỉ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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

        AddNCCBtn.setBackground(new java.awt.Color(0, 204, 204));
        AddNCCBtn.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        AddNCCBtn.setText("Thêm nhà cung cấp");
        AddNCCBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNCCBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Tên nhà cung cấp");

        NCC_txt.setBackground(new java.awt.Color(173, 216, 230));
        NCC_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        NCC_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Địa chỉ");

        DC_txt.setBackground(new java.awt.Color(173, 216, 230));
        DC_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DC_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Số điện thoại");

        SDT_txt.setBackground(new java.awt.Color(173, 216, 230));
        SDT_txt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        SDT_txt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        ResetBtn.setBackground(new java.awt.Color(0, 204, 204));
        ResetBtn.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ResetBtn.setText("Làm mới");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        UpdateNCCBtn.setBackground(new java.awt.Color(0, 204, 204));
        UpdateNCCBtn.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        UpdateNCCBtn.setText("Sửa nhà cung cấp");
        UpdateNCCBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateNCCBtnActionPerformed(evt);
            }
        });

        DelNCCBtn.setBackground(new java.awt.Color(0, 204, 204));
        DelNCCBtn.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        DelNCCBtn.setText("Xoá nhà cung cấp");
        DelNCCBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelNCCBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(QlaiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(AddNCCBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(UpdateNCCBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DelNCCBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SearchBtn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(NCC_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(74, 74, 74)
                                    .addComponent(jLabel4)
                                    .addGap(184, 184, 184))
                                .addComponent(DC_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SDT_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NCC_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DC_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SDT_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddNCCBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(UpdateNCCBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(DelNCCBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(QlaiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 100, 100));

        jLabel1.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Danh sách nhà cung cấp");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void SearchBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtn1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel Table_for_search = (DefaultTableModel) jTable1.getModel();
        Table_for_search.setRowCount(0);
        ArrayList<NhaCungCapModel> nccModel = new ArrayList<NhaCungCapModel>();
        if(CheckNumberOrNot(Search_txt.getText()) == false && jComboBox1.getSelectedItem().toString().equals("Mã nhà cung cấp")){
            JOptionPane.showMessageDialog(this, "Mã nhà cung cấp phải là số", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            nccModel = ncc.TimKiemNCC(jComboBox1.getSelectedItem().toString(), Search_txt.getText());
            Add(nccModel, Table_for_search);
        } 
    }//GEN-LAST:event_SearchBtn1ActionPerformed

    private void AddNCCBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNCCBtnActionPerformed
        // TODO add your handling code here:
        if(NCC_txt.getText().isEmpty() || SDT_txt.getText().isEmpty() || DC_txt.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(CheckSDT(SDT_txt.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Sai định dạng SDT", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int opt = JOptionPane.showConfirmDialog(this, "Bạn có chắc là muốn thêm thông tin nhà cung cấp", "Thêm nhà cung cấp", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == JOptionPane.YES_OPTION) {
            NhaCungCapModel nccm = new NhaCungCapModel(NCC_txt.getText(), DC_txt.getText(), SDT_txt.getText());
            if(ncc.ThemNCC(nccm) != 0){
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                Reset();
                GetAllNCC();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }//GEN-LAST:event_AddNCCBtnActionPerformed

    private void QlaiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QlaiBtnActionPerformed
        // TODO add your handling code here:
        new Home(TenDNHome, MatKhauHome);
        this.dispose();
    }//GEN-LAST:event_QlaiBtnActionPerformed

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        // TODO add your handling code here:
        Reset();
        GetAllNCC();
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void UpdateNCCBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateNCCBtnActionPerformed
        // TODO add your handling code here:
        if(NCC_txt.getText().isEmpty() || SDT_txt.getText().isEmpty() || DC_txt.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(CheckSDT(SDT_txt.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Sai định dạng SDT", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int opt = JOptionPane.showConfirmDialog(this, "Bạn có chắc là muốn sửa thông tin nhà cung cấp", "Sửa nhà cung cấp", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == JOptionPane.YES_OPTION) {
                NhaCungCapModel nccm = new NhaCungCapModel(ID, NCC_txt.getText(), DC_txt.getText(), SDT_txt.getText());
                if(ncc.SuaNCC(nccm) != 0){
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    Reset();
                    GetAllNCC();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
         }
    }//GEN-LAST:event_UpdateNCCBtnActionPerformed

    private void DelNCCBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelNCCBtnActionPerformed
        // TODO add your handling code here:
        if(NCC_txt.getText().isEmpty() || SDT_txt.getText().isEmpty() || DC_txt.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(CheckSDT(SDT_txt.getText()) == false) {
            JOptionPane.showMessageDialog(this, "Sai định dạng SDT", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int opt = JOptionPane.showConfirmDialog(this, "Bạn có chắc là muốn xoá thông tin nhà cung cấp", "Xoá nhà cung cấp", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == JOptionPane.YES_OPTION) {
            NhaCungCapModel nccm = new NhaCungCapModel(ID, NCC_txt.getText(), DC_txt.getText(), SDT_txt.getText());
            if(ncc.XoaNCC(nccm) != 0){
                JOptionPane.showMessageDialog(this, "Xoá thành công");
                Reset();
                GetAllNCC();
            } else {
                JOptionPane.showMessageDialog(this, "Xoá thất bại", "Error", JOptionPane.ERROR_MESSAGE);
                return;
             }
        }
    }//GEN-LAST:event_DelNCCBtnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int selectedRow = jTable1.getSelectedRow();
            DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
            ID = Integer.parseInt(temp.getValueAt(selectedRow, 0).toString());
            NCC_txt.setText(temp.getValueAt(selectedRow, 1).toString());          
            SDT_txt.setText(temp.getValueAt(selectedRow, 2).toString());
            DC_txt.setText(temp.getValueAt(selectedRow, 3).toString());  
        } catch (Exception ex) {
            //Logger.getLogger(TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    
    public void Add(ArrayList<NhaCungCapModel> nccModel, DefaultTableModel table){
        for(NhaCungCapModel i : nccModel){
            Object[] obj = {i.getMaNCC(), i.getTenNCC(), i.getSDT(), i.getDiaChi()};
            table.addRow(obj);
        }
    }
    
    public void GetAllNCC(){
        String title[] = {"Mã NCC", "Tên NCC", "SDT", "Địa chỉ"};
        table.setColumnIdentifiers(title);
        table.setRowCount(0);
        ArrayList<NhaCungCapModel> nccModel = new ArrayList<NhaCungCapModel>();
        nccModel = ncc.getTCNCC();
        Add(nccModel, table);
        jTable1.setModel(table);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(250);
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
            java.util.logging.Logger.getLogger(NhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhaCungCap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddNCCBtn;
    private javax.swing.JTextField DC_txt;
    private javax.swing.JButton DelNCCBtn;
    private javax.swing.JTextField NCC_txt;
    private javax.swing.JButton QlaiBtn;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JTextField SDT_txt;
    private javax.swing.JButton SearchBtn1;
    private javax.swing.JTextField Search_txt;
    private javax.swing.JButton UpdateNCCBtn;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
