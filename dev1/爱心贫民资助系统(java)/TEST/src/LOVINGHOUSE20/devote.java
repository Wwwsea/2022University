
package LOVINGHOUSE20;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import static jdk.jfr.internal.handlers.EventHandler.timestamp;
import net.proteanit.sql.DbUtils;


public class devote extends javax.swing.JFrame {
    Connection conn;
    Statement st=null;
    ResultSet rs=null;
    int result=0;
    int user_id=Login.getAdminOrUserId();
    int user_devote=Integer.valueOf(confirminf.getuserdevote());

    public devote() {
        initComponents();
        SelectMID();
        GetKind();
    }
    private void GetKind(){
    
        try{
            conn= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT",
                    "root","root");
            System.out.println("数据库服务器连接成功!");
            st=conn.createStatement();
            rs=st.executeQuery("select * from hwl_resouses");
            
            while(rs.next()){
                String kinds=rs.getString(2);
                dresouses.addItem(kinds);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
        
    }
    

     public void SelectMID(){
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("数据库驱动加载成功!");
                conn= DriverManager.getConnection(
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
        mid = new javax.swing.JTextField();
        mname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PayForNeeded = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        donate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        hwl_needed = new javax.swing.JTable();
        dresouses = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        DonateLog = new javax.swing.JTextArea();
        fin = new javax.swing.JLabel();
        Game = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("DEVOTE NEEDED");

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("NNAME");

        mid.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        mid.setForeground(new java.awt.Color(255, 153, 153));

        mname.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        mname.setForeground(new java.awt.Color(255, 153, 153));

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("NID");

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("DONATE");

        PayForNeeded.setBackground(new java.awt.Color(102, 204, 255));
        PayForNeeded.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        PayForNeeded.setForeground(new java.awt.Color(255, 255, 255));
        PayForNeeded.setText("PAY");
        PayForNeeded.setBorder(null);
        PayForNeeded.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PayForNeededMouseClicked(evt);
            }
        });
        PayForNeeded.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayForNeededActionPerformed(evt);
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
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        donate.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        donate.setForeground(new java.awt.Color(255, 153, 153));
        donate.setText("Donate");
        donate.setBorder(null);
        donate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                donateMouseClicked(evt);
            }
        });
        donate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donateActionPerformed(evt);
            }
        });

        hwl_needed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        dresouses.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        dresouses.setForeground(new java.awt.Color(255, 153, 153));

        DonateLog.setColumns(20);
        DonateLog.setFont(new java.awt.Font("Sitka Small", 0, 24)); // NOI18N
        DonateLog.setForeground(new java.awt.Color(153, 204, 255));
        DonateLog.setRows(5);
        jScrollPane2.setViewportView(DonateLog);

        fin.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        fin.setForeground(new java.awt.Color(255, 51, 51));
        fin.setText("you will obtain .."+result);

        Game.setIcon(new javax.swing.ImageIcon("D:\\java\\TEST\\images\\gundam.png")); // NOI18N
        Game.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(mname)
                                    .addComponent(mid)
                                    .addComponent(dresouses, 0, 256, Short.MAX_VALUE)))
                            .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(donate, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PayForNeeded, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 195, Short.MAX_VALUE)
                .addComponent(Game)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(366, 366, 366))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Game)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(42, 42, 42)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(dresouses, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(donate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(PayForNeeded, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
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
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
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

    private void PayForNeededMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PayForNeededMouseClicked
   
    }//GEN-LAST:event_PayForNeededMouseClicked

    private void donateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_donateMouseClicked
        
        
    }//GEN-LAST:event_donateMouseClicked

    private void hwl_neededMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hwl_neededMouseClicked

        DefaultTableModel model=(DefaultTableModel)hwl_needed.getModel();
        int Myindex=hwl_needed.getSelectedRow();
//        mid.setText(model.getValueAt(Myindex,0).toString());
        mname.setText(model.getValueAt(Myindex,1).toString());
       

    }//GEN-LAST:event_hwl_neededMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearActionPerformed
