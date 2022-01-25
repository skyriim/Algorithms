package com.s.z.BST;

public class RedBlackTree extends BinarySearchTree {
    private static Color BLACK = Color.Black;
    private static Color RED = Color.Red;

    @Override
    public boolean put(Node node) {
        if (this.rootNode == null) {
            this.rootNode = node;
            this.rootNode.color = BLACK;
            return true;
        }
        return put(rootNode, node);
    }

    public boolean put(int value) {
        return put(new Node(value, Color.Red));
    }

    public boolean put(Node currentNode, Node node) {
        if (node.color == null || node.color == BLACK) {
            node.color = RED;
        }

        if (currentNode.value == null) {
            currentNode.value = node.value;
            currentNode.color = node.color;
            node = currentNode;
        } else if (node.compareTo(currentNode) < 0) {
            if (currentNode.leftChildNode == null) {
                currentNode.leftChildNode = new Node();
                currentNode.leftChildNode = currentNode;
            }
            put(currentNode.leftChildNode, node);
        } else if (node.compareTo(currentNode) > 0) {
            if (currentNode.rightChildNode == null) {
                currentNode.rightChildNode = new Node();
                currentNode.rightChildNode.parentNode = currentNode;
            }
            put(currentNode.rightChildNode, node);
        }

        try {
            //1. 判断current的parent&uncle 的颜色是否皆红并变色
            if (currentNode.color == RED && currentNode.parentNode != null && currentNode.parentNode.parentNode != null
                    && currentNode.parentNode.parentNode.leftChildNode.color == RED && currentNode.parentNode.parentNode.rightChildNode.color == RED) {
                currentNode.parentNode.parentNode.leftChildNode.color = BLACK;
                currentNode.parentNode.parentNode.rightChildNode.color = BLACK;
                currentNode.parentNode.parentNode.color = RED;
            }

            //2. 判断current的父节点是否是RED且是其右子节点 且uncle是BLACK
            if (currentNode.color == RED && currentNode.parentNode != null && currentNode.parentNode.parentNode != null
                    && currentNode.parentNode.color == RED && getUncle(currentNode).color == BLACK && currentNode == currentNode.parentNode.rightChildNode) {
                //左旋父节点
                leftRotate(currentNode.parentNode);
            }

            //3. 判断current node的父节点是否是RED且是其左子节点 且uncle是BLACK
            if (currentNode.color == RED && currentNode.parentNode != null && currentNode.parentNode.parentNode != null
                    && currentNode.parentNode.color == RED && getUncle(currentNode).color == BLACK && currentNode == currentNode.parentNode.leftChildNode) {
                //父变黑 祖父变红
                currentNode.parentNode.color = BLACK;
                currentNode.parentNode.parentNode.color = RED;
                //右旋祖父节点
                rightRotate(currentNode.parentNode.parentNode);
            }
        } catch (Exception e) {
            System.out.println("处理节点" + currentNode.value + "出错");
        }
        this.rootNode.color = BLACK;
        return true;
    }

    /*
     * 左旋
     * 对节点x进行左旋示意图:
     *     p                       p
     *    /                       /
     *   x                       y
     *  / \                     / \
     * lx  y      ----->       x  ry
     *    / \                 / \
     *   ly ry               lx ly
     *
     */
    private boolean leftRotate(Node node) {
        Node parent = node.parentNode;
        Node rightChild = node.rightChildNode;
        if (parent != null) {
            //顶替
            if (parent.leftChildNode == node) {
                parent.leftChildNode = rightChild;
            } else {
                parent.rightChildNode = rightChild;
            }
            rightChild.parentNode = parent;
        }

        //过继
        node.rightChildNode = rightChild.leftChildNode;
        if (node.rightChildNode != null) {
            node.rightChildNode.parentNode = node;
        }

        //完成旋转
        node.parentNode = rightChild;
        rightChild.leftChildNode = node;
        if (node == rootNode) {
            rootNode = rightChild;
        }
        return true;
    }

    /*
     * 右旋
     * 对节点y进行右旋示意图：
     *        p                   p
     *       /                   /
     *      y                   x
     *     / \                 / \
     *    x  ry   ----->      lx  y
     *   / \                     / \
     * lx  rx                   rx ry
     *
     */
    private boolean rightRotate(Node node) {
        Node parent = node.parentNode;
        Node leftChild = node.leftChildNode;
        if (parent != null) {
            //顶替
            if (parent.leftChildNode == node) {
                parent.leftChildNode = leftChild;
            } else {
                parent.rightChildNode = leftChild;
            }
            leftChild.parentNode = parent;
        }

        //过继
        node.leftChildNode = leftChild.rightChildNode;
        if (node.leftChildNode != null) {
            node.leftChildNode.parentNode = node;
        }

        //完成旋转
        node.parentNode = leftChild;
        leftChild.rightChildNode = node;

        if (rootNode == node) {
            rootNode = leftChild;
        }
        return true;
    }

    private Node getUncle(Node node) {
        Node parentNode = node.parentNode;
        Node grandParentNode = parentNode.parentNode;
        if (parentNode == grandParentNode.leftChildNode) {
            return grandParentNode.rightChildNode;
        } else {
            return grandParentNode.leftChildNode;
        }
    }

    private Node getBrother(Node node) {
        Node parentNode = node.parentNode;
        if (parentNode == node.leftChildNode) {
            return parentNode.rightChildNode;
        } else {
            return parentNode.leftChildNode;
        }
    }
}
