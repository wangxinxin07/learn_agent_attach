步骤

1、启动测试类com.wxx.learn.TestMain  模拟应用程序

2、mvn clean package 打包agent程序 复制到D盘

3、JPS 观察步骤1 TestMain 的应用进程号，替换com.wxx.learn.attach.AttachMain main方法里的进程号

4、启动com.wxx.learn.attach.AttachMain 主方法 ，异步线程attach到模拟应用程序，完成监听和类的替换

5、观察com.wxx.learn.TestMain 结果。完成替换！