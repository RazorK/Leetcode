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
