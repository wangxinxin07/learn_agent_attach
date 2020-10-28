package com.wxx.learn.attach;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;

// 一个运行 Attach API 的线程子类
// 每隔半秒时间检查一次所有的 Java 虚拟机
class AttachThread extends Thread {

    //要监听的进程
    private String targetId ;

    private final String jar;

    AttachThread(String attachJar, String attachId) {
        jar = attachJar;
        this.targetId = attachId;  // 记录程序启动时的 attach的进程ID
    }

    @Override
    public void run() {
        VirtualMachine vm = null;
        List<VirtualMachineDescriptor> listAfter = null;
        try {
            while (true) {
                listAfter = VirtualMachine.list();
                for (VirtualMachineDescriptor vmd : listAfter) {
                    if (vmd.id().equals(targetId)) {
                        // 这时，我们开始监控这个 VM
                        System.out.println("开始监听 id = " + targetId);
                        vm = VirtualMachine.attach(vmd);
                        break;
                    }
                }
                Thread.sleep(500);
                if (null != vm) {
                    break;
                }
            }
            vm.loadAgent(jar);
            vm.detach();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


