package com.s.z.MultiThread.ProducterCustomerProblem.BlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private BlockingQueue queue;
    public Producer(BlockingQueue queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        Random random =new Random();
        while (true){
            try {
                queue.put(random.nextInt());
                System.out.println("生产者-"+Thread.currentThread().getName()+"填充一个数据");
            }catch(InterruptedException ie){
            }
        }
    }
}
