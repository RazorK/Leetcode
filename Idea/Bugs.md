# So Many Bugs to Notice
+ When we process a recursion problem, add a ArrayList to a nested ArrayList, remember to clone before add, because after the adding we may change the ArrayList, which will also change the value already in the nested arraylist.
    - eg. 113.

+ Binary Search Tree Bug, when judge the binary search tree, the possble range of a node is depends on the path from root to it.
    - eg. 98.
