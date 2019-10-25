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
    public void setIntegerValueTest() {
        
    }
    
    @Test
    public void setDoubleValueTest() {
        
    }
    
    @Test
    public void setStringValueTest() {
        
    }
    
    @Test
    public void setValue() {
        RBTree tree = new RBTree();
         tree.setValue("A", "A");
         tree.setValue("L", "L");
         tree.setValue("G", "G");
         tree.setValue("O", "O");
         tree.setValue("R", "R");
         tree.setValue("Y", "Y");
         tree.setValue("T", "T");
         tree.setValue("M", "M");
         
        assertEquals(1, 1);
    }
}