int i=0;
    private void donateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donateActionPerformed
        String name=mname.getText();
        String resouse=dresouses.getSelectedItem().toString();
        if(name.isEmpty() || resouse.equals("NULL")){
             JOptionPane.showMessageDialog(this, "please choose something what you want to donate for us");
        }else{
            i++;
            if(i==1){
                DonateLog.setText("===WELECOME TO SERVICE US===\n"+DonateLog.getText()+i+"   "+"you choose ONE:"+resouse+" for "+name+"\n");
                result+=10;
            }else{
                DonateLog.setText(DonateLog.getText()+i+"   "+"you choose ONE:"+resouse+" for "+name+"\n");
                result+=10;
            }
            Connection conn;
            try {
                conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT",
                        "root","root");
                System.out.println("数据库服务器连接成功!");
                
                st=conn.createStatement();
                rs=st.executeQuery("select * from hwl_needed");
                int mid=1;
                while(rs.next()){
                    mid=rs.getInt(1);
                    
                }
//                更改捐款记录       
                 Date crr = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String curr = sdf.format(crr);
                Timestamp time=Timestamp.valueOf(curr);
                 PreparedStatement add= conn.prepareStatement("insert into hwl_devoteinf(dresouses,mid,user_id,dtime) values(?,?,?,?)");
                 add.setString(1,resouse);
                 add.setInt(2,mid);
                 add.setInt(3,user_id);
                 add.setTimestamp(4,time);
                 add.executeUpdate();
                fin.setText("you w ill obtion "+result+"\n luckies");
                
                //更新用户表
                
            try{
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT",
                        "root","root");
                conn.setAutoCommit(false);
                PreparedStatement ps = conn.prepareStatement("update hwl_userinf set user_devote=? where user_id=?");
                System.out.println(result);
                ps.setString(1,String.valueOf(result));
                ps.setInt(2,user_id);
                
                ps.execute();
                conn.commit();
                JOptionPane.showMessageDialog(this,"update user succeed");
                
                }catch(Exception e){
                    e.printStackTrace();
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(devote.class.getName()).log(Level.SEVERE, null, ex);
            }
               
               
        }
        
    }//GEN-LAST:event_donateActionPerformed

    private void PayForNeededActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayForNeededActionPerformed
        
        try{
            DonateLog.print();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_PayForNeededActionPerformed

    private void ClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseClicked
        mid.setText("");
        mname.setText("");
    }//GEN-LAST:event_ClearMouseClicked

    private void GameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GameMouseClicked
         Vector ques = new Vector();
        Vector answ = new Vector();
        ques.add("我可以为妳的眼睛带来泪水，让死者复活，我会在瞬间产生，持续一生。 ⎛⎝≥⏝⏝≤⎛⎝. 我是什么（两个字）");
        answ.add("记忆");
        ques.add("一个钻石盘子，一个发光的壁炉，一个你永远都不会离开的地方。 ⎛⎝≥⏝⏝≤⎛⎝.  我在哪里（一个字）");
        answ.add("家");
        ques.add("什么东西能撞沉巨轮，却见不得光。 ⎛⎝≥⏝⏝≤⎛⎝.  (一个字)");
        answ.add("冰");
        ques.add("它能为我带来平静，掌握时间的流淌。 ⎛⎝≥⏝⏝≤⎛⎝. （两个字）");
        answ.add("艺术");
        ques.add("潮水在背后涌动，更远的是岛，是喧闹的渡头，集市，寺庙。  ⎛⎝≥⏝⏝≤⎛⎝. 我是什么（两个字）");
        answ.add("大海");
        ques.add("我是遥不可及的，却又很容易得到，有着温暖的质地和明亮的颜色，我就在身边。 ⎛⎝≥⏝⏝≤⎛⎝. 我是什么（两个字）");
        answ.add("奇迹");
        ques.add("我不能被买走，但我一眼能被偷走。我对一个人来说毫无价值，但对两个人来说却是无价的。 ⎛⎝≥⏝⏝≤⎛⎝. 我是什么（一个字）");
        answ.add("爱");
        ques.add("春天我润物细无声，夏天我淋漓洗去诸尘，秋天我令人思怀旧乡。大漠戈壁需要我  ⎛⎝≥⏝⏝≤⎛⎝. 我是什么（一个字）");
        answ.add("雨");
        ques.add("我写的诗每有一首都是颤抖的星星，冰雪覆盖心头，僵硬的像一片土地。我在寒冷中生长，寻找点点希望。 ⎛⎝≥⏝⏝≤⎛⎝. 我是什么（两个字）");
        answ.add("困难");
        int winNum=0;
        for (int i = 0; i < ques.size(); i++) {
            String q=JOptionPane.showInputDialog(ques.elementAt(i));
            if(q==null)
                System.exit(0);

            if (q.equals(String.valueOf(answ.elementAt(i)))||q.equals("~")) {
                System.out.println("回答正确~@-@）");
                winNum++;
            }else
            {
                i=ques.size();
            }
            System.out.println("真棒，总共答对"+winNum+" 道题~");}
        
    }//GEN-LAST:event_GameMouseClicked
   
    
    
    
    
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(devote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(devote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(devote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(devote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new devote().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JTextArea DonateLog;
    private javax.swing.JLabel Game;
    private javax.swing.JButton PayForNeeded;
    private javax.swing.JButton donate;
    private javax.swing.JComboBox<String> dresouses;
    private javax.swing.JLabel fin;
    private javax.swing.JTable hwl_needed;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mid;
    private javax.swing.JTextField mname;
    // End of variables declaration//GEN-END:variables
}
