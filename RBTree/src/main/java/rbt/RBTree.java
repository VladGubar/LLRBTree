package rbt;

public class RBTree<K extends Comparable<K>, V> implements MapInterface<K, V> {

    static class Node<K, V> {

        K key;
        V value;
        Node<K, V> leftChild;
        Node<K, V> rightChild;

        public enum Color {
            Red,
            Black;
        }
        Color color;

        public Node(K key, V value, Color color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            color = Color.Red;
        }
    }

    private Node<K, V> root;
    private Node<K, V> nil;
    public int size;

    public RBTree() {
        size = 0;
        nil = new Node(null, null, Node.Color.Black);
        root = nil;
    }

    private Node<K, V> add(Node<K, V> node, K key, V value) {
        if (node == nil) {
            node.key = key;
            node.value = value;
            node.leftChild = nil;
            node.rightChild = nil;
            size++;
        }
        if (key.compareTo(node.key) < 0) {
            node.leftChild = add(node, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.rightChild = add(node, key, value);
        }
        treeReorganize(node);
        return node;
    }
    
    private void treeReorganize(Node node) {
        //node = rotateRight(node);
        //node = rotateLeft(node);
        if(node.rightChild.color == Node.Color.Red && node.leftChild.color == Node.Color.Red) {
            paintNode(node);
        }
    }
    
    private void rotateRight(Node node) {
        
    }
    
    private void rotateLeft(Node node) {
        
    }
    
    private void paintNode(Node node) {
            node.rightChild.color = Node.Color.Black;
            node.leftChild.color = Node.Color.Black;
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
