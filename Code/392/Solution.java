class Solution {
    public boolean isSubsequence(String s, String t) {
        int tp = 0, sp = 0;
        while(sp < s.length()) {
            char cur = s.charAt(sp);
            if(tp >= t.length()) return false;
            if(t.charAt(tp) == cur) {
                sp++;
            }
            tp++;
        }
        return true;
    }
}