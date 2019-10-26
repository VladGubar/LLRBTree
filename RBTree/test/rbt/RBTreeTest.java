package rbt;

import java.io.FileNotFoundException;
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
        tree.setValue("A", "I will be a left child with red color after left rotation");
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
    
    @Test
    public void testingTest() throws FileNotFoundException {
        int k = 3000; //Optimal number of elements for plotting
        TestingClass test = new TestingClass();
        test.testingSetAndGet(k); 
    }
    
    @Test
    public void treeAndArrayTest() throws FileNotFoundException {
        TestingClass test = new TestingClass();
        test.testingMapAndArray(200, "test1.txt");
        test.testingMapAndArray(400, "test2.txt");
        test.testingMapAndArray(600, "test3.txt");
        test.testingMapAndArray(800, "test4.txt");
        test.testingMapAndArray(1000, "test5.txt");
        test.testingMapAndArray(5000, "test6.txt");
        test.testingMapAndArray(10000, "test7.txt");
        test.testingMapAndArray(50000, "test8.txt");
        test.testingMapAndArray(100000, "test9.txt");
        test.testingMapAndArray(200000, "test10.txt");
        test.testingMapAndArray(400000, "test11.txt");
        test.testingMapAndArray(600000, "test12.txt");
        test.testingMapAndArray(800000, "test13.txt");
        test.testingMapAndArray(1000000, "test14.txt");
    }
}
