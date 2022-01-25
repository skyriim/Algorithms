package com.s.z.LinkedList;

/**
 * Created by ZhangShuo on 2017/12/20.
 */
public class Node {
    public int val;
    public Node next;

    public Node(int val){
        this.val = val;
    }

    public Node(int val,Node next){
        this.val = val;
        this.next = next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getVal() {

        return val;
    }

    public Node getNext() {
        return next;
    }

    public String printNodeListFromSelf(){
        StringBuffer sb = new StringBuffer();
        Node tempNode = this;
        while(tempNode !=null){
            sb.append(tempNode.val+" ");
            tempNode = tempNode.next;
        }
        return sb.toString();
    }
}
