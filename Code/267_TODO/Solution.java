class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if(s== null || s.length() == 0) return res;
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if(!map.containsKey(cur)) map.put(cur, 1);
            else {
                map.put(cur, map.get(cur) + 1);
            }
        }

        // find odd
        char oddKey = null;
        for(Map.Entry en : map.entrySet()) {
            if(en.getValue()%2 == 1) {
                if(oddKey != null) return res;
                oddKey = en.getKey();
            }
        }
        
        map.put(oddKey, map.get(oddKey) - 1);
        
        char [] ca = new char [s.length()];
        int cur = s.length()/2;
        if(s.length() %2 == 1) {
            ca[s.length()/2] = oddKey;  
            cur++;
        }

        //dfs, coule be slow
    }

    public void dfs(Map<Character, Integer> map, char [] ca, int index) {
        
    }
}