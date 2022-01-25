package com.s.z.MultiThread.ProducterCustomerProblem.Object;

import java.util.Random;

public class Producer implements Runnable {
    private Buffer buffer;
    private String threadName;
    private int rounds;

    public Producer(Buffer buffer, String threadName, int rounds) {
        this.buffer = buffer;
        this.threadName = threadName;
        this.rounds = rounds;
    }

    @Override
    public void run() {
        int k = 0;
        while (k < rounds) {
            synchronized (buffer) {
                while (buffer.FLAG != 0) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException ie) {
                    }
                }
                for (int i = 0; i < buffer.stack.length; i++) {
                    if (buffer.stack[i] == null) {
                        Random random = new Random();
                        buffer.stack[i] = random.nextInt();
                        String infoStr = String.join("", threadName, "正在生产第", Integer.valueOf(i).toString(), "个元素");
                        System.out.println(infoStr);
                    }
                }
                buffer.setFLAG();
                k++;
                buffer.notifyAll();
            }
        }
    }
}
