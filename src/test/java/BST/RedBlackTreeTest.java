package BST;

import com.s.z.BST.BinarySearchTree;
import com.s.z.BST.Color;
import com.s.z.BST.Node;
import com.s.z.BST.RedBlackTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RedBlackTreeTest {
    private RedBlackTree redBlackTree = new RedBlackTree();

    @Test
    public void test_a() {
        redBlackTree.put(11);

        System.out.println(redBlackTree.inOrder().toString());
        assertEquals(redBlackTree.rootNode.value.intValue(), 11);
    }

    @Test
    public void test_b() {
        redBlackTree.put(11);
        redBlackTree.put(2);

        System.out.println(redBlackTree.inOrder().toString());
        assertEquals(redBlackTree.rootNode.value.intValue(), 11);
        assertEquals(redBlackTree.inOrder().toString(), "[2, 11]");
    }

    @Test
    public void test_h() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(new Node(11, Color.Black));
        binarySearchTree.put(new Node(2, Color.Red));
        binarySearchTree.put(new Node(14, Color.Black));
        binarySearchTree.put(new Node(1, Color.Black));
        binarySearchTree.put(new Node(7, Color.Black));
        binarySearchTree.put(new Node(15, Color.Red));
        binarySearchTree.put(new Node(5, Color.Red));
        binarySearchTree.put(new Node(8, Color.Red));
        this.redBlackTree.rootNode = binarySearchTree.rootNode;

        redBlackTree.put(4);

        System.out.println(redBlackTree.inOrder().toString());
        assertEquals(7,redBlackTree.rootNode.value.intValue());
        assertEquals("[1, 2, 4, 5, 7, 8, 11, 14, 15]",redBlackTree.inOrder().toString());
    }
}
