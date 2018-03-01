class Solution {

    // Insipired to use stack by LC
    // IDEA of dp, can only find the longest nested braces.
    // IDEA from lei, use index Stack, same result.
    //  directly store index seems no help for the case ()()
    // IDEA try keep the longest path, also hard to solve this problem.

    // All IDEA above seems won't work for this problem
    //  the reason lies on the problem that we should solve two situations: ((())) && ()()()
    //  and even ( (()) ((())) ), this kind of situation

    // IDEA from LC: use stack to remove all the valid string, and what's left are just the separator
    //  we can use the separator to solve the problem easily.

    // The trick here is we can think in oppesite way. All I think above is try to keep track of
    //  all the valid possibility. But we can solve this easily by tracking all invalid index.

    // TLE !!!??
    public int longestValidParentheses(String s) {
        if(s.length()<=1) return 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char temp = s.charAt(i);
            if(temp == '(' || st.empty()) {
                st.push(i);
                continue;
            }
            if(s.charAt(st.peek()) == '(') {
                st.pop();
                continue;
            }
            st.push(i);
        }
        // after above process, the index remain in stack will be the separator
        if(st.empty()) return s.length();
        int max = 0;
        int larger = s.length();
        int cur = 0;
        while(!st.empty()) {
            cur = st.pop();
            max = Math.max(max, larger - cur - 1);
            larger = cur;
        }
        max = Math.max(max, larger);
        return max;
    }

    // use array to simulate stack..
    public int tryImprove(String s) {
        if(s.length()<=1) return 0;
        int [] st = new int [s.length()];
        int top = 0;
        for(int i=0; i<s.length(); i++) {
            char temp = s.charAt(i);
            if(temp == '(' || top == 0) {
                st[top++] = i;
                continue;
            }
            if(s.charAt(st[top-1]) == '(') {
                top--;
                continue;
            }
            st[top++] = i;
        }
        // after above process, the index remain in stack will be the separator
        if(top == 0) return s.length();
        int max = 0;
        int larger = s.length();
        int cur = 0;
        while(top!=0) {
            cur = st[--top];
            max = Math.max(max, larger - cur - 1);
            larger = cur;
        }
        max = Math.max(max, larger);
        return max;
    }

    // IDEA also from LC, this solution doesn't find all the separator and then calculate the
    //  max, it calculate the max once the separator appears.
    public int newIdea(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
