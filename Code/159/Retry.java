import java.util.Set;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null) return 0;
        if(s.length() <= 2) return s.length();

        char [] ss = s.toCharArray();
        
        int left = 0, right = 1;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        map.put(ss[left], 0);
        while(right < ss.length) {
            char cur = ss[right];

            if(map.containsKey(cur)) {
                if(ss[right - 1] != cur) {
                    map.put(cur, right);
                }
                right ++;
                continue;
            }

            if(map.size() >= 2) {
                res = Math.max(res, right - left);
                left = map.get(ss[right - 1]);
                map = new HashMap<>();
                map.put(ss[right - 1], left);
                map.put(cur, right);
            } else if(map.size() < 2) {
                map.put(cur, right);
            }
        
            right ++;
        }

        // the case for the last time
        res = Math.max(res, right - left);
        return res;
    }
}