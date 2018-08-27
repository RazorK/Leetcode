import java.util.ArrayList;
import java.util.List;

class WordDistance {

    private Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i=0; i<words.length; i++) {
            String cur = words[i];
            if(!map.containsKey(cur)) map.put(cur, new ArrayList<>());
            map.get(cur).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> a = map.get(word1);
        List<Integer> b = map.get(word2);
        
        // two ptrs
        int ptrA = 0, ptrB = 0;
        int min = Integer.MAX_VALUE;
        while(ptrA < a.size() && ptrB < b.size()) {
            int aa = a.get(ptrA);
            int bb = b.get(ptrB);

            min = Math.min(min, Math.abs(aa-bb));

            if(aa>bb) ptrB++; else ptrA++;
        }

        return min;
    }

    public int slow(String word1, String word2) {
        List<Integer> a = map.get(word1);
        List<Integer> b = map.get(word2);
        
        // most stupid n^2 solution
        int min = Integer.MAX_VALUE;
        for(Integer aa: a) {
            for(Integer bb : b) {
                min = Math.min(min, Math.abs(aa-bb));
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */