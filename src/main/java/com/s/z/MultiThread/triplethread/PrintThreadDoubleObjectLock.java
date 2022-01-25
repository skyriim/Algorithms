package com.s.z.MultiThread.triplethread;

public class PrintThreadDoubleObjectLock extends Thread {
    private String name;
    private Object lockPre;
    private Object lockNext;
    private int count;

    // pre锁wait() next锁notify() pre锁是唤醒自有逻辑的开关，next锁是唤醒下一个的开关
    public PrintThreadDoubleObjectLock(String name, Object lockPre, Object lockNext, int count) {
        this.name = name;
        this.lockPre = lockPre;
        this.lockNext = lockNext;
        this.count = count;
    }

    public void run() {
        int i = 0;
        while (i++ < count) {
            synchronized (lockPre) {

                synchronized (lockNext) {
                    System.out.print(name);
                    lockNext.notify();
                }

                try {
                    if(i<count){
                        lockPre.wait();
                    }
                } catch (InterruptedException ie) {
                }
            }
        }
    }
}