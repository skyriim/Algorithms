package com.s.z.MultiThread.triplethread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final int k = 10;

    public static void objectLock() throws InterruptedException{
        Object lockAB = new Object();
        Object lockBC = new Object();
        Object lockCA = new Object();
        Thread threadA = new PrintThreadDoubleObjectLock("A",lockCA,lockAB,k);
        Thread threadB = new PrintThreadDoubleObjectLock("B",lockAB,lockBC,k);
        Thread threadC = new PrintThreadDoubleObjectLock("C",lockBC,lockCA,k);

        threadA.start();
        Thread.sleep(100);
        threadB.start();
        Thread.sleep(100);
        threadC.start();

        //防止打印被控制台信息插入
        threadC.join();
        System.out.println("");
        Thread.sleep(500);
    }

    public static void aqsLock() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition ca = reentrantLock.newCondition();
        Condition cb = reentrantLock.newCondition();
        Condition cc = reentrantLock.newCondition();

        String[] array = new String[]{"A","B","C"};
        PrintThreadAQS.array = array;

        int k = 10;

        PrintThreadAQS ta = new PrintThreadAQS(array[0],reentrantLock,ca,cb,k);
        PrintThreadAQS tb = new PrintThreadAQS(array[1],reentrantLock,cb,cc,k);
        PrintThreadAQS tc = new PrintThreadAQS(array[2],reentrantLock,cc,ca,k);
        new Thread(ta,array[0]).start();
        new Thread(tb,array[1]).start();
        new Thread(tc,array[2]).start();

        Thread.sleep(100);
    }


    public static void main(String[] args) throws InterruptedException{
        //objectLock();
        aqsLock();
    }
}
