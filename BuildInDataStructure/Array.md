# arrays
```
// length
int l = array.length;

// sort
Arrays.sort(list);

//init 2-d Arrays
//all integer arrays are init 0.
int [][] list = new int [][] {
  {1,2,3},
  {4,5,6}
}

////坑， 如果要使用， 传入的不能是基本类型array
// 而且返回的array list 不能进行增删操作
// java.lang.UnsupportedOperationException.
Arrays.asList()

// fill an array with value
Arrays.fill(array, -1);

//  create a generic array in Java?
ArrayList<Integer>[] group = (ArrayList<Integer>[])new ArrayList[length];
List<Integer>[][] dp = new List[n+2][n+2];

// multi dimention integer array, initialized with 0 rather than nullbnm,
// int this example, a := [[0,0],[0,0]]
int [][] a = new int [2][2];
```
