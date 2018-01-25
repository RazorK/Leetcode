class Solution {
    // Given two words (beginWord and endWord), and a dictionary's word list, find
    // all shortest transformation sequence(s) from beginWord to endWord, such that:
    //
    // Only one letter can be changed at a time
    // Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
    // For example,
    //
    // Given:
    // beginWord = "hit"
    // endWord = "cog"
    // wordList = ["hot","dot","dog","lot","log","cog"]
    // Return
    //   [
    //     ["hit","hot","dot","dog","cog"],
    //     ["hit","hot","lot","log","cog"]
    //   ]
    // Note:
    // Return an empty list if there is no such transformation sequence.
    // All words have the same length.
    // All words contain only lowercase alphabetic characters.
    // You may assume no duplicates in the word list.
    // You may assume beginWord and endWord are non-empty and are not the same.
    // UPDATE (2017/1/20):
    // The wordList parameter had been changed to a list of strings (instead of a set of strings).
    // Please reload the code definition to get the latest changes.

    // first idea stupid dfs
    int max = Integer.MAX_VALUE;
    // the board here contains the property: whether string 1 and string 2 are of distance 1.
    HashMap<String, HashMap<String, Boolearn>> board;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if(wordList.size() == 0) return res;

        board = new HashMap<>();
    }

    public void helper(List<List<String>> res, List<String> leftWord,
    List<String> cur, String word, String target) {
        if(cur.size() > max) return;
        if(word == target) {
            if(cur.size()==max) {
                res.add(cur);
                return;
            }
            res.clear();
            max = res.size();
            res.add(cur);
            return;
        }
        // cur<max, word != target
        for(int i=0; i<leftWord.size(); i++) {
            String temp = leftWord.get(i);
            if(!board.get(word).containsKey(temp)) continue;
            leftWord.remove(i);
            cur.add(temp);
            helper(res, leftWord, cur, temp, target);
            cur.remove(cur.size()-1)
            leftWord.add(i, temp);
        }
    }
}
