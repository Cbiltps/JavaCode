package com.gui.test;

import javax.swing.*;
import java.awt.*;

public class TestFrame2 extends JFrame {

    public static void main(String[]args){
        MyFrame myFrame = new MyFrame();
    }
}

class MyFrame extends JFrame {
    public MyFrame() {
        super("第三次尝试！");
        setSize(400,300);//设置窗口大小
        setLocationRelativeTo(null);//设置常窗口初始化位置默认置中
        setResizable(false);//设置大小不可调节
        setDefaultCloseOperation(EXIT_ON_CLOSE);//设置关闭按钮关联窗体关闭
        setVisible(true);//设置可见
    }
}
