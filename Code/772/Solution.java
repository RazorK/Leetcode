class Solution {
    public int calculate(String s) {
        // try idea with recursive(parentheses) and stack mul/div
        if(s == null || s.length() == 0) return 0;
        return cal(s, 0)[0];
    }

    public int [] cal(String s, int start) {
        Stack<Integer> st = new Stack<>();

        int num = 0;
        char op = '+';
        int ptr = start;
        for(; ptr < s.length() && s.charAt(ptr) != ')'; ptr++) {
            char cur = s.charAt(ptr);
            if(cur == ' ') continue;

            if(Character.isDigit(cur)) {
                num = num * 10 + cur - '0';
            } else if(cur == '(') {
                int [] next = cal(s, ptr + 1);
                num = next[0];
                ptr = next[1];
            } else {
                // + - * /
                if(op == '+') {
                    st.push(num);
                } else if(op == '-') {
                    st.push(-num);
                } else if(op == '*') {
                    st.push(st.pop() * num);
                } else if(op == '/') {
                    st.push(st.pop() / num);
                }

                op = cur;
                num = 0;
            }
        }
        // System.out.println(start + "," + num + "," + op);
        if(op == '+') {
            st.push(num);
        } else if(op == '-') {
            st.push(-num);
        } else if(op == '*') {
            st.push(st.pop() * num);
        } else if(op == '/') {
            st.push(st.pop() / num);
        }

        int res = 0;
        while(!st.isEmpty()) {
            res+= st.pop();
        }
        // System.out.println(res + "," + ptr);
        return new int [] {res, ptr};
    }
}