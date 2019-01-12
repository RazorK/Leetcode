
class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {

        // trick from LC: we don't really need the map, we can use a set and combine two word as the key for set. like w1#w2
        if(words1.length != words2.length) return false;
        // create map
        Map<String, Set<String>> p = new HashMap<>();
        for(String [] pair : pairs) {
            p.computeIfAbsent(pair[0], (k) -> new HashSet<>()).add(pair[1]);
            p.computeIfAbsent(pair[1], (k) -> new HashSet<>()).add(pair[0]);
        }

        for(int i=0; i<words1.length; i++) {
            if(words1[i].equals(words2[i]) || (p.containsKey(words1[i]) && p.get(words1[i]).contains(words2[i]))) continue;
            return false;
        }
        return true;
    }
}