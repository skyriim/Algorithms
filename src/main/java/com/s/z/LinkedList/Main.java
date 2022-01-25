package com.s.z.LinkedList;

/**
 * Created by ZhangShuo on 2017/12/20.
 */
public class Main {
    public static void main(String[] args){
        Node d = new Node(4);
        Node c = new Node(3,d);
        Node b = new Node(2,c);
        Node a = new Node(1,b);
        //System.out.println(a.printNodeListFromSelf());
        System.out.println(reverse_(a).printNodeListFromSelf());

    }
    private static Node reverse(Node node){
        if(node ==null || node.next ==null){
            return node;
        }
        Node result = reverse(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
        return result;
    }

    private static Node reverse_(Node node){
        if(node == null || node.next ==null){
            return node;
        }

        Node preOne = node;
        Node curOne = node.next;
        Node tempOne ;
        while(curOne!=null){
            tempOne = curOne.next;
            curOne.next = preOne;
            preOne = curOne;
            curOne = tempOne;
        }

        node.next = null;

        return preOne;
    }

}
