package com.demo;

public class Test_exception1 {
    public static void main(String[] args) {
        Test1();
    }
    
    public static int Test1(){
        int x = 5;
        try
        {
//            int num = x / 0;
//            System.out.println("try");
            return 4;
        }
        catch (ArithmeticException e) {
            System.err.println("除数不能为0！");
            return 4;
        }
        finally
        {
            ++x;
            System.out.println("finally");
            return 2;
        }
    }
}