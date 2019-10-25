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
        tree.setValue(1, "String value");
        assertEquals(1, tree.getRoot().key);
        assertEquals("String value", tree.getRoot().value);
    }

    @Test
    public void setIntegerKeyTest() {
        RBTree tree = new RBTree();
        tree.setValue(134, "Integer key");
        assertEquals(134, tree.getRoot().key);
    }

    @Test
    public void setDoubleKeyTest() {
        RBTree tree = new RBTree();
        tree.setValue(5.62, "Double key");
        assertEquals(5.62, tree.getRoot().key);
    }

    @Test
    public void setStringKeyTest() {
        RBTree tree = new RBTree();
        tree.setValue("Hello, World", "String key");
        assertEquals("Hello, World", tree.getRoot().key);
    }

    @Test
    public void changingValueOfLeftChildByKey() {
        RBTree tree = new RBTree();
        tree.setValue(12, "Root");
        tree.setValue(10, "Please, don't rotate me");
        tree.setValue(10, "I'm steel left child!");
        assertEquals("I'm steel left child!", tree.getRoot().leftChild.value);
    }

    @Test
    public void changingValueOfRightChildByKey() {
        RBTree tree = new RBTree();
        tree.setValue("A", "I want to be a left child");
        tree.setValue("L", "Please, don't rotate me");
        tree.setValue("G", "I want to be a root");
        tree.setValue("L", "Why did you rotated me? T_T");
        assertEquals("Why did you rotated me? T_T", tree.getRoot().rightChild.value);
    }

    @Test
    public void leftRotationTest() {
        RBTree tree = new RBTree();
        tree.setValue("A",  "I will be a left child with red color after left rotation");
        tree.setValue("B", "I will be a root with black color after left rotation");
        assertEquals("B", tree.getRoot().key);
        assertEquals("A", tree.getRoot().leftChild.key);
        assertEquals(false, tree.getRoot().isRed());
        assertNotEquals(tree.getRoot().color, tree.getRoot().leftChild.color);
    }
        /* 
                                             |                                                                 |
                                            A                 left rotation                   B
                                          /   \\         ---------------------->           //    \
                                       (n)     B                                                    A       (n)
                                                /   \                                               /    \
                                          (n*)    (n)                                      (n)    (n*)
        */
    
    @Test
    public void rightRotation_and_colorization_test() {
        RBTree tree = new RBTree();
        tree.setValue("C", "");
        tree.setValue("B", "");
        tree.setValue("A", "");
        assertEquals("B", tree.getRoot().key);
        assertEquals("A", tree.getRoot().leftChild.key);
        assertEquals("C", tree.getRoot().rightChild.key);
        assertEquals(false, tree.getRoot().isRed());
        assertEquals(tree.getRoot().color, tree.getRoot().leftChild.color);
        assertEquals(tree.getRoot().color, tree.getRoot().rightChild.color);
    }
    
    /*
                                             |                                                                 |
                                            C              right rotation                    B
                                        //    \         ---------------------->            //    \\
                                      B       (n)                                                   A         C
                                  //   \                                                            /   \      /   \
                                A     (n)                                                     (n)   (n)(n)  (n)
                             /    \
                         (n)    (n)
                                                                                        //
                                                                                      //
                                                                                    //      colorization
                                                                                  //
                                                                                 \/
    
                                                                              |                                          
                                                                             B                
                                                                           /   \             
                                                                        A       C                                            
                                                                      /   \    /  \                                          
                                                                 (n)  (n)(n)  (n)   
    
    */
    
    
}
