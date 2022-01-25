package com.s.z.MultiThread.ProducterCustomerProblem.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args){
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(10);
        new Thread(new Producer(queue),"producerA").start();
        new Thread(new Producer(queue),"producerB").start();
        new Thread(new Consumer(queue),"consumerA").start();
        new Thread(new Consumer(queue),"consumerB").start();
    }
}
