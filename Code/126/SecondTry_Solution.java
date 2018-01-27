import java.util.*;
class SecondTry_Solution {
    // still TLE
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
        HashMap<String, Boolean> left = new HashMap<>();
        for(String str:wordList) {
            left.put(str, true);
        }
        List<String> cur = new ArrayList<>();
        cur.add(beginWord);
        helper(res, left, cur, beginWord, endWord);
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

    public void helper(List<List<String>> res, HashMap<String, Boolean> leftWord,
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
        for(String next:board.get(word).keySet()) {
            if(!leftWord.containsKey(next)) continue;
            leftWord.remove(next);
            cur.add(next);
            helper(res, leftWord,cur,next, target);
            cur.remove(cur.size()-1);
            leftWord.put(next, true);
        }
    }
}
