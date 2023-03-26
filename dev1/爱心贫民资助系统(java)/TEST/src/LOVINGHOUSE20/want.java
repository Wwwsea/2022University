/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOVINGHOUSE20;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

/**
 *
 * @author JOCKER
 */

public class want{
    JFrame frame;
    JButton b1,b2,b3,b4;
    JButton drop;

want(){
    frame=new JFrame("欢迎参加爱心捐款活动ovo");


    JTextArea getMessage = new JTextArea();
        getMessage.setBounds(500, 500, 250, 160);
        String text= "这是一个彩蛋~\r\n" +
                "深邃的星空\n" +
                "裹挟着我们焦躁的年华\n" +
                "不时溅起浪花\n" +
                "却又平静地掩藏着深处的暗涌\n" +
                "\n" +
                "年迈的天空 一身疲倦\n" +
                "困顿地俯视着毫无生气的土地\n" +
                "我们躺在冬天的荒林中\n" +
                "双手曲折地伸出\n" +
                "枯槁着 握紧夜空中停搏的心脏\n" +
                "感谢妳发现了我们";


        getMessage.setText(text);
        getMessage.setEditable(false);//不可编辑
        getMessage.setBorder(new TitledBorder("恭喜你发现了我们"));//设置标题
        getMessage.setLineWrap(true);//设置自动换行
        getMessage.setWrapStyleWord(true);//设置以单词为整体换行，(即不会将单词切割成两半)
        
        getMessage.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(getMessage);//添加滚动条 
        scrollPane.setOpaque(false);
        scrollPane.setBounds(500, 50, 250, 160);
        frame.add(scrollPane);
        frame.setVisible(true);


    //把图片添加到标签里 放在最底下
    ImageIcon bg=new ImageIcon("D:\\java\\TEST\\images\\want.jpg");
    JLabel label=new JLabel(bg);
        label.setSize(bg.getIconWidth(),bg.getIconHeight());
        frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
    //窗口面板设成透明
    JPanel pan=(JPanel)frame.getContentPane();
        pan.setOpaque(false);
        pan.setBounds(690, 816, 300, 650);
        pan.setLayout(new GridLayout(5,1,70,50));
    //把组件和面板添加到窗口

        frame.setSize(690,816);
        frame.setLocationRelativeTo(null);


        pan.add(b1);pan.add(b2);pan.add(b3);pan.add(scrollPane);



        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
}
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
                                   @Override
                                   public void run() {
                                       try {
                                           JFrame.setDefaultLookAndFeelDecorated(true);

                                       } catch (Exception e) {

                                           e.printStackTrace();
                                       }
                                       want start = new want();
                                       start.frame.setVisible(true);
                                   }
                               }

        );
    }

 
}

