package rbt;


public class RBTree<K extends Comparable<K>, V> implements MapInterface<K, V> {
    
    static class Node<K, V> {
        K key;
        V value;
        Node <K, V> leftChild;
        Node <K, V> rightChild;
        public enum Color {
            Red,
            Black;
        }
    
    
        public Node(K key, V value, enum Color) {
                this.key = key;
                this.value = value;
                this.Color = Color;
             }
    }
    
    private Node<K, V> root;
    private int size;
    
    public RBTree () {
        size = 0;
        root = null;
    }
    
    @Override
    public void setValue(K key, V value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V getValue(K key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
