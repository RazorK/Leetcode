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
Arrays.copyOfRange(Object[] src, int from, int to)

boolean b = Arrays.equals(Object[] a, Object[] a2);

// sort
Arrays.sort(intervals, new Comparator<Interval>() {
    @Override
    public int compare(Interval left, Interval right) {
        return left.start - right.start;
    }
});
```
