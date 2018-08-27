class Solution {
    // Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

    // "abc" -> "bcd" -> ... -> "xyz"
    // Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
    
    // Example:
    
    // Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
    // Output: 
    // [
    //   ["abc","bcd","xyz"],
    //   ["az","ba"],
    //   ["acef"],
    //   ["a","z"]
    // ]
    public List<List<String>> groupStrings(String[] strings) {
        if(strings == null || strings.length == 0) return new ArrayList<List<String>>();

        Map<String, List<String>> res = new HashMap<>();

        for(String str: strings) {
            String trans = transform(str);
            if(!res.containsKey(trans)) res.put(trans, new ArrayList<String>());
            res.get(trans).add(str);
        }

        return new ArrayList<List<String>>(res.values());
    }

    public String transform(String str) {
        if(str == null || str.length() == 0) return null;
        char [] ca = str.toCharArray();

        char min = (char)(ca[0] - 'a');
        
        for(int i=0; i<ca.length; i++) {
            ca[i] = (char)((ca[i] - (min - 'a'))%26);
        }
        
        return String.copyValueOf(ca);
    }
}