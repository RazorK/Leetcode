public class Solution {
    // Given an input string, reverse the string word by word.
    //
    // Example:
    //
    // Input: "the sky is blue",
    // Output: "blue is sky the".
    // Note:
    //
    // A word is defined as a sequence of non-space characters.
    // Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
    // You need to reduce multiple spaces between two words to a single space in the reversed string.
    // Follow up: For C programmers, try to solve it in-place in O(1) space.
    public String reverseWords(String s) {
        s = s.trim();
        char [] cl = s.toCharList();
        // remove extra blank
        // IDEA: this can be improved, we don't need to delete them as preprocess, we can judge when adding.
        boolean f = false;
        StringBuilder sb = StringBuilder();
        for(char c : cl) {
            if(f && c == ' ') continue;
            sb.append(c);
            if(c == ' ') f = true;
            else f = false;
        }
        String [] list = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=list.length-1; i>=0; i--) {
            sb.append(list[i]);
            if(i!=0) sb.append(" ");
        }
        return sb.toString();
    }
}
