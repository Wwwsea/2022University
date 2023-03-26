/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOVINGHOUSE20;



import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

public class GG {
    public int getWinMum() {
        return winMum;
    }

    public void setWinMum(int winMum) {
        this.winMum = winMum;
    }

    private int winMum;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    private int len;

    GG() {
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
            System.out.println("真棒，总共答对"+winNum+" 道题~");



        }
        setWinMum(winNum);
        setLen(ques.size());
    }

    JTextField sendMessage;
    JTextArea getMessage;


    public void frameInit() {
        JFrame frame = new JFrame("这里有我们的回忆~");
        frame.setLayout(null);
        frame.setBounds(500, 200, 280,250);

        getMessage = new JTextArea();
        getMessage.setBounds(5, 0, 250, 160);
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
        JScrollPane scrollPane = new JScrollPane(getMessage);//添加滚动条
        scrollPane.setBounds(5, 0, 250, 160);


        sendMessage = new JTextField();
        sendMessage.setBounds(5, 170, 250, 30);
        sendMessage.setText("这里写下妳相对我们说的话 ~（按下回车即可发送）");

        frame.add(scrollPane);
        frame.add(sendMessage);
        myEvent();
        frame.setVisible(true);
    }

    public void myEvent(){
        sendMessage.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    String msg = sendMessage.getText();
                    getMessage.append("\r\n信息：：" + msg);
                    //每次添加信息时刷新文本区域，将滚动条显示在末尾，即显示最新一次输入
                    getMessage.setCaretPosition(getMessage.getText().length());
                    sendMessage.setText(null);
                }
            }
        });
    }
//        在每次追加信息时，对setCarePosition()方法进行调用，想当于定位显示信息，这样滚动条就会显示在文本域的末尾了。
    public static void Framemain() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    JFrame.setDefaultLookAndFeelDecorated(true);

                } catch (Exception e) {

                    e.printStackTrace();
                }
                GG g= new GG();
                if (g.getWinMum()==g.getLen()){
                    g.frameInit();}
                else
                    JOptionPane.showMessageDialog(null,"谢谢您的参与~");
            }
        });

    }



    }



