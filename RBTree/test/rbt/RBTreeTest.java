package rbt;

import org.junit.Test;
import static org.junit.Assert.*;

public class RBTreeTest {

    public RBTreeTest() {
    }

    @Test(expected = NullArgumentException.class)
    public void should_throwNullArgumentException_when_null_key() {
        RBTree tree = new RBTree();
        tree.setValue(null, "Must be an exception");
    }

    @Test(expected = NullArgumentException.class)
    public void should_throwNullArgumentException_when_null_value() {
        RBTree tree = new RBTree();
        tree.setValue(0, null);
    }

    @Test
    public void setValueTest() {
        RBTree tree = new RBTree();
        tree.setValue(1, "Integer value");
        assertEquals(1, tree.getRoot().key);
    }
    
    @Test
    public void setValue() {
        RBTree tree = new RBTree();
         tree.setValue(40, "Integer value");
         tree.setValue(35, "Integer value3");
         tree.setValue(37, "Integer value2");
         System.out.println( tree.getRoot().key);
         System.out.println( tree.getRoot().color);
         System.out.println( tree.getRoot().leftChild.key);
         System.out.println( tree.getRoot().leftChild.color);
         System.out.println( tree.getRoot().rightChild.key);
         System.out.println( tree.getRoot().rightChild.color);
        assertEquals(tree.getRoot().key , tree.getRoot().rightChild.key);
    }
}
