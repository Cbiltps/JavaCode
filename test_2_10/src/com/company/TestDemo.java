package com.company;

// Main文件中简单的讲了一下 自定义异常，下面开始更全面的讲解
class NameException extends RuntimeException{
    public NameException(String message) {
        super(message);
    }
}
class PasswordException extends RuntimeException{
    public PasswordException(String message) {
        super(message);
    }
}
public class TestDemo {
    private static final String name = "bit";
    private static final String password = "123";

    public static void login(String name,String password) throws  NameException,PasswordException{
        if(!TestDemo.name.equals(name)) {
            throw new NameException("用户名错误！");
        }
        if(!TestDemo.password.equals(password)) {
            throw new PasswordException("密码错误！");
        }
    }

    public static void main(String[] args) {
        try {
            login("bit","1234");
        }catch (NameException e) {
            System.out.println("用户名错误了！");
        }catch (PasswordException e) {
            e.printStackTrace();
            System.out.println("密码错误了！");
        }finally {
            System.out.println("finally执行了！");
        }
    }
}