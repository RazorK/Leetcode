import java.util.*;
class Solution {
    // first idea graph theory
    // time complexity: N^2
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.size() == 0) return 0;

        wordList.add(beginWord);
        //construct graph
        Map<String, Set<String>> map = new HashMap<>();
        for(String str: wordList) {
            map.put(str, new HashSet<>());
        }

        for(int i=0; i<wordList.size()-1; i++) {
            String a = wordList.get(i);
            for(int j=i+1; j<wordList.size(); j++) {
                String b = wordList.get(j);
                if(isOneLetterDiff(a,b)) {
                    map.get(a).add(b);
                    map.get(b).add(a);
                }
            }
        }

        // for(Map.Entry en : map.entrySet()) {
        //     System.out.println(en.getKey() + "," + en.getValue());
        // }

        // bfs find target
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(beginWord);
        queue.add(beginWord);

        int length = queue.size();
        int curLength = 1;
        while(queue.size() != 0) {
            String cur = queue.poll();
            visited.add(cur);

            // BUG 1 use equals() to determine whether two strings are the same
            if(cur.equals(endWord)) return curLength;

            for(String next: map.get(cur)) {
                if(!visited.contains(next)) {
                    queue.add(next);
                }
            }

            if(--length == 0) {
                length = queue.size();
                curLength++;
            }
        }

        return 0;
    }

    public boolean isOneLetterDiff(String a, String b) {
        if(a.length()!=b.length()) return false;

        boolean diff = false;
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i)!=b.charAt(i)) {
                if(diff) return false;
                diff = true;
            }
        }
        return diff;
    }
}