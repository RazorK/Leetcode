import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class AutocompleteSystem {

    public AutocompleteSystem(String[] sentences, int[] times) {
        
    }
    
    public List<String> input(char c) {
        
    }

    public class TrieNode{
        boolean exist;
        TrieNode [] next;
        Map<String, Integer> count;
        public TrieNode() {
            next = new TrieNode[256];
            count = new HashMap<>();
        }
    }

    public List<String> findMost3(Map<String, Integer> count) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(count.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> l, Map.Entry<String, Integer> r) {
                return r.getValue() - l.getValue();
            }
        });
        List<String> res =  new ArrayList<>();
        for(int i=0; i<3; i++) {
            res.add(list.get(i).getKey());
        }
        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */