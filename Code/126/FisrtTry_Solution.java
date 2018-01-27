import java.util.*;
class FisrtTry_Solution {
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
    // TLE
    int max = Integer.MAX_VALUE;
    // the board here contains the property: whether string 1 and string 2 are of distance 1.
    HashMap<String, HashMap<String, Boolean>> board;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if(wordList.size() == 0) return res;
        // construct the board.
        board = new HashMap<String, HashMap<String, Boolean>>();
        for(int i=0; i<wordList.size(); i++) {
            String t1;
            if(i==wordList.size()-1) {
                i = -1;
                t1 = beginWord;
            } else {
                t1 = wordList.get(i);
            }
            for(int j=i+1; j<wordList.size(); j++) {
                String t2 = wordList.get(j);
                if(!board.containsKey(t1)) board.put(t1, new HashMap<String, Boolean>());
                if(!board.containsKey(t2)) board.put(t2, new HashMap<String, Boolean>());
                if(disOne(t1, t2)) {
                    board.get(t1).put(t2, true);
                    board.get(t2).put(t1, true);
                }
            }
            if(i==-1) break;
        }
        List<String> cur = new ArrayList<>();
        cur.add(beginWord);
        helper(res, wordList, cur, beginWord, endWord);
        return res;
    }

    public boolean disOne(String a, String b) {
        int count = 0;
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                count++;
                if(count>1) return false;
            }
        }
        if(count == 1) return true;
        return false;
    }

    public void helper(List<List<String>> res, List<String> leftWord,
    List<String> cur, String word, String target) {
        if(cur.size() > max) return;
        if(word.equals(target)) {
            if(cur.size()==max) {
                res.add(new ArrayList<String>(cur));
                return;
            }
            res.clear();
            max = cur.size();
            // BUG again, insert the clone !
            res.add(new ArrayList<String>(cur));
            return;
        }
        // cur<max, word != target
        for(int i=0; i<leftWord.size(); i++) {
            String temp = leftWord.get(i);
            if(!board.get(word).containsKey(temp)) continue;
            leftWord.remove(i);
            cur.add(temp);
            helper(res, leftWord, cur, temp, target);
            cur.remove(cur.size()-1);
            leftWord.add(i, temp);
        }
    }
}
