class Solution {
    // Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    //
    // For example,
    // "A man, a plan, a canal: Panama" is a palindrome.
    // "race a car" is not a palindrome.
    //
    // Note:
    // Have you consider that the string might be empty? This is a good question to ask during an interview.
    //
    // For the purpose of this problem, we define empty string as valid palindrome.

    // NOTE: alphanumeric: means alphabetical and numerical
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] array = s.toCharArray();
        int low = 0, high = s.length()-1;
        while(low<high) {
            char l = array[low];
            char h = array[high];
            // NOTE Idea here, we may also change this if statement to while statement
            // NOTE not sure which one is better, but this one seems more simple.
            if(!((l>='a' && l<='z') || (l>='0' && l<='9'))) {
                low ++;
                continue;
            }
            if(!((h>='a' && h<='z')||(h>='0' && h<='9'))) {
                high --;
                continue;
            }
            if(l == h) {
                low ++;
                high--;
                continue;
            }
            return false;
        }
        return true;
    }
}
