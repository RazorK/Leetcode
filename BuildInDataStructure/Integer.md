# Integer
```
Integer.MAX_VALUE 2147483647
Integer.MIN_VALUE -2147483648
Integer.SIZE
Integer.TYPE

// Long TYPE
Long.MAX_VALUE
Long.MIN_VALUE

// get binary string
Integer.toBinaryString(i);

// null value
Integer a = null; // right, can be used by default value.
int a = null; // wrong

// init
Integer a;
System.out.println(a); // cause init error, but assign null will eliminate the error.

// equals
Integer a,b;
...
// these two methods has same result.
boolean bl = a == b;
boolean bl = a.equals(b);
```
