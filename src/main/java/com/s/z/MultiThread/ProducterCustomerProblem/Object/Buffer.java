package com.s.z.MultiThread.ProducterCustomerProblem.Object;

public class Buffer {
    //0正在生产 1正在消费
    public volatile int FLAG = 0;
    public Integer[] stack = new Integer[10];
    public volatile int round = 0;

    public void setFLAG(){
        FLAG = FLAG==1?0:1;
        round++;
    }
}
