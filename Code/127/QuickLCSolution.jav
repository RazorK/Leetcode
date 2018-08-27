public class Solution {

    // quicker because it direct check all the possible next, but not find all the next words.
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> reached = new HashSet<String>();
        Set<String> wordDict = new HashSet<String>(wordList);
        reached.add(beginWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return distance;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        if (!wordDict.contains(endWord)) return 0;
       
        Set<String> visited = new HashSet<>();      // avoid repeated word or loop
        Set<String> beginS = new HashSet<>();
        Set<String> endS = new HashSet<>();
        beginS.add(beginWord);
        endS.add(endWord);
        
        int count = 1;
        
        while( !beginS.isEmpty()) {
            count++;
            Set<String> tmpS = new HashSet<>();
            for (String bW : beginS) {
                char[] bwCh = bW.toCharArray();
                for (int i = 0; i < bwCh.length; i++) {
                    char saveCh = bwCh[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        bwCh[i] = c;
                        String newWord = new String(bwCh);
                        if (!wordDict.contains(newWord)) continue;
                        if (endS.contains(newWord)) return count;
                        if (visited.add(newWord)) {
                            tmpS.add(newWord);
                        }
                    }
                    bwCh[i] = saveCh;   // character before changed
                }                
            }
            
            beginS = tmpS;
            // Swap set if beginSet have greater size than endSet to reduce time to compare
            if (endS.size() < beginS.size()) {
                tmpS = endS;
                endS = beginS;
                beginS = tmpS;
            }
        }
        return 0;
    }
}