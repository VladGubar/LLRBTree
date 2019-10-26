# LLRBTree
___
Map implementation using self-implemented Left-Leaning Red-Black Tree that allows to search value about any type of data based on the key implementing the Comparable interafce. A left leaning Red Black Tree or (LLRB), is a variant of red black tree, which is easier to implement than Red Black Tree itself and guarantees all the search, delete and insert operations in O(log n) time.
___

## Interface
```java
public interface MapInterface<K extends Comparable<K>, V> {

    public void setValue(K key, V value);

    public V getValue(K key);
}
```

___

## Rules
1. Each node is either red or black.
2. Root is black.
3. Leaves (NIL) are black.
4. Only left childs can be red.
5. If node is red then both childs must be black.
6. All inserted nodes are red.

___

## Implementation
Tree class(RBTree.class) contains separate Node class that represents:
* Node key(generic type <K>)
* Node value(generic type <V>)
* Left child(left node)
* Right child(right node)
* Node color(enumerated type)
  
1. If tree is empty, adeed node must be a root.
2*. If tree is not empty, put the element in the right place (comparing the node key with other keys already stored in the tree)
3. After adding an element, reorganize the tree.
  
*Insertions in the LLRB is exactly like inserting into a Binary search tree. Adding an element is implemented using recursion
  
  ### Reorganization rules:
  #### 1 CASE:
  If the RIGHT child of the node is RED and LEFT child is BLACK (NIL is also BLACK), then do LEFT rotation and swap colors of the node and it's left child (according to the rule #6).
  ```
                        |                                                 |
                        A                 left rotation                   B
                      /   \\         ---------------------->           //   \
                   (n)      B                                         A     (n)
                          /   \                                     /   \
                       (n*)    (n)                               (n)    (n*)
```
  #### 2 CASE:
  If the LEFT child of the node is RED and LEFT grandchild is also RED, then do RIGHT rotation and swap color of the node and it's right child (according to the rule #6)
  ```
                        |                                                 |
                        C                 right rotation                  B
                      //  \          ---------------------->            //  \\
                     B    (n)                                          A      C
                   //  \                                             /   \  /   \
                  A    (n)                                         (n)  (n)(n)  (n)
                /   \
              (n)   (n)
```
  #### 3 CASE:
  If the LEFT child of the node is RED and RIGHT child is also RED, then invert colors of all nodes(exception: if node is root, it's stay in BLACK color).
  ```
                        |                                                  |
                        B                  colorization                    B
                      // \\          ---------------------->             /   \
                     A     C                                            A     C
                   /   \  /  \                                        /   \  /  \
                 (n)  (n)(n) (n)                                    (n)  (n)(n) (n)
```

___

## Tests
I did tests to study the time of insertion depending on the number of elements.
![SetValueTest](https://github.com/VladGubar/LLRBTree/raw/master/RBTree/setTest.png)
I also did tests to study the time of searching for elements by their key depending on the number of elements
![GetValueTest](https://github.com/VladGubar/LLRBTree/raw/master/RBTree/getTest.png)
