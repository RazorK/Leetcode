import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ValidWordAbbr {

    Map<String, String> map;
    Set<String> multi;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        multi = new HashSet<>();
        if(dictionary == null || dictionary.length == 0) return;
        Set<String> exist = new HashSet<>();
        for(String cur : dictionary) {
            if(exist.contains(cur)) continue;
            exist.add(cur);
            String ab = getAbbr(cur);
            if(map.containsKey(ab)) multi.add(ab);
            map.put(ab, cur);
        }
    }
    
    public boolean isUnique(String word) {
        String ab = getAbbr(word);
        if(multi.contains(ab)) return false;
        if(!map.containsKey(ab)) return true;
        return map.get(ab).equals(word);
    }

    public String getAbbr(String a) {
        if(a.length()<=2) return a;
        StringBuilder sb = new StringBuilder();
        sb.append(a.charAt(0));
        sb.append(a.length()-2);
        sb.append(a.charAt(a.length()-1));
        return sb.toString();
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */