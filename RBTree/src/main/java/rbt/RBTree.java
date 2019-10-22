package rbt;

public class RBTree<K extends Comparable<K>, V> implements MapInterface<K, V> {

    static class Node<K, V> {

        K key;
        V value;
        Node<K, V> leftChild;
        Node<K, V> rightChild;
        Node<K, V> parent;

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
            node.leftChild.parent = node;
        } else if (key.compareTo(node.key) > 0) {
            node.rightChild = add(node, key, value);
            node.rightChild.parent = node;
        }
        treeReorganize(node);
        return node;
    }

    private void treeReorganize(Node node) {
        if (node.leftChild.color == Node.Color.Red && node.leftChild.rightChild.color == Node.Color.Red) {
            node = rotateLeft(node);
        }
        if (node.leftChild.color == Node.Color.Red && node.leftChild.leftChild.color == Node.Color.Red) {
            node = rotateRight(node);
        }
        if (node.rightChild.color == Node.Color.Red && node.leftChild.color == Node.Color.Red) {
            node = paintNodes(node);
        }
    }

    private Node<K, V> rotateLeft(Node node) {
        Node<K, V> b = node.leftChild;
        Node<K, V> c = node.leftChild.rightChild;
        node.leftChild = b;
        c.leftChild = b;
        b.rightChild = nil;
        b.parent = c;
        c.parent = node;
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

    @Override
    public void setValue(K key, V value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V getValue(K key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
