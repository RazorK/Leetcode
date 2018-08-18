class Solution {
    // Given two strings s and t, determine if they are isomorphic.
    //
    // Two strings are isomorphic if the characters in s can be replaced to get t.
    //
    // All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
    //
    // Example 1:
    //
    // Input: s = "egg", t = "add"
    // Output: true
    // Example 2:
    //
    // Input: s = "foo", t = "bar"
    // Output: false
    // Example 3:
    //
    // Input: s = "paper", t = "title"
    // Output: true
    // Note:
    // You may assume both s and t have the same length.

    // first idea hashmap
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) return false;
        char [] sa = s.toCharArray();
        char [] ta = t.toCharArray();

        Map<Character, Character> map = new HashMap<>();
        // BUG: char in s can't point to same char in t eg: ab -> aa
        Set<Character> set = new HashSet();
        for(int i=0; i<ta.length; i++) {
            char curs = sa[i];
            char curt = ta[i];
            if(map.containsKey(curs)) {
                if(map.get(curs) != curt) return false;
            } else {
                if(set.contains(curt)) return false;
                map.put(curs, curt);
                set.add(curt);
            }
        }

        return true;
    }

    // LC fastest: use char array to replace the hashmap & hashset
}
