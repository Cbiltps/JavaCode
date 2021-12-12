package com.gui.test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestPanel {
    //可以看成一个空间 但是不能单独存在
    public static void main(String[] args) {
        Frame frame = new Frame();
        Panel panel = new Panel();

        //设置布局
        frame.setLayout(null);

        //坐标与颜色
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(151, 213, 160));

        //panel的设置 相对于 frame
        panel.setBounds(50,50,400,400);
        panel.setBackground(new Color(210, 154, 154));

        //添加
        frame.add(panel);

        //显示界面
        frame.setVisible(true);

        //监听事件 的关闭窗口
        //适配器模式
        frame.addWindowListener(new WindowAdapter() {
            @Override
            //点击窗口关闭的时候做的事情
            public void windowClosing(WindowEvent e) {
                //结束程序
                System.exit(0);
            }
        });
    }
}


