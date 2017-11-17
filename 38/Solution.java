import java.util.*;

// not difficult;
// but pay attention to some points:
// 1. input 1 means directly return, not input 0
// 2. difference between String, StringBuffer, StringBuilder
// 3. when the inner loop end, remember to add the last result to the StringBuilder
// 4. in inner loop, use StringBuilder, and after the loop replace the origin string with the StringBuilder

class Solution {
	public static String countAndSay(int n) {
		if(n==1) return "1";
		String str = "1";
		//iteration for n
		for(int i=1; i<n; i++) {
			StringBuilder sb = new StringBuilder();
			int count = 0;
			//System.out.println(str);
			char c = str.charAt(0);
			for(int j=0; j<str.length(); j++) {
				//System.out.println(str.charAt(j));
				if(str.charAt(j) != c) {
					sb.append(Integer.toString(count)+Character.toString(c));
					count = 1;
					c = str.charAt(j);
					continue;
				}
				count++;
				c = str.charAt(j);
			}
			sb.append(Integer.toString(count)+Character.toString(c));
			str = sb.toString();
			//System.out.println("output"+str);
		}
		return str;
	}
}
