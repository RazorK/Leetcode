class Solution {
    // All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
    //
    // Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
    //
    // Example:
    //
    // Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    //
    // Output: ["AAAAACCCCC", "CCCCCAAAAA"]

    // Idea, transform to integer and compare?
    public List<String> findRepeatedDnaSequences(String s) {
        char [] ca = s.toCharArray();
        if(s.length()<=10) return new ArrayList<String>();
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for(int i=0; i<=s.length()-10; i++) {
            String cur = s.substring(i, i+10);
            if(set.contains(cur)) {
                res.add(cur);
            } else {
                set.add(cur);
            }
        }

        return new ArrayList<String>(res);
    }
}
