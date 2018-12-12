class Solution {
    public String findLongestWord(String s, List<String> d) {
        String max = null;
        for(String t : d) {
            if(isSubsequence(s, t)) {
                if(larger(max, t)) max = t;
            }
        }
        return max == null ? "" : max;
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

    public static boolean larger(String cur, String next) {
        if(cur == null) return true;
        if(next.length() != cur.length()) {
            return next.length() > cur.length();
        } else {
            return next.compareTo(cur) < 0;
        }
    }
}