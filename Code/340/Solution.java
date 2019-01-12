import java.util.Map;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.isEmpty()) return 0;
        if(k <= 0) return 0;
        // use a map to capture she size
        int left = 0, right = 1;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);
        while(right < s.length()) {
            if(map.size() <= k) {
                // BUG2 we have to put == here, rather than below.. otherwise we may leave out some situations.
                if(map.size() == k) res = Math.max(res, right - left);
                char next = s.charAt(right++);
                map.put(next, map.getOrDefault(next, 0) + 1);
            } else {
                char prev = s.charAt(left++);
                if(map.get(prev) == 1) map.remove(prev);
                else map.put(prev, map.get(prev)-1);
            }
        }
        // BUG1 <=, not < or without judgement
        if(map.size()<=k) res = Math.max(res, right - left);
        return res;
    }
}