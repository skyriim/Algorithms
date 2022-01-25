package com.s.z.MultiThread.ProducterCustomerProblem.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue queue;
    public Consumer(BlockingQueue queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true){
            try {
                Integer d = (Integer)queue.take();
                System.out.println("消费者-"+Thread.currentThread().getName()+"消费数据"+d.toString());
            }catch(InterruptedException ie){
            }
        }
    }
}
