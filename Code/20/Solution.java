import java.util.*;
class Solution {
    // Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
    // determine if the input string is valid.
    //
    // The brackets must close in the correct order, "()" and "()[]{}" are all valid
    // but "(]" and "([)]" are not.

    // first idea stack
    // NOTE we already know the maximum length of the stack, so we can use array as stack.
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        Stack<Character> st = new Stack<>();
        char [] array = s.toCharArray();
        for(int i=0; i<array.length; i++) {
            char temp = array[i];
            if(temp == '(' || temp == '[' || temp == '{') {
                st.push(temp);
                continue;
            }
            if(st.isEmpty()) return false;
            char back = st.pop();
            // BUG 2 temp and back misplaced.
            if((back == '(' && temp ==')' )||(back == '[' && temp == ']')||(back == '{' && temp == '}'))
                continue;
            return false;
        }
        // BUG 1  forget to check here.
        if(!st.isEmpty()) return false;
        return true;
    }
}
