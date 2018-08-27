import java.util.*;

class Solution {

    // spead some time to figure out to use topological sort
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";

        // dag construct
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> in = new HashMap<>();

        for(String word: words) {
            for(int i=0; i<word.length(); i++) {
                char cur = word.charAt(i);
                if(!in.containsKey(cur)) {
                    in.put(cur, 0);
                    map.put(cur, new HashSet<>());
                }
            }
        }

        // add restriction
        // intra word
        // for(String word: words) {
        //     char [] temp = word.toCharArray();
        //     for(int i=0; i<temp.length-1; i++) {
        //         char cur = temp[i];
        //         char next = temp[i+1];
        //         if(!map.containsKey(cur)) map.put(cur, new HashSet<>());
        //         if(cur!=next) map.get(cur).add(next);
        //     }
        // }

        //inter word
        for(int i=0; i<words.length-1; i++) {
            String cur = words[i];
            String next = words[i+1];
            for(int j=0; j<cur.length(); j++) {
                if(!map.containsKey(cur.charAt(j))) {
                    map.put(cur.charAt(j), new HashSet<>());
                }
                if(!map.containsKey(next.charAt(j))) {
                    map.put(next.charAt(j), new HashSet<>());
                }
                if(cur.charAt(j) == next.charAt(j)) continue;
                if(cur.charAt(j)!=next.charAt(j)) {
                    map.get(cur.charAt(j)).add(next.charAt(j));
                }
                break;
            }
        }

        // for(Map.Entry en: map.entrySet()) {
        //     System.out.println(en.getKey() + "," + en.getValue().toString());
        // }

        // for(Map.Entry en: in.entrySet()) {
        //     System.out.println(en.getKey() + "," + en.getValue());
        // }

        // build in
        for(Map.Entry en: map.entrySet()) {
            char c = (char)en.getKey();
            Set<Character> set = (Set<Character>)en.getValue();
            // if(!in.containsKey(c)) in.put(c, 0);

            for(char next: set) {
                if(!in.containsKey(next)) in.put(next, 0);
                in.put(next, in.get(next) + 1);
            }
        }


        // topological sort
        StringBuilder sb = new StringBuilder();
        while(in.size()>0) {
            boolean flag = false;
            Map<Character, Integer> nextIn = new HashMap<>(in);
            for(Map.Entry en: in.entrySet()) {
                if((int)en.getValue() == 0) {
                    flag = true;

                    sb.append(en.getKey());
                    nextIn.remove(en.getKey());

                    for(Character con: map.get(en.getKey())) {
                        nextIn.put(con, nextIn.get(con)-1);
                    }
                }
            }
            in = nextIn;
            if(!flag) return "";
            // printIn(in);
        }
        return sb.toString();
    }

    public void printIn(Map<Character, Integer> in) {
        System.out.println("Print In");
        for(Map.Entry en: in.entrySet()) {
            System.out.println(en.getKey() + "," + en.getValue());
        }
    }

    public static void main(String [] args) {
        String [] words = {"ab", "adc"};
        String res = new Solution().alienOrder(words);
        System.out.println(res);
    }
}