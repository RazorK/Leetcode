# String
```
//int to String
Integer.toString(i);

//char to String
Character.toString(c);

//String to int
Integer.parseInt(str);

// char Array to String
String.valueOf(charArray);

// String to char Array
char [] charArray = str.toCharArray();

str.charAt()

str.length()

getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)

String are immutable in java, so to change the content of String, we have to
    copy a new one.

// split
str.split(String regularExpression);

// check the string content same or not
str1.equals(str2);

// for char, the operation == is valid.
c1 == c2;

// contains && replace
while (str.contains("//")) {
    str = path.replace("//", "/");
}

// substring.
str.substring(int startIndex);
str.substring(int start, int end); // which will get string from index start to index end - 1.

// all capital characters to lower cases
str = str.toLowerCase();
// suggestion for english
toLowerCase(Locale.English)
```
