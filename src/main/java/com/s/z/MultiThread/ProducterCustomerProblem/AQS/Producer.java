package com.s.z.MultiThread.ProducterCustomerProblem.AQS;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable {

    private Buffer buffer;
    private ReentrantLock lock;
    private Condition cc;
    private Condition pc;
    private String threadName;
    private int rounds;

    public Producer(Buffer buffer, ReentrantLock lock, Condition pc, Condition cc, String threadName, int rounds) {
        this.buffer = buffer;
        this.lock = lock;
        this.cc = cc;
        this.pc = pc;
        this.threadName = threadName;
        this.rounds = rounds;
    }

    public void run() {
        int round = 0;
        while (round<rounds) {
            lock.lock();
            try {
                while (buffer.FLAG == 1) {
                    pc.await();
                }
                for (int i = 0; i < buffer.stack.length; i++) {
                    if (buffer.stack[i] == null) {
                        Random random = new Random();
                        buffer.stack[i] = random.nextInt();
                        String infoStr = String.join("", threadName, "正在生产stack第", Integer.valueOf(i).toString(), "个元素");
                        System.out.println(infoStr);
                    }
                }
                buffer.setFLAG();
                round++;
                cc.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        //System.out.println(threadName+" is release！");
    }
}
