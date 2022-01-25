package com.s.z.MultiThread.ProducterCustomerProblem.Object;

public class Main {
    public static void main(String[] args) throws Exception{
        Buffer buffer = new Buffer();
        int k =2;
        new Thread(new Consumer(buffer,"c1",k)).start();
        Thread p1 = new Thread(new Producer(buffer,"p1",k));
        p1.start();
        p1.join();
        Thread.sleep(10000);

    }
}
