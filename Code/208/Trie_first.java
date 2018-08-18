class Trie {

    private HashMap<Character, Trie> map;
    private boolean end;

    /** Initialize your data structure here. */
    public Trie() {
        this.map = new HashMap<>();
        this.end = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.equals("")) {
            this.end = true;
            return;
        }
        char cur = word.charAt(0);
        String next = word.substring(1);
        if(this.map.containsKey(cur)) {
            this.map.get(cur).insert(next);
        } else {
            Trie temp = new Trie();
            temp.insert(next);
            this.map.put(cur, temp);
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word.equals("")) {
            return this.end == true;
        }
        if(this.map.containsKey(word.charAt(0))) {
            return this.map.get(word.charAt(0)).search(word.substring(1));
        } else {
            return false;
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix.equals("")) return true;
        if(this.map.containsKey(prefix.charAt(0))) {
            return this.map.get(prefix.charAt(0)).startsWith(prefix.substring(1));
        } else {
            return false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
