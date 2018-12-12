class MagicDictionary {

    // IDEA from LC, constant time search

    // used to store the original string
    Set<String> strs;
    Map<String, Integer> count;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        strs = new HashSet<>();
        count = new HashMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String cur : dict) {
            for(int i=0; i<cur.length(); i++) {
                String tar = cur.substring(0, i) + '*' + cur.substring(i+1, cur.length());
                count.put(tar, count.getOrDefault(tar, 0) + 1);
            }
            strs.add(cur);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for(int i=0; i<word.length(); i++) {
            String tar = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
            if(!count.containsKey(tar)) continue;
            if(count.get(tar) >= 2) return true;
            if(!strs.contains(word)) return true;
        }
        return false;
    }
}