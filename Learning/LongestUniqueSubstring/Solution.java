import java.util.*;

public class Solution {
    public static int secondTry(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        char [] ca = s.toCharArray();
        int max = Integer.MIN_VALUE;
        int length = 0;
        for(int i=0; i<ca.length; i++) {
            char cur = ca[i];
            if(map.containsKey(cur)) {
                length = Math.min(i, i - map.get(cur));
                max = Math.max(max, length);
            }
            else{
                length++;
            }
            map.put(cur, i);
        }
        return 0;
    }

    public static int longestUniqueSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        char [] ca = s.toCharArray();
        int max = Integer.MIN_VALUE;
        int length = 0;
        for(int i=0; i<ca.length; i++) {
            char cur = ca[i];
            if(map.containsKey(cur)) {
                length = Math.min(length+1, i-map.get(cur));
            } else {
                length++;
            }
            map.put(cur, i);
            max = Math.max(max, length);
        }
        return max;
    }

    public static void main(String [] args) {
        System.out.println(longestUniqueSubstring("a"));
    }
}
