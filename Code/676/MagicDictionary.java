import java.util.Set;

class MagicDictionary {

    /** Initialize your data structure here. */
    Set<String> set;
    public MagicDictionary() {
        set = new HashSet<String>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String cur : dict) {
            set.add(cur);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for(int i=0; i<word.length(); i++) {
            for(int j=0; j<26; j++) {
                char cur = (char)('a' +  j);
                if(cur == word.charAt(i)) continue;
                String after = word.substring(0, i) + cur + word.substring(i + 1, word.length());
                if(set.contains(after)) return true;
            }
        }
        return false;
    }
}