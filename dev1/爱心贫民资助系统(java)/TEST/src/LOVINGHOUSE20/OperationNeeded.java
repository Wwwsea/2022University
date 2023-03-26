/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package LOVINGHOUSE20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author JOCKER
 */
public class OperationNeeded extends javax.swing.JFrame {
    
    
    public OperationNeeded() {
        initComponents();
        SelectMID();
    }
    Connection conn;
    Statement st=null;
    ResultSet rs=null;
     public void SelectMID(){
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("数据库驱动加载成功!");
                conn= DriverManager.getConnection(
                        //！时区问题，需要在url后面加上“?serverTimezone=UTC ”
                        "jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT",
                        "root","root");
                System.out.println("数据库服务器连接成功!");
                st=conn.createStatement();
                rs=st.executeQuery("select * from hwl_needed");
                
                hwl_needed.setModel(DbUtils.resultSetToTableModel(rs));  
            }catch(SQLException  e){

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(OperationUser.class.getName()).log(Level.SEVERE, null, ex);
            }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mage = new javax.swing.JTextField();
        mid = new javax.swing.JTextField();
        mstatus = new javax.swing.JTextField();
        mname = new javax.swing.JTextField();
        mlocal = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        EditNeeded = new javax.swing.JButton();
        DeleteNeeded = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        AddNeededs = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        hwl_needed = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        touser = new javax.swing.JLabel();
        toresouses = new javax.swing.JLabel();
        tomadmin = new javax.swing.JLabel();
        loginout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 153));
        jLabel11.setText("MANAGE NEEDED");

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 153));
        jLabel3.setText("NNAME");

        mage.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        mage.setForeground(new java.awt.Color(255, 153, 153));

        mid.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        mid.setForeground(new java.awt.Color(255, 153, 153));
        mid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midActionPerformed(evt);
            }
        });

        mstatus.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        mstatus.setForeground(new java.awt.Color(255, 153, 153));
        mstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mstatusActionPerformed(evt);
            }
        });

        mname.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        mname.setForeground(new java.awt.Color(255, 153, 153));

        mlocal.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        mlocal.setForeground(new java.awt.Color(255, 153, 153));
        mlocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "冥王星", "水星", "天狼星", "木星", "扎夫特" }));

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 153));
        jLabel4.setText("NAGE");

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 153));
        jLabel5.setText("NID");

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 153));
        jLabel6.setText("NLOCAL");

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 153));
        jLabel7.setText("NASTATUS");

        EditNeeded.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        EditNeeded.setForeground(new java.awt.Color(255, 153, 153));
        EditNeeded.setText("Edit");
        EditNeeded.setBorder(null);
        EditNeeded.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditNeededMouseClicked(evt);
            }
        });

        DeleteNeeded.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        DeleteNeeded.setForeground(new java.awt.Color(255, 153, 153));
        DeleteNeeded.setText("Delect");
        DeleteNeeded.setBorder(null);
        DeleteNeeded.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteNeededMouseClicked(evt);
            }
        });

        Clear.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        Clear.setForeground(new java.awt.Color(255, 153, 153));
        Clear.setText("Clear");
        Clear.setBorder(null);
        Clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearMouseClicked(evt);
            }
        });

        AddNeededs.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        AddNeededs.setForeground(new java.awt.Color(255, 153, 153));
        AddNeededs.setText("Add");
        AddNeededs.setBorder(null);
        AddNeededs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddNeededsMouseClicked(evt);
            }
        });

        hwl_needed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NID", "NNAME", "NAGE", "NSTATES", "NLOCAL"
            }
        ));
        hwl_needed.setRowHeight(25);
        hwl_needed.setSelectionBackground(new java.awt.Color(255, 204, 204));
        hwl_needed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hwl_neededMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(hwl_needed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(1, 1, 1))
                    .addComponent(AddNeededs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(EditNeeded, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(DeleteNeeded, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(mage)
                            .addComponent(mname)
                            .addComponent(mid)
                            .addComponent(mlocal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(375, 375, 375))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(mname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(mage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mlocal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditNeeded, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteNeeded, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddNeededs, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        touser.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        touser.setForeground(new java.awt.Color(255, 255, 255));
        touser.setText("To user");
        touser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                touserMouseClicked(evt);
            }
        });

        toresouses.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        toresouses.setForeground(new java.awt.Color(255, 255, 255));
        toresouses.setText("resouses");
        toresouses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toresousesMouseClicked(evt);
            }
        });

        tomadmin.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        tomadmin.setForeground(new java.awt.Color(255, 255, 255));
        tomadmin.setText("To admin");
        tomadmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tomadminMouseClicked(evt);
            }
        });

        loginout.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        loginout.setForeground(new java.awt.Color(255, 255, 255));
        loginout.setText("loginout");
        loginout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toresouses)
                    .addComponent(touser)
                    .addComponent(tomadmin)
                    .addComponent(loginout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(touser)
                        .addGap(56, 56, 56)
                        .addComponent(toresouses)
                        .addGap(71, 71, 71)
                        .addComponent(tomadmin)
                        .addGap(62, 62, 62)
                        .addComponent(loginout)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddNeededsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddNeededsMouseClicked
         if(mid.getText().isEmpty()||mname.getText().isEmpty()||mage.getText().isEmpty()||mstatus.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "很抱歉 您的信息缺失");
        }else{
            try{
             Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("数据库驱动加载成功!");
                conn= DriverManager.getConnection(
                        //！时区问题，需要在url后面加上“?serverTimezone=UTC ”
                        "jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT",
                        "root","root");
                System.out.println("数据库服务器连接成功!");
                PreparedStatement add= conn.prepareStatement("insert into hwl_needed values(?,?,?,?,?)");
                add.setInt(1,Integer.parseInt(mid.getText()));
                add.setString(2,mname.getText());
                add.setString(3,mage.getText());
                add.setString(4,mlocal.getSelectedItem().toString());
                add.setString(5,mstatus.getText());
                
                

                int row = add.executeUpdate();

                JOptionPane.showMessageDialog(this, "user needed succed");
                conn.close();
                SelectMID();
            }catch(SQLException  e){

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(OperationUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_AddNeededsMouseClicked

    private void EditNeededMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditNeededMouseClicked
            
         if(mid.getText().isEmpty()||mname.getText().isEmpty()||mage.getText().isEmpty()||mstatus.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "很抱歉 您的信息缺失");
        }else{
            try{
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT",
                        "root","root");
                conn.setAutoCommit(false);
                PreparedStatement ps = conn.prepareStatement("update hwl_needed set mname=?,mage=?,mstatus=? where mid=?");
                ps.setString(1,mname.getText());
                ps.setString(2,mage.getText());
                ps.setString(3,mstatus.getText());
                ps.setInt(4,Integer.parseInt(mid.getText()));
                
                ps.execute();
                conn.commit();
                SelectMID();
                JOptionPane.showMessageDialog(this,"update Needed succeed");
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_EditNeededMouseClicked

    private void hwl_neededMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hwl_neededMouseClicked
        
        DefaultTableModel model=(DefaultTableModel)hwl_needed.getModel();
        int Myindex=hwl_needed.getSelectedRow();
        mid.setText(model.getValueAt(Myindex,0).toString());
        mname.setText(model.getValueAt(Myindex,1).toString());
        mage.setText(model.getValueAt(Myindex,2).toString());
        mstatus.setText(model.getValueAt(Myindex,4).toString());
        
        
    }//GEN-LAST:event_hwl_neededMouseClicked

    private void DeleteNeededMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteNeededMouseClicked
       
        if(mid.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"请选择需要删除的用户 编号");
        }else{
            try{
                int Mid=Integer.parseInt(mid.getText());
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT",
                        "root","root");
                
                //设置事物手动提交
                conn.setAutoCommit(false);
                PreparedStatement ps = conn.prepareStatement("delete from hwl_needed where mid = ?");
                ps.setInt(1,Mid);
                
                //一些特别处理过的语句返回多个结果，execute 方法处理这些复杂的语句；
                //executeQuery 和 executeUpdate 处理形式更简单的语句
                ps.execute();
                conn.commit();
                SelectMID();
                JOptionPane.showMessageDialog(this,"delete user succeed");

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_DeleteNeededMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void mstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mstatusActionPerformed

    private void touserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_touserMouseClicked
        new OperationUser().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_touserMouseClicked

    private void toresousesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toresousesMouseClicked
        new KIND().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_toresousesMouseClicked

    private void tomadminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tomadminMouseClicked
        new UpdateAdmin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tomadminMouseClicked

    private void loginoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginoutMouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loginoutMouseClicked

    private void ClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseClicked
        mid.setText("");
        mname.setText("");
        mage.setText("");
        mstatus.setText("");
        
        
        
    }//GEN-LAST:event_ClearMouseClicked

    private void midActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_midActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
         System.exit(0);
    }//GEN-LAST:event_jPanel1MouseClicked


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OperationNeeded.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OperationNeeded.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OperationNeeded.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OperationNeeded.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OperationNeeded().setVisible(true);
            }
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddNeededs;
    private javax.swing.JButton Clear;
    private javax.swing.JButton DeleteNeeded;
    private javax.swing.JButton EditNeeded;
    private javax.swing.JTable hwl_needed;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel loginout;
    private javax.swing.JTextField mage;
    private javax.swing.JTextField mid;
    private javax.swing.JComboBox<String> mlocal;
    private javax.swing.JTextField mname;
    private javax.swing.JTextField mstatus;
    private javax.swing.JLabel tomadmin;
    private javax.swing.JLabel toresouses;
    private javax.swing.JLabel touser;
    // End of variables declaration//GEN-END:variables
}
