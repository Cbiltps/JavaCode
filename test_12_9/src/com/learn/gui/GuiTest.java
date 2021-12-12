package com.learn.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GuiTest extends JFrame{
    private JPanel panel1;
    private JButton PointMe;
    private JPasswordField passwordField1;

    public GuiTest() {
        super("这是我的Gui程序！");
        setContentPane(panel1);//设置内容面板
        setVisible(true);//设置可见
        setSize(400,300);//设置窗口大小
        setResizable(false);//设置大小不可调节
        setLocationRelativeTo(null);//设置常窗口初始化位置默认置中
        setDefaultCloseOperation(EXIT_ON_CLOSE);//设置关闭按钮关联窗体关闭
        PointMe.addActionListener(new AbstractAction() { //按钮响应
            @Override
            public void actionPerformed(ActionEvent e) {
                //dialog 比frame简单 没有最大化和最小化按钮
                MyDialog myDialog = new MyDialog();
                myDialog.myDialogDemo();
            }
        });
    }
    
    public static void main(String[] args) {
        new GuiTest();
    }
}

class MyDialog extends JDialog {
    public void myDialogDemo() {
        this.setVisible(true);
        this.setBounds(100,100,500,500);//位置
        Container container = this.getContentPane();
        container.setLayout(null);
        container.add(new Label("欢迎点击！"));
    }
}
