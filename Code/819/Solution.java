import java.util.HashMap;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().trim();
        paragraph = paragraph.replaceAll("[^A-Za-z0-9\\s]", "");
        String [] split = paragraph.split(" ");

        Set<String> ban = new HashSet<String>();
        for(String str: banned) {
            ban.add(str);
        }
        Map<String, Integer> map = new HashMap<>();

        for(String str : split) {
            if(ban.contains(str)) continue;
            if(!map.containsKey(str)) map.put(str, 0);
            map.put(str, map.get(str) + 1);
        }

        int max = -1;
        String res = null;
        for(Map.Entry en : map.entrySet()) {
            if((Integer)en.getValue() > max) {
                max = (Integer)en.getValue();
                res = (String)en.getKey();
            }
        }
        return res;
    }
}