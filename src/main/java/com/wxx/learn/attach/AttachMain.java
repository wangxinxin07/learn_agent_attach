package com.wxx.learn.attach;

import com.sun.tools.attach.VirtualMachine;

/**
 * @author: wangxinxin-hj
 * @date: 2020/10/28 19:19
 */
public class AttachMain {

    public static void main(String[] args) throws InterruptedException {
        new AttachThread("D:\\my-agent-attach.jar", "13528").start();

        AttachMain main = new AttachMain();
        synchronized (main) {
            main.wait();
        }
    }
}
