package com.s.z.BST;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree extends BasicBinarySearchTree implements IBinarySearchTree {

    public BinarySearchTree(Node rootNode) {
        super(rootNode);
    }

    public BinarySearchTree() {
    }


    public boolean put(Node node) {
        if (this.rootNode == null) {
            this.rootNode = node;
            return true;
        }
        return put(rootNode, node);
    }

    private boolean put(Node parentNode, Node node) {
        if (parentNode.value == null) {
            parentNode.value = node.value;
            parentNode.color = node.color;
            node = parentNode;
        }else if (node.value < parentNode.value) {
            if (parentNode.leftChildNode == null) {
                parentNode.leftChildNode = new Node();
                parentNode.leftChildNode.parentNode = parentNode;
            }
            return put(parentNode.leftChildNode, node);
        }else if (node.value > parentNode.value) {
            if (parentNode.rightChildNode == null) {
                parentNode.rightChildNode = new Node();
                parentNode.rightChildNode.parentNode = parentNode;
            }
            return put(parentNode.rightChildNode, node);
        }else if (node.value == parentNode.value) {
            return false;
        }
        return false;
    }

    public Node search(int value) {
        return search(rootNode, value);
    }

    private Node search(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            return node;
        }
        if (value < node.value) {
            return search(node.leftChildNode, value);
        }
        if (value > node.value) {
            return search(node.rightChildNode, value);
        }
        return null;
    }

    public void remove(Node node) {
        if (node.leftChildNode == null && node.rightChildNode == null) {
            node = null;
            return;
        }
        if (node.leftChildNode != null && node.rightChildNode == null) {
            node = node.leftChildNode;
            return;
        }
        if (node.leftChildNode == null && node.rightChildNode != null) {
            node = node.rightChildNode;
            return;
        }
        List<Node> subTree = new ArrayList<Node>();
        super.getNodesInOrder(node, subTree);
        Node repNode = subTree.get(subTree.indexOf(node) + 1);
        repNode.leftChildNode = node.leftChildNode;
        repNode.rightChildNode = node.rightChildNode;
        repNode.parentNode = node.parentNode;
        node = null;
    }

}
