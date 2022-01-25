package com.s.z.LeetCode.singleton;

public class SingletonDemo {

    private SingletonDemo(){}

    private static volatile SingletonDemo singletonDemo = null;

    public static SingletonDemo getInstance(){
        //double check
        if(singletonDemo ==null){
            synchronized(SingletonDemo.class){
                if(singletonDemo ==null){
                    singletonDemo = new SingletonDemo(); // 初始化分三步：1.分配空间 2.初始化 3.赋值地址  步骤2和步骤3可能会出现代码重排，在多线程的情况下不安全，所以使用volatile修饰
                }
            }
        }
        return singletonDemo;
    }
}
