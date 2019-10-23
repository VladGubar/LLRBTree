package rbt;

import org.junit.Test;

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
       tree.setValue(1,  null);
    }
    
}
