package com.s.z.MultiThread.ProducterCustomerProblem.Object;

import java.util.Random;

public class Consumer implements Runnable {
    private Buffer buffer;
    private String threadName;
    private int rounds;

    public Consumer(Buffer buffer, String threadName, int rounds) {
        this.buffer = buffer;
        this.threadName = threadName;
        this.rounds = rounds;
    }

    @Override
    public void run() {
        int k = 0;
        while (k<rounds){
            synchronized (buffer) {
                while (buffer.FLAG != 1) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException ie) {
                    }
                }
                for (int i = 0; i < buffer.stack.length; i++) {
                    int index = buffer.stack.length-1-i;
                    if (buffer.stack[index] != null) {
                        String infoStr = String.join("", threadName, "正在消费第", Integer.valueOf(index).toString(), "个元素->",Integer.valueOf(buffer.stack[index]).toString());
                        System.out.println(infoStr);
                        buffer.stack[index] = null;
                    }
                }
                buffer.setFLAG();
                k++;
                buffer.notifyAll();
            }
        }

    }
}
