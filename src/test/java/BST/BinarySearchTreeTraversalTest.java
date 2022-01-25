package BST;

import com.s.z.BST.BinarySearchTree;
import com.s.z.BST.Node;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class BinarySearchTreeTraversalTest {

    private Node rootNode = this.setRootNode();
    BinarySearchTree binarySearchTree =new BinarySearchTree(rootNode);

    /**
     * 答案：[7, 4, 1, 5, 9, 8, 10]
     */
    @Test
    public void preOrderTest() {
        List<Integer> resultList = binarySearchTree.preOrder();
        assertEquals(resultList.toString(),"[7, 4, 1, 5, 9, 8, 10]");
    }

    /**
     * 答案：[1, 4, 5, 7, 8, 9, 10]
     */
    @Test
    public void inOrderTest(){
        assertEquals(binarySearchTree.inOrder().toString(),"[1, 4, 5, 7, 8, 9, 10]");
    }

    /**
     * 答案：[1, 5, 4, 8, 10, 9, 7]
     */
    @Test
    public void posOrderTest(){
        assertEquals(binarySearchTree.postOrder().toString(),"[1, 5, 4, 8, 10, 9, 7]");
    }

    private Node setRootNode() {
        Node seven = new Node(7);

        Node four = new Node(4);
        Node one = new Node(1);
        Node five = new Node(5);
        four.leftChildNode = one;
        four.rightChildNode = five;

        Node nine = new Node(9);
        Node eight = new Node(8);
        Node ten = new Node(10);
        nine.leftChildNode = eight;
        nine.rightChildNode = ten;

        seven.leftChildNode = four;
        seven.rightChildNode = nine;
        return seven;
    }
}
