package com.wxx.learn;

/**
 * @author: wangxinxin-hj
 * @date: 2020/10/28 19:31
 */
public class TestMain {

    public static void fun1(){
        System.out.println("fun1");
    }

    public static void main(String[] args) {
        while (true) {
            fun1();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
