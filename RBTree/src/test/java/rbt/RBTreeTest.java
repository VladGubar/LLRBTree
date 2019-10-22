package rbt;

import static org.junit.jupiter.api.Assertions.*;

public class RBTreeTest {
    
    public RBTreeTest() {
    }

    /**
     * Test of setValue method, of class RBTree.
     */
    @org.junit.jupiter.api.Test
    public void testSetValue() {
        System.out.println("setValue");
        Object key = null;
        Object value = null;
        RBTree instance = new RBTree();
        instance.setValue(key, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class RBTree.
     */
    @org.junit.jupiter.api.Test
    public void testGetValue() {
        System.out.println("getValue");
        Object key = null;
        RBTree instance = new RBTree();
        Object expResult = null;
        Object result = instance.getValue(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
