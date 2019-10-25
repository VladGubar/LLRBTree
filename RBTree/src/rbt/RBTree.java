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

    public RBTree() {
        nil = new Node(null, null, Node.Color.Black);
        root = nil;
    }

    private Node<K, V> add(Node<K, V> node, K key, V value) {
        if (node == nil) {
            node = new Node(key, value);
            node.leftChild = nil;
            node.rightChild = nil;
        }
        if (key.compareTo(node.key) < 0) {
            node.leftChild = add(node.leftChild, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.rightChild = add(node.rightChild, key, value);
        }
        node = treeReorganize(node);
        return node;
    }

    private Node<K, V> treeReorganize(Node node) {
        if (node.rightChild.isRed() && !node.leftChild.isRed()) {
           node = rotateLeft(node);
           swapColors(node, node.leftChild);
        }
        if(node.leftChild.isRed() && node.leftChild.leftChild.isRed()) {
            node = rotateRight(node);
           swapColors(node, node.rightChild);
        }
        if (node.rightChild.isRed() && node.leftChild.isRed()) {
            node = paintNodes(node);
        }
        return node;
    }

    private Node<K, V> rotateLeft(Node node) {
        Node<K, V> child = node.rightChild;
        Node<K, V> childLeft = child.leftChild;
        child.leftChild = node;
        node.rightChild = childLeft;
        //if (node == root) {
          //  child.colorBlack();
           // root = child;
        //}
        return child;
    }

    private Node<K, V> rotateRight(Node node) {
        Node<K, V> child = node.leftChild;
        Node<K, V> childRight = child.rightChild;
        child.rightChild = node;
        node.leftChild = childRight;
       // if (node == root) {
         //   child.colorBlack();
         //   root = child;
        //}
        return child;
    }

    private Node<K, V> paintNodes(Node node) {
        if(node != root) {
            node.colorRed();
        }
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
    
    public void swapColors(Node<K, V> node1, Node<K, V> node2) {
        Node.Color tmp = node1.color;
        node1.color = node2.color;
        node2.color = tmp;
    }

    public Node<K, V> getRoot() {
        return root;
    }

    @Override
    public void setValue(K key, V value) {
        if (key == null || value == null) {
            throw new NullArgumentException("Cannot set null arguments");
        }
        if (findKey(root, key) == null) {
            root = add(root, key, value);
            root.colorBlack();
        } else {
            findKey(root, key).value = value;
            root = treeReorganize(root);
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
