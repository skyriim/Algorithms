package com.s.z.BST;

public class Node {

    public Color color;

    public Node parentNode;

    public Node(){
    }

    public Node(int value){
        this.value = value;
    }
    public Node(int value,Color color){
        this.value = value;
        this.color = color;
    }

    public Integer value;

    public Node leftChildNode;

    public Node rightChildNode;

    public int compareTo(Node node){
        return this.value-node.value;
    }
}
