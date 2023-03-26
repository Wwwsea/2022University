/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOVINGHOUSE20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Usercreate extends javax.swing.JFrame {

        Statement st=null;
        ResultSet rs=null;  
        Connection conn;
        String vc=VerificationCode();
        
    public  String VerificationCode() {
        Random ra = new Random();
        //定义一个字符串存储数据
        String code = "";
        for (int i = 0; i < 4; i++) {
            int type = ra.nextInt(3);
            switch (type) {
                case 0://英文大写 (A-Z)  65-90
                    char ch1 = (char) (ra.nextInt(26) + 65);
                    code += ch1;
                    break;
                case 1://英文小写(a-z)  97-122
                    char ch2 = (char) (ra.nextInt(26) + 97);
                    code += ch2;
                    break;
                case 2://数字 (0-9)
                    code += ra.nextInt(10);

            }
        }
        return code;

    }
        
    public Usercreate() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        user_phone = new javax.swing.JTextField();
        user_password = new javax.swing.JTextField();
        user_name = new javax.swing.JTextField();
        user_sex = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ClearBuf = new javax.swing.JButton();
        AddBuf = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        flashnums = new javax.swing.JLabel();
        varnum = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        byebye = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 153));
        jLabel12.setText("CREATE USER");

        user_phone.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        user_phone.setForeground(new java.awt.Color(255, 153, 153));

        user_password.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        user_password.setForeground(new java.awt.Color(255, 153, 153));

        user_name.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        user_name.setForeground(new java.awt.Color(255, 153, 153));
        user_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_nameActionPerformed(evt);
            }
        });

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

        ClearBuf.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        ClearBuf.setForeground(new java.awt.Color(255, 153, 153));
        ClearBuf.setText("Clear");
        ClearBuf.setBorder(null);
        ClearBuf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearBufMouseClicked(evt);
            }
        });
        ClearBuf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBufActionPerformed(evt);
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

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 153, 153));
        jLabel15.setText("UNAME");

        flashnums.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        flashnums.setForeground(new java.awt.Color(255, 153, 153));
        flashnums.setText("input:"+vc);

        varnum.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        varnum.setForeground(new java.awt.Color(255, 153, 153));
        varnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varnumActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon("D:\\java\\TEST\\images\\flower.png")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(flashnums))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(ClearBuf, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(205, 205, 205)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(user_sex, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(user_password, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(varnum, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(user_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AddBuf, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addGap(84, 84, 84))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user_sex, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(flashnums))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBuf, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearBuf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );

        byebye.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        byebye.setForeground(new java.awt.Color(255, 255, 255));
        byebye.setText("X");
        byebye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                byebyeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(byebye, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(byebye)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ClearBufMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearBufMouseClicked

        user_name.setText("");
        user_phone.setText("");
        user_password.setText("");
        varnum.setText("");
    }//GEN-LAST:event_ClearBufMouseClicked

    private void AddBufMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBufMouseClicked
        
       
        if(user_name.getText().isEmpty()||user_phone.getText().isEmpty()||user_password.getText().isEmpty()){
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
                PreparedStatement add= conn.prepareStatement("insert into hwl_userinf(user_name,user_phone,user_sex,user_password) values(?,?,?,?)");
                add.setString(1,user_name.getText());
                add.setString(2,user_phone.getText());
                add.setString(3,user_sex.getSelectedItem().toString());
                add.setString(4,user_password.getText());
                if(varnum.getText().equals(vc)==false){
                    JOptionPane.showMessageDialog(null, "验证码错误！");
            }else{
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "you create succed!");
                conn.close();
                new Login().setVisible(true);
                this.dispose();
                }
            }catch(SQLException  e){

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(OperationUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_AddBufMouseClicked

    private void byebyeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_byebyeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_byebyeMouseClicked

    private void user_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_nameActionPerformed

    private void varnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varnumActionPerformed

    private void ClearBufActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBufActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearBufActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Usercreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usercreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usercreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usercreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usercreate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBuf;
    private javax.swing.JButton ClearBuf;
    private javax.swing.JLabel byebye;
    private javax.swing.JLabel flashnums;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField user_name;
    private javax.swing.JTextField user_password;
    private javax.swing.JTextField user_phone;
    private javax.swing.JComboBox<String> user_sex;
    private javax.swing.JTextField varnum;
    // End of variables declaration//GEN-END:variables
}
