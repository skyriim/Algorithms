package com.s.z.MultiThread.ProducterCustomerProblem.AQS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        pool();
    }

    public static void pool()throws InterruptedException {
        Buffer buffer = new Buffer();
        ReentrantLock lock = new ReentrantLock();
        Condition producerCondition = lock.newCondition();
        Condition consumerCondition = lock.newCondition();
        // 每个线程执行两次核心逻辑
        int rounds = 2;
        ExecutorService pool = Executors.newFixedThreadPool(6);
        // 3个生产者3个消费者
        IntStream.range(0, 3).forEach(
                i -> {
                    pool.submit(
                            new Producer(buffer, lock, producerCondition, consumerCondition, String.join("", "producter", Integer.valueOf(i).toString()),rounds)
                    );
                    pool.submit(
                            new Consumer(buffer, lock, producerCondition, consumerCondition, String.join("", "customer", Integer.valueOf(i).toString()),rounds)
                    );
                }
        );


        pool.shutdown();
        boolean done=false;
        while(!done){
            done = pool.isTerminated();
        }
        Thread.sleep(1000);
        System.out.println("执行完毕！");
    }
    public static void thread() throws InterruptedException{
        Buffer buffer = new Buffer();
        ReentrantLock lock = new ReentrantLock();
        Condition producerCondition = lock.newCondition();
        Condition consumerCondition = lock.newCondition();
        // 每个线程执行两次核心逻辑
        int rounds = 2;
        new Thread(
                new Producer(buffer, lock, producerCondition, consumerCondition, "producter1",rounds)
        ).start();

        new Thread(
                new Consumer(buffer, lock, producerCondition, consumerCondition, "customer1",rounds)
        ).start();
        new Thread(
                new Producer(buffer, lock, producerCondition, consumerCondition, "producter2",rounds)
        ).start();

        Thread t = new Thread(
                new Consumer(buffer, lock, producerCondition, consumerCondition, "customer2",rounds)
        );
        t.start();
        t.join();

    }
}
