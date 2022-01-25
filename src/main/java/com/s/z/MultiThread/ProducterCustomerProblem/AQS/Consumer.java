package com.s.z.MultiThread.ProducterCustomerProblem.AQS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Consumer implements Runnable {
    private Buffer buffer;
    private String threadName;
    private ReentrantLock lock;
    private Condition cc;
    private Condition pc;
    private int rounds;

    public Consumer(Buffer buffer, ReentrantLock lock, Condition pc, Condition cc, String threadName, int rounds) {
        this.buffer = buffer;
        this.lock = lock;
        this.cc = cc;
        this.pc = pc;
        this.threadName = threadName;
        this.rounds = rounds;
    }

    @Override
    public void run() {
        int round = 0;
        while (round<rounds) {
            lock.lock();
            try {
                while (buffer.FLAG == 0) {
                    cc.await();
                }
                IntStream.range(0, 10).forEach(i -> {
                            int index = buffer.stack.length - 1 - i;
                            String infoStr = String.join("", threadName, "正在消费第", Integer.valueOf(index).toString(), "元素->", Integer.valueOf(buffer.stack[index]).toString());
                            System.out.println(infoStr);
                            buffer.stack[index] = null;
                        }
                );
                buffer.setFLAG();
                round++;
                pc.signalAll();
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                lock.unlock();
            }
        }

    }
}