import java.util.*;

class Solution {

    // first idea sort d, and judege whether each str in d is subsequence of s
    // time complexity nlogn * l, space: constant
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String f, String s) {
                if(f.length() != s.length()) {
                    return s.length() - f.length();
                } else {
                    return f.compareTo(s);
                }
            }
        });

        for(String t : d) {
            if(isSubsequence(s, t)) return t;
        }
        
        return "";
    }

    public static boolean isSubsequence(String s, String t) {
        int p1 = 0, p2 = 0;
        while(p2 < t.length()) {
            if(p1 >= s.length()) return false;
            if(s.charAt(p1++) == t.charAt(p2)) {
                p2 ++;
            }
        }
        return true;
    }

    public static void main(String [] args) {
        System.out.println(isSubsequence("abpcplea", "apple"));
    }
}