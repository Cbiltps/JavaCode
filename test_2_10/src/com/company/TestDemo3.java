package com.company;

//这里做的是《Think in java》关于异常的课后题

public class TestDemo3 {
    // 使用while循环建立类似 “恢复模型” 的异常处理行为，它将不断重复，直到异常不再抛出
    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("尝试连接网络第" + i + "次.........");
                i++;
            }
        }
        System.out.println("终于有网了,程序继续执行！！！！！");
    }


    public static void main1(String[] args) {
        try {
            throw new Exception("我抛出异常了！");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("我finally确实被执行了");
        }
    }
}
