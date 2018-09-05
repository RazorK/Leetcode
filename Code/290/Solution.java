import java.util.Map;
import java.util.Set;

class Solution {
    public boolean wordPattern(String pattern, String str) {

        // BUG1
        // notice the given example: it must be one to one relation, not anything else
        char [] p = pattern.toCharArray();
        String [] strs = str.split(" ");

        if(p.length != strs.length) return false;
        Map<Character, String> map = new HashMap<>();
        Set<String> visited = new HashSet<>();

        for(int i=0; i<p.length; i++) {
            char cur = p[i];
            String curs = strs[i];
            if(!map.containsKey(cur)) {
                if(visited.contains(curs)) return false;
                map.put(cur, curs);
                visited.add(curs);
            } else {
                if(!curs.equals(map.get(cur))) return false;
            }
        }
        return true;
    }
}