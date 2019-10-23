package rbt;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RBTreeTest {
    
    public RBTreeTest() {
    }

    @Test(expected = NullArgumentException.class)
    public void should_throwNullArgumentException() {
        RBTree tree = new RBTree();
        tree.setValue(30, "Integer key, String value");
        assertTrue(tree.getRoot().key,  30 );
    }
    
class NullArgumentException extends RuntimeException {
    
    public NullArgumentException() {
        super();
    }
    
    public NullArgumentException(String message) {
        super(message);
    }
}