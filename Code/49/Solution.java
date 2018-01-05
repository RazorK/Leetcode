// Given an array of strings, group anagrams together.
//
// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Return:
//
// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// Note: All inputs will be in lower-case.
import java.util.*;
class Solution {

    // First idea, use hashmap to recognize whether a word is anagram or a new one.

    // BUG 1, can not only use the char-> bool map, the string may contains same char for
    // several times.

    // time exceed..
    public static List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<HashMap<Character, Integer>> mapList = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        for(int i = 0; i< strs.length; i++) {
            boolean found =false;
            for(int j=0; j<mapList.size(); j++) {
                if(match(mapList.get(j), strs[i])){
                    result.get(j).add(strs[i]);
                    found = true;
                    break;
                }
            }
            if(!found) {
                mapList.add(newMap(strs[i]));
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                result.add(temp);
            }
        }
        return result;
    }

    public static boolean match(HashMap<Character, Integer> map, String str) {
        HashMap<Character, Integer> clone = (HashMap<Character, Integer>)map.clone();
        for(int i=0; i< str.length(); i++) {
            char temp = str.charAt(i);
            if(!clone.containsKey(temp)) return false;
            int now = clone.get(temp);
            if(--now == 0) {
                clone.remove(temp);
            } else {
                clone.put(temp, now);
            }
        }
        if(clone.isEmpty()) return true;
        return false;
    }

    public static HashMap<Character, Integer>  newMap(String str) {
        HashMap<Character, Integer> result = new HashMap<>();
        for(int i=0; i< str.length(); i++) {
            char temp = str.charAt(i);
            if(!result.containsKey(temp)) {
                result.put(temp, 1);
            } else {
                result.put(temp, result.get(temp)+1);
            }
        }
        return result;
    }

    // NOTE improve ideas: the input are limited in 26 characters.
    // Firstly count, for each string, change it into a counted ArrayList
    // I think this shoule be similiar with hashmap, try whether this work.

    // still exceed. gj leetcode~
    public static boolean strequ(int [] str1, int [] str2) {
        if(str1.length != str2.length) return false;
        for(int i=0; i<str1.length; i++) {
            if(str1[i]!=str2[i]) return false;
        }
        return true;
    }

    public static int[] getList(String str) {
        int [] result = new int[26];
        for(int i=0; i<str.length();i++) {
            result[(str.charAt(i)-'a')]++;
        }
        return result;
    }

    public static List<List<String>> improve(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int l = strs.length;
        int row = 0;
        int [][] map = new int [l][26];

        for(int i=0; i<strs.length; i++) {
            boolean found = false;
            for(int j=0; j<row; j++) {
                if(strequ(getList(strs[i]), map[j])) {
                    result.get(j).add(strs[i]);
                    found = true;
                    break;
                }
            }
            if(!found) {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                result.add(temp);
                map[row++] = getList(strs[i]);
            }
        }
        return result;
    }


    // Key idea, find a method to build a special key to search for anagram word.
    // choose key, sort or count.

    
    // NOTE we can sort the string by using the Arrays.sort();
    // find through soluton
    public static List<List<String>> solutionBySorting(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            // to array
            char[] ca = s.toCharArray();

            // sort
            Arrays.sort(ca);

            // to string
            String key = String.valueOf(ca);

            // find and insert
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    // NOTE by count
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {

            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            // build key
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();

            // find and insert
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

}
