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
import net.proteanit.sql.DbUtils;

/**
 *
 * @author JOCKER
 */
public class KIND extends javax.swing.JFrame {

    /**
     * Creates new form KIND
     */
    public KIND() {
        initComponents();
        SelectKID();
    }

     Connection conn;
    Statement st=null;
    ResultSet rs=null;
   
    public void SelectKID(){
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("数据库驱动加载成功!");
                conn= DriverManager.getConnection(
                        //！时区问题，需要在url后面加上“?serverTimezone=UTC ”
                        "jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT",
                        "root","root");
                System.out.println("数据库服务器连接成功!");
                st=conn.createStatement();
                rs=st.executeQuery("select * from hwl_resouses");
                
                hwl_resouses.setModel(DbUtils.resultSetToTableModel(rs));  
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
        description = new javax.swing.JTextField();
        kid = new javax.swing.JTextField();
        kname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        EditResouses = new javax.swing.JButton();
        DelResouses = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        AddResouses = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        hwl_resouses = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        touser = new javax.swing.JLabel();
        touser1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 153));
        jLabel12.setText("MANGAE KINDS");

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 153));
        jLabel8.setText("KINDID");

        description.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        description.setForeground(new java.awt.Color(255, 153, 153));

        kid.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        kid.setForeground(new java.awt.Color(255, 153, 153));

        kname.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        kname.setForeground(new java.awt.Color(255, 153, 153));

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 153));
        jLabel9.setText("DESCRIPTION");

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 153));

        EditResouses.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        EditResouses.setForeground(new java.awt.Color(255, 153, 153));
        EditResouses.setText("Edit");
        EditResouses.setBorder(null);
        EditResouses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditResousesMouseClicked(evt);
            }
        });

        DelResouses.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        DelResouses.setForeground(new java.awt.Color(255, 153, 153));
        DelResouses.setText("Delect");
        DelResouses.setBorder(null);
        DelResouses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DelResousesMouseClicked(evt);
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

        AddResouses.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        AddResouses.setForeground(new java.awt.Color(255, 153, 153));
        AddResouses.setText("Add");
        AddResouses.setBorder(null);
        AddResouses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddResousesMouseClicked(evt);
            }
        });

        hwl_resouses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "KINDID", "KNAME", "DESCRIPTION"
            }
        ));
        hwl_resouses.setRowHeight(25);
        hwl_resouses.setSelectionBackground(new java.awt.Color(255, 204, 204));
        hwl_resouses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hwl_resousesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(hwl_resouses);

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 153, 153));
        jLabel15.setText("KNAME");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel15)
                                    .addComponent(AddResouses, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                                .addComponent(EditResouses, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(237, 237, 237)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(description, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                    .addComponent(kname)
                                    .addComponent(kid))))
                        .addGap(34, 34, 34))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(DelResouses, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddResouses, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EditResouses, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DelResouses, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
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

        touser1.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        touser1.setForeground(new java.awt.Color(255, 255, 255));
        touser1.setText("To Needed");
        touser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                touser1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(touser1)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(touser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(touser)
                        .addGap(84, 84, 84)
                        .addComponent(touser1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void hwl_resousesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hwl_resousesMouseClicked
        
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("数据库驱动加载成功!");
                conn= DriverManager.getConnection(
                        //！时区问题，需要在url后面加上“?serverTimezone=UTC ”
                        "jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT",
                        "root","root");
                System.out.println("数据库服务器连接成功!");
                st=conn.createStatement();
                rs=st.executeQuery("select * from hwl_resouses");
                
                hwl_resouses.setModel(DbUtils.resultSetToTableModel(rs));  
            }catch(SQLException  e){

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(OperationUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_hwl_resousesMouseClicked

    private void AddResousesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddResousesMouseClicked
        if(kid.getText().isEmpty()||kname.getText().isEmpty()||description.getText().isEmpty()){
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
                PreparedStatement add= conn.prepareStatement("insert into hwl_resouses values(?,?,?)");
                add.setInt(1,Integer.parseInt(kid.getText()));
                add.setString(2,kname.getText());
                add.setString(3,description.getText());

                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "add resouses succed");
                conn.close();
                SelectKID();
            }catch(SQLException  e){

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(OperationUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_AddResousesMouseClicked

    private void DelResousesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelResousesMouseClicked
        
        if(kid.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"请选择需要删除的用户 编号");
        }else{
            try{
                int Kid=Integer.parseInt(kid.getText());
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT",
                        "root","root");
                
                //设置事物手动提交
                conn.setAutoCommit(false);
                PreparedStatement ps = conn.prepareStatement("delete from hwl_resouses where kid = ?");
                ps.setInt(1,Kid);
                
                //一些特别处理过的语句返回多个结果，execute 方法处理这些复杂的语句；
                //executeQuery 和 executeUpdate 处理形式更简单的语句
                ps.execute();
                conn.commit();
                SelectKID();
                JOptionPane.showMessageDialog(this,"delete user succeed");

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_DelResousesMouseClicked

    private void ClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseClicked
        kid.setText("");
        kname.setText("");
        description.setText("");
    }//GEN-LAST:event_ClearMouseClicked

    private void EditResousesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditResousesMouseClicked
       
         if(kid.getText().isEmpty()||kname.getText().isEmpty()||description.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "很抱歉 您的信息缺失 ");
        }else{
            try{
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT",
                        "root","root");
                conn.setAutoCommit(false);
                PreparedStatement ps = conn.prepareStatement("update hwl_resouses set kname=?,description=? where kid=?");
                ps.setString(1,kname.getText());
                ps.setString(2,description.getText());
                ps.setInt(3,Integer.parseInt(kid.getText()));
                
                ps.execute();
                conn.commit();
                SelectKID();
                JOptionPane.showMessageDialog(this,"update resouses succeed");
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_EditResousesMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void touserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_touserMouseClicked
        new OperationUser().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_touserMouseClicked

    private void touser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_touser1MouseClicked
        new OperationNeeded().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_touser1MouseClicked

   
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
            java.util.logging.Logger.getLogger(KIND.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KIND.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KIND.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KIND.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KIND().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddResouses;
    private javax.swing.JButton Clear;
    private javax.swing.JButton DelResouses;
    private javax.swing.JButton EditResouses;
    private javax.swing.JTextField description;
    private javax.swing.JTable hwl_resouses;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField kid;
    private javax.swing.JTextField kname;
    private javax.swing.JLabel touser;
    private javax.swing.JLabel touser1;
    // End of variables declaration//GEN-END:variables
}
