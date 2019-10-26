# LLRBTree
Map implementation using self-implemented Left-Leaning Red-Black Tree that allows to search value about any type of data based on the key implementing the Comparable interafce. A left leaning Red Black Tree or (LLRB), is a variant of red black tree, which is easier to implement than Red Black Tree itself and guarantees all the search, delete and insert operations in O(log n) time.

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
  ```java
  /* 
                        |                                                 |
                        A                 left rotation                   B
                      /   \\         ---------------------->           //   \
                   (n)      B                                         A     (n)
                          /   \                                     /   \
                       (n*)    (n)                               (n)    (n*)
     */
```
![Test images](https://github.com/VladGubar/LLRBTree/raw/master/RBTree/setTest.png)
![Test images](https://github.com/VladGubar/LLRBTree/raw/master/RBTree/getTest.png)
