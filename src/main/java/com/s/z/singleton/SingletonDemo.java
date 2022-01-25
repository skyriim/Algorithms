package com.s.z.singleton;

public class SingletonDemo {

    private SingletonDemo(){}

    private static volatile SingletonDemo singletonDemo = null;

    public static SingletonDemo getInstance(){
        //double check
        if(singletonDemo ==null){
            synchronized(SingletonDemo.class){
                if(singletonDemo ==null){
                    singletonDemo = new SingletonDemo(); // 初始化分三步：1.分配空间 2.初始化 3.赋值地址  步骤2和步骤3可能会出现指令重排，在多线程的情况下不安全（导致第二个线程直接返回这个内存地址，此时第一个线程可能尚未完成初始化），所以使用volatile修饰
                }
            }
        }
        return singletonDemo;
    }
}
