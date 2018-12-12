class Solution {

    public int secondTry(String s) {
        int [] map = new int [26];
        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if(map[cur-'a'] == 0) map[cur-'a'] = i+1;
            else map[cur-'a'] = -1;
        }

        int res = Integer.MAX_VALUE;
        for(int i=0; i<26; i++) {
            int cur = map[i];
            if(cur != -1 && cur != 0) res = Math.min(cur-1, res);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // first idea
    public int firstTry(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if(map.containsKey(cur))  map.put(cur, -1);
            else map.put(cur, i);
        }
        
        for(int i : map.values()) {
            if(i != -1) return i;
        }
        
        return -1;
    }
}