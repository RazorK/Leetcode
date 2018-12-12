# Arrays
```
Arrays.sort(int [] a);

<T> List<T> asList(T... a);

// toString
Arrays.toString(a);

// multi-dimention array toString
Arrays.deepToString(a);

// array copy
System.arraycopy( src, 0, dest, 0, src.length );
Arrays.copyOfRange(Object[] src, int from, int to);
Arrays.copyOf(Object [] src, int length);

boolean b = Arrays.equals(Object[] a, Object[] a2);

// sort
Arrays.sort(intervals, new Comparator<Interval>() {
    @Override
    public int compare(Interval left, Interval right) {
        return left.start - right.start;
    }
});


Arrays.binarySearch(int [] num, int target);
//implementation:
// meaning: if key is in the array, return the index, or return -(i+1), i stands for the correct insertion index
private static int binarySearch0(long[] a, int fromIndex, int toIndex,
                                    long key) {
    int low = fromIndex;
    int high = toIndex - 1;

    // key1: less or equal
    while (low <= high) {
        int mid = (low + high) >>> 1;
        long midVal = a[mid];

        if (midVal < key)
            low = mid + 1;
        else if (midVal > key)
            high = mid - 1;
        else
            return mid; // key found
    }

    // key2: return low index
    return -(low + 1);  // key not found.
}
```
