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
- Use of Bit Operators.
    + eg. 89. Add bit 1 to each integer in an array.
        -  `rs.get(k) | 1<<i `
        - `1<<i`  creates a integer that the i th bit is 1 while other bits are 0.
        - `rs.get(k) | 1<<i` makes the integer k's i th bit be 1.
- Handle duplicates.
    + eg. 90. DP idea and DFS idea.
- (Not That Useful..)When traversing an array, if at the same time, in these loops we need to add items, we can iterate backwards, which avoids endless loop.
    + eg. 89.
    + not that magic actually. If we want to traverse forward, just assign a value to remember the original size. The backward traversing in 89 is aimed to follow the rule of grayCode...
