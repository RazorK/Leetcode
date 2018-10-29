import java.util.Set;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // basic idea two ptrs
        // what's difficult is to caputre how to move the first ptr
        if(s == null) return 0;
        if(s.length() <= 2) return s.length();

        int left = 0, right = 1;
        int split = 0;

        Set<Character> set = new HashSet<>();
        // BUG 2 : remember to add the first judger
        set.add(s.charAt(0));
        int max = -1;

        while(right < s.length()) {
            char cur = s.charAt(right);
            if(!set.contains(cur)) {
                if(set.size() >= 2) {
                    max = Math.max(right - left, max);

                    left = split;
                    set = new HashSet<>();
                    set.add(s.charAt(split));
                    set.add(cur);
                } else {
                    set.add(cur);
                }
            }

            if(cur != s.charAt(split)) {
                split = right;
            }
            right++;
        }
        // BUG 1 : remember to add the last result.
        max = Math.max(right - left , max);
        return max;
    }
}