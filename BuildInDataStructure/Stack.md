# Stack

### Faster Stack.
The Stack class turn out to be very slow according to the LC.
So here are stack implemented by array and it's corresponding function.

** con : Have to know the max length of Stack **
```
// init
int [] st = new int[maxLength];
int ptr = 0;

//check empty
ptr == 0;

// peek()
// also have to check empty first
st[ptr - 1];

// pop()
// also have to check empty first
st[--ptr];

// push()
st[ptr++] = e;

// size
ptr;
```



### The build in stack type and it's function.
```
// inherit from java.util.Vector.

// check empty
boolean b = stk.empty();
// the latter is inherited from Vector.
boolean b = stk.isEmpty();

// look at the top of stack, without removing
// if empty, error, so check empty first
E e = stk.peek();

// push
stk.push(e);

// pop, remove and get the item
// if empty, error, so check empty first
E e = stk.pop();

// size
int s = stk.size();
```
