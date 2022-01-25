package com.s.z.MultiThread.triplethread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintThreadAQS implements Runnable {
    public static String[] array;
    private static volatile int FLAG = 0;
    private String name;
    public ReentrantLock lock;
    public Condition self;
    public Condition next;
    private int count;

    public PrintThreadAQS(String name, ReentrantLock lock, Condition self, Condition next, int count) {
        this.name = name;
        this.lock = lock;
        this.self = self;
        this.next = next;
        this.count = count;
    }

    public void run() {
        try {
            lock.lock();
            for (int i = 0; i < count; i++) {
                while (!array[FLAG].equals(name)) {
                    self.await();
                }
                System.out.print(name);
                setFlag();
                next.signal();
            }
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    private void setFlag() {
        FLAG = array.length - 1 == FLAG ? 0 : FLAG + 1;
    }
}
