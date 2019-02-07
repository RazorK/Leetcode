import java.util.*;
class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        if(s.length() == 0 || words.length == 0) return new ArrayList<>();
        // n^2 idea
        int wl = words[0].length();
        int tl = wl * words.length;

        if(s.length() < tl) return new ArrayList<>();

        // generate word map
        Map<String, Integer> map = new HashMap<>();
        for(String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0; i+tl<=s.length(); i++) {
            // System.out.println(i);
            if(check(s, i, map, words.length, wl)) res.add(i);
        }
        return res;
    }

    // maybe dp is useful..
    public boolean check(String s, int start, Map<String, Integer> words, int wn, int wl) {
        words = new HashMap<>(words);
        for(int i=0; i<wn; i++) {
            String cur = s.substring(start + i*wl, start + i*wl + wl);
            if(!words.containsKey(cur) || words.get(cur) <= 0) return false;
            words.put(cur, words.get(cur) - 1);
        }
        return true;
    }
}