import java.util.*;
class Solution {
    // QUESTION1: length
    // QUESTION2: duplicate
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return null;
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            String uni = uni(str);
            if(!map.containsKey(uni)) {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(uni, temp);
            } else {
                map.get(uni).add(str);
            }
        }
        return (List) (new ArrayList<List<String>>(map.values()));
    }

    public String uni(String str) {
        char [] ca = str.toCharArray();
        Arrays.sort(ca);
        return String.copyValueOf(ca);
    }

    // from LC
    // solve the problem to tranform string to int
    // New idea. We can not use base in this problem, we want to uniquely represent each combination of chars. We can use prime to solve this problem
    // may have int.max_value overflow problem
    public static List<List<String>> what(String[] strs) { 
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> t;
            if (map.containsKey(key)) {
                t = res.get(map.get(key));
            } else {
                t = new ArrayList<>();
                res.add(t);
                map.put(key, res.size() - 1);
            }
            t.add(s);
        }
        return res;
}
}