/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package LOVINGHOUSE20;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;



/**
 *
 * @author JOCKER
 */
public class OperationUser extends javax.swing.JFrame {

    /**
     * Creates new form UserOperation
     */
    public OperationUser() {
        initComponents();
        SelectUID();
    }

    Connection conn;
    Statement st=null;
    ResultSet rs=null;
   
    public void SelectUID(){
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("数据库驱动加载成功!");
                conn= DriverManager.getConnection(
                        //！时区问题，需要在url后面加上“?serverTimezone=UTC ”
                        "jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT",
                        "root","root");
                System.out.println("数据库服务器连接成功!");
                st=conn.createStatement();
                rs=st.executeQuery("select * from hwl_userinf");
                
                hwl_userinf.setModel(DbUtils.resultSetToTableModel(rs));  
            }catch(SQLException  e){

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(OperationUser.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        user_phone = new javax.swing.JTextField();
        user_id = new javax.swing.JTextField();
        user_password = new javax.swing.JTextField();
        user_name = new javax.swing.JTextField();
        user_sex = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        EditBuf = new javax.swing.JButton();
        DelBuf = new javax.swing.JButton();
        ClearBuf = new javax.swing.JButton();
        AddBuf = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        hwl_userinf = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        byebye = new javax.swing.JLabel();
        touser = new javax.swing.JLabel();
        touser1 = new javax.swing.JLabel();
        loginout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 153));
        jLabel12.setText("MANGAE USER");

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 153));
        jLabel8.setText("SELCTUID");

        user_phone.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        user_phone.setForeground(new java.awt.Color(255, 153, 153));

        user_id.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        user_id.setForeground(new java.awt.Color(255, 153, 153));

        user_password.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        user_password.setForeground(new java.awt.Color(255, 153, 153));

        user_name.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        user_name.setForeground(new java.awt.Color(255, 153, 153));

        user_sex.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        user_sex.setForeground(new java.awt.Color(255, 153, 153));
        user_sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "女性", "男性", "无性别" }));

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 153));
        jLabel9.setText("PHONE");

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 153));

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 153));
        jLabel13.setText("USEX");

        jLabel14.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 153, 153));
        jLabel14.setText("PASWD");

        EditBuf.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        EditBuf.setForeground(new java.awt.Color(255, 153, 153));
        EditBuf.setText("Edit");
        EditBuf.setBorder(null);
        EditBuf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditBufMouseClicked(evt);
            }
        });

        DelBuf.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        DelBuf.setForeground(new java.awt.Color(255, 153, 153));
        DelBuf.setText("Delect");
        DelBuf.setBorder(null);
        DelBuf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DelBufMouseClicked(evt);
            }
        });

        ClearBuf.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        ClearBuf.setForeground(new java.awt.Color(255, 153, 153));
        ClearBuf.setText("Clear");
        ClearBuf.setBorder(null);
        ClearBuf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearBufMouseClicked(evt);
            }
        });

        AddBuf.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        AddBuf.setForeground(new java.awt.Color(255, 153, 153));
        AddBuf.setText("Add");
        AddBuf.setBorder(null);
        AddBuf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBufMouseClicked(evt);
            }
        });

        hwl_userinf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "UID", "NAME", "PHONE", "PASWD", "DEVOTE", "sex"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        hwl_userinf.setRowHeight(25);
        hwl_userinf.setSelectionBackground(new java.awt.Color(255, 204, 204));
        hwl_userinf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hwl_userinfMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(hwl_userinf);
        if (hwl_userinf.getColumnModel().getColumnCount() > 0) {
            hwl_userinf.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 153, 153));
        jLabel15.setText("UNAME");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AddBuf, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(EditBuf, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(DelBuf, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(ClearBuf, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(user_sex, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(user_password, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                .addComponent(user_phone)
                                .addComponent(user_name)
                                .addComponent(user_id)))
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(406, 406, 406))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel12)
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(user_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(user_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(user_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(user_sex, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditBuf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelBuf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearBuf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddBuf, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        byebye.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        byebye.setForeground(new java.awt.Color(255, 255, 255));
        byebye.setText("X");
        byebye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                byebyeMouseClicked(evt);
            }
        });

        touser.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        touser.setForeground(new java.awt.Color(255, 255, 255));
        touser.setText("To Needed");
        touser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                touserMouseClicked(evt);
            }
        });

        touser1.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        touser1.setForeground(new java.awt.Color(255, 255, 255));
        touser1.setText("resouses");
        touser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                touser1MouseClicked(evt);
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
                .addComponent(byebye, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(touser)
                    .addComponent(touser1)
                    .addComponent(loginout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(byebye)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(touser, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(touser1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(loginout)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddBufMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBufMouseClicked
        if(user_id.getText().isEmpty()||user_name.getText().isEmpty()||user_phone.getText().isEmpty()||user_password.getText().isEmpty()){
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
                PreparedStatement add= conn.prepareStatement("insert into hwl_userinf values(?,?,?,?,?,?)");
                add.setInt(1,Integer.parseInt(user_id.getText()));
                add.setString(2,user_name.getText());
                add.setString(3,user_phone.getText());
                add.setString(4,user_sex.getSelectedItem().toString());
                add.setString(5,user_password.getText());
                add.setString(6,"暂无");
                
                

                int row = add.executeUpdate();

                JOptionPane.showMessageDialog(this, "user add succed");
                conn.close();
                SelectUID();
            }catch(SQLException  e){

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(OperationUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_AddBufMouseClicked

    private void hwl_userinfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hwl_userinfMouseClicked
        DefaultTableModel model=(DefaultTableModel)hwl_userinf.getModel();
        int Myindex=hwl_userinf.getSelectedRow();
        user_id.setText(model.getValueAt(Myindex,0).toString());
        user_name.setText(model.getValueAt(Myindex,1).toString());
        user_phone.setText(model.getValueAt(Myindex,2).toString());
        user_password.setText(model.getValueAt(Myindex,4).toString());
    }//GEN-LAST:event_hwl_userinfMouseClicked

    private void ClearBufMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearBufMouseClicked
        user_id.setText("");
        user_name.setText("");
        user_phone.setText("");
        user_password.setText("");
    }//GEN-LAST:event_ClearBufMouseClicked

    private void DelBufMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelBufMouseClicked
        if(user_id.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"请选择需要删除的用户 编号");
        }else{
            try{
                int uid=Integer.parseInt(user_id.getText());
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT",
                        "root","root");
                
                //设置事物手动提交
                conn.setAutoCommit(false);
                PreparedStatement ps = conn.prepareStatement("delete from hwl_userinf where user_id = ?");
                ps.setInt(1,uid);
                
                //一些特别处理过的语句返回多个结果，execute 方法处理这些复杂的语句；
                //executeQuery 和 executeUpdate 处理形式更简单的语句
                ps.execute();
                conn.commit();
                SelectUID();
                JOptionPane.showMessageDialog(this,"delete user succeed");

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_DelBufMouseClicked

    private void EditBufMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditBufMouseClicked
        if(user_id.getText().isEmpty()||user_name.getText().isEmpty()||user_phone.getText().isEmpty()||user_password.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "很抱歉 您的信息缺失 ");
        }else{
            try{
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT",
                        "root","root");
                conn.setAutoCommit(false);
                PreparedStatement ps = conn.prepareStatement("update hwl_userinf set user_name=?,user_phone=?,user_password=? where user_id=?");
                ps.setString(1,user_name.getText());
                ps.setString(2,user_phone.getText());
                ps.setString(3,user_password.getText());
                ps.setInt(4,Integer.parseInt(user_id.getText()));
                
                ps.execute();
                conn.commit();
                SelectUID();
                JOptionPane.showMessageDialog(this,"update user succeed");
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_EditBufMouseClicked

    private void byebyeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_byebyeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_byebyeMouseClicked

    private void touserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_touserMouseClicked
        new OperationNeeded().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_touserMouseClicked

    private void touser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_touser1MouseClicked
        new KIND().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_touser1MouseClicked

    private void loginoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginoutMouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loginoutMouseClicked

    
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
            java.util.logging.Logger.getLogger(OperationUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OperationUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OperationUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OperationUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OperationUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBuf;
    private javax.swing.JButton ClearBuf;
    private javax.swing.JButton DelBuf;
    private javax.swing.JButton EditBuf;
    private javax.swing.JLabel byebye;
    private javax.swing.JTable hwl_userinf;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel loginout;
    private javax.swing.JLabel touser;
    private javax.swing.JLabel touser1;
    private javax.swing.JTextField user_id;
    private javax.swing.JTextField user_name;
    private javax.swing.JTextField user_password;
    private javax.swing.JTextField user_phone;
    private javax.swing.JComboBox<String> user_sex;
    // End of variables declaration//GEN-END:variables
}
