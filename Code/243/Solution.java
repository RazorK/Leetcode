class Solution {

    // BUG 1 should ask whether there are duplicates
    public int shortestDistance(String[] words, String word1, String word2) {
        if(words == null || words.length == 0) return 0;
        String preWord = null;
        int min = Integer.MAX_VALUE;
        int pre = 0;
        for(int i=0; i<words.length; i++) {
            String cur =  words[i];
            
            // init
            if(cur.equals(word1) || cur.equals(word2)) {
                if(preWord == null) {
                    preWord = cur;
                    pre = i;
                } else if(preWord.equals(cur)) {
                    pre = i;
                } else {
                    min = Math.min(min, i - pre);
                    preWord = cur;
                    pre =  i;
                }
            }
        }

        return min;
    }
}