class Solution {
    // Given two strings s and t, write a function to determine if t is an anagram of s.
    //
    // For example,
    // s = "anagram", t = "nagaram", return true.
    // s = "rat", t = "car", return false.
    //
    // Note:
    // You may assume the string contains only lowercase alphabets.
    //
    // Follow up:
    // What if the inputs contain unicode characters? How would you adapt your solution to such case?

    // Answer to Follow up: use hashmap or expand the size of array to 256
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int [] board = new int[26];
        for(int i=0; i<s.length(); i++) {
            board[s.charAt(i)-'a']++;
        }
        for(int i=0; i<t.length(); i++)
            // NOTE: improve from LC
            //  we can add a judge here, if board[i]<0 return false;
            //  because if there are some number larger than 0 finally, there will also be negative number.
            //  so we can remove the following check loop if we check here.
            board[t.charAt(i)-'a']--;
        for(int i=0; i<26; i++) {
            if(board[i]!=0) return false;
        }
        return true;
    }
}
