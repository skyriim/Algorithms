package com.s.z.BST;

import java.util.ArrayList;
import java.util.List;

public class BasicBinarySearchTree {
    public Node rootNode;

    public BasicBinarySearchTree(Node rootNode) {
        this.rootNode = rootNode;
    }

    public BasicBinarySearchTree() {
    }

    /**
     * DLR -> Pre order traversal
     * 前序遍历、先序遍历
     * 中->前->后
     *
     * @return
     */
    public List<Integer> preOrder() {
        if (rootNode == null) {
            return null;
        }
        List<Integer> result = new ArrayList<Integer>();
        preOrder(rootNode, result);
        return result;
    }

    private void preOrder(Node node, List<Integer> resultList) {
        if (node == null) {
            return;
        }
        resultList.add(node.value);
        preOrder(node.leftChildNode, resultList);
        preOrder(node.rightChildNode, resultList);
    }

    /**
     * LDR -> Inorder traversal
     * 中序遍历、中根遍历
     * 前->中->后
     *
     * @return
     */
    public List<Integer> inOrder() {
        if (this.rootNode == null) {
            return null;
        }
        List<Integer> result = new ArrayList<Integer>();
        inOrder(rootNode, result);
        return result;
    }

    private void inOrder(Node node, List<Integer> resultList) {
        if (node == null) {
            return;
        }
        inOrder(node.leftChildNode, resultList);
        resultList.add(node.value);
        inOrder(node.rightChildNode, resultList);
    }

    public List<Node> getNodesInOrder() {
        if (this.rootNode == null) {
            return null;
        }
        List<Node> result = new ArrayList<Node>();
        getNodesInOrder(rootNode, result);
        return result;
    }

    public void getNodesInOrder(Node node, List<Node> resultList) {
        if (node == null) {
            return;
        }
        getNodesInOrder(node.leftChildNode, resultList);
        resultList.add(node);
        getNodesInOrder(node.rightChildNode, resultList);
    }

    /**
     * LRD-> Postorder traversal
     * 后序遍历、后根遍历
     * 前->后->中
     *
     * @return
     */
    public List<Integer> postOrder() {
        if (rootNode == null) {
            return null;
        }
        List<Integer> result = new ArrayList<Integer>();
        postOrder(rootNode, result);
        return result;
    }

    private void postOrder(Node node, List<Integer> resultList) {
        if (node == null) {
            return;
        }
        postOrder(node.leftChildNode, resultList);
        postOrder(node.rightChildNode, resultList);
        resultList.add(node.value);
    }
}
