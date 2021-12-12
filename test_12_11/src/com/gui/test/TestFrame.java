package com.gui.test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestFrame {
    public static void main(String[] args) {
        //建议直接点进去看源码！
        Frame frame = new Frame("第二次尝试！");

        //设置可见性
        frame.setVisible(true);

        //设置大小
        frame.setSize(400,600);

        //设置背景颜色
        frame.setBackground(new Color(234, 189, 189));

        //弹出初始位置 置中
        frame.setLocationRelativeTo(null);

        //设置大小固定
        frame.setResizable(false);

        //设置关闭
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
