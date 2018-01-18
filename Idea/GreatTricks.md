# Tricks
- Get the mean value and avoid overflow.
    + use `left + (right - left) / 2`
    + rather than `(left + right) / 2`
    + because `(left + right)` may exceed the boundary.
- Sometimes, if the inputs are bounded in a known range, we can use array in place of HashMap.
    + eg. 76.
- Make use of useless space.
    + eg. 73. 79.
- Idea to scan from both sides.
    + eg. 42.
- Use stack to store the possibility and get the index range of same property(on both direction).
    + eg. 84.
- Use stack to store the data to be processed, of same property.
    + eg. 94.
- Use of Bit Operators.
    + eg. 89. Add bit 1 to each integer in an array.
        -  `rs.get(k) | 1<<i `
        - `1<<i`  creates a integer that the i th bit is 1 while other bits are 0.
        - `rs.get(k) | 1<<i` makes the integer k's i th bit be 1.
- Handle duplicates.
    + eg. 90. DP idea and DFS idea.
- Convert Tree Problem to Array Problem
    + Binary Search Tree to Sorted Array. eg. 99.
- To judge whether two instance equals to each other, sometimes we have to judge whether one of them is null and the other is not.
    + `a == null && b == null;`
    + `a == null || b == null;` this is the situation that one is null and the other isn't
    + the left situation is `a != null && b != null;`
- When search takes lots of time, use HashMap or if possible binary search.
    + HashMap eg. 1. 105.
- In recursion, if we want to return two values, sometimes we can just take a array(passed by reference) as input, which we can get after return.
    + eg. 105. 110.
    + Sometimes, we can also combine the two values we want to pass.
        - eg. 110, use -1 to represent as false, other value as true.
- (Not That Useful..)When traversing an array, if at the same time, in these loops we need to add items, we can iterate backwards, which avoids endless loop.
    + eg. 89.
    + not that magic actually. If we want to traverse forward, just assign a value to remember the original size. The backward traversing in 89 is aimed to follow the rule of grayCode...
