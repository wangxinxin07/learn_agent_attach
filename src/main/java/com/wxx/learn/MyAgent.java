package com.wxx.learn;

import com.sun.tools.attach.VirtualMachine;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/**
 * @author: wangxinxin-hj
 * @date: 2020/10/28 18:22
 */
public class MyAgent {

    public static void agentmain (String agentArgs, Instrumentation inst)throws Exception{
        System.out.println("[agentmain]");
        // 添加 Transformer
        ClassFileTransformer transformer = new PerformMonitorTransformer();
        inst.addTransformer(transformer, true);
        inst.retransformClasses(TestMain.class);
    }
}
