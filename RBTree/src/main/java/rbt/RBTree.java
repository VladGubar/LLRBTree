package rbt;

public class RBTree<K extends Comparable<K>, V> implements MapInterface<K, V> {
    
        public Node<K, V> getRoot() {
            return root;
        }
    
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

        private void colorRed() {
            color = Node.Color.Red;
        }

        private void colorBlack() {
            color = Node.Color.Black;
        }

        private boolean isRed() {
            return color == Node.Color.Red;
        }
    }

    private Node<K, V> root;
    private Node<K, V> nil;
    //public int size;

    public RBTree() {
        //size = 0;
        nil = new Node(null, null, Node.Color.Black);
        root = nil;
    }

    private Node<K, V> add(Node<K, V> node, K key, V value) {
        if (node == nil) {
            node.key = key;
            node.value = value;
            node.leftChild = nil;
            node.rightChild = nil;
            //size++;
        }
        if (key.compareTo(node.key) < 0) {
            node.leftChild = add(node.leftChild, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.rightChild = add(node.rightChild, key, value);
        }
        treeReorganize(node);
        return node;
    }

    private void treeReorganize(Node node) {
        if (node.leftChild.isRed() && node.leftChild.rightChild.isRed()) {
            node = rotateLeft(node);
        }
        if (node.leftChild.isRed() && node.leftChild.leftChild.isRed()) {
            node = rotateRight(node);
        }
        if (node.rightChild.isRed() && node.leftChild.isRed()) {
            node = paintNodes(node);
        }
    }

    private Node<K, V> rotateLeft(Node node) {
        Node<K, V> b = node.leftChild;
        Node<K, V> c = node.leftChild.rightChild;
        node.leftChild = b;
        c.leftChild = b;
        b.rightChild = nil;
        return node;
    }

    private Node<K, V> rotateRight(Node node) {
        Node<K, V> c = node.leftChild;
        Node<K, V> b = node.leftChild.leftChild;
        c.leftChild = b;
        c.rightChild = node;
        node.leftChild = nil;
        c.colorBlack();
        node.colorRed();
        return c;
    }

    private Node<K, V> paintNodes(Node node) {
        node.colorRed();
        node.leftChild.colorBlack();
        node.rightChild.colorBlack();
        return node;
    }

    private Node<K, V> findKey(Node<K, V> node, K key) {
        if (node == nil) {
            return null;
        }
        if (key.compareTo(node.key) > 0) {
            return findKey(node.rightChild, key);
        } else if (key.compareTo(node.key) < 0) {
            return findKey(node.leftChild, key);
        } else {
            return node;
        }
    }
    
    @Override
    public void setValue(K key, V value) {
        if (key == null || value == null) {
            throw new NullArgumentException("Cannot set null arguments");
        }
        if (findKey(root, key) == null) {
            root = add(root, key, value);
        } else {
            findKey(root, key).value = value;
        }
    }

    @Override
    public V getValue(K key) {
        return findKey(root, key).value;
    }
}

class NullArgumentException extends RuntimeException {

    public NullArgumentException() {
        super();
    }

    public NullArgumentException(String message) {
        super(message);
    }
}
