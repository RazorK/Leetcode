class WordDictionary {

    /** Initialize your data structure here. */
    TrieNode t;
    public WordDictionary() {
        t = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode it = t;
        for(int i=0; i<word.length(); i++)  {
            int cur = word.charAt(i) - 'a';
            if(it.next[cur] == null) it.next[cur] = new TrieNode();
            it = it.next[cur];
            if(i == word.length() - 1) it.exist = true;
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(t, word, 0);
    }

    public boolean search(TrieNode t, String word, int index) {
        if(t == null) return false;
        if(index == word.length()) return t.exist;
        char cur = word.charAt(index);
        if(cur == '.') {
            for(int i=0; i<26; i++) {
                if(search(t.next[i], word, index+1)) return true;
            }
            return false;
        } else {
            return search(t.next[cur - 'a'], word, index+1);
        }
    }

    public class TrieNode {
        boolean exist;
        TrieNode [] next;

        public TrieNode() {
            next=  new TrieNode[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */