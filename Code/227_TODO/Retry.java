class Solution {
    public int calculate(String s) {
        // no idea how can I get the TLE in the first solution..
        // try stack
        // idea we don't have to distinguish + - for each number, we can simply store neg num
        int [] st = new int [s.length()];
        int ptr = 0;

        int num = 0;
        char op = '+';

        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if(cur == ' ') continue;
            if(cur>='0' && cur <='9') {
                num = num * 10 + cur - '0';
            } else {
                if(op == '+') {
                    st[ptr ++] = num;
                } else if(op == '-') {
                    st[ptr ++] = -num;
                } else if(op == '*') {
                    st[ptr - 1] *= num;
                } else {
                    st[ptr - 1] = st[ptr-1]/num;
                }

                num = 0;
                op = cur;
            }
        }

        if(op == '+') {
            st[ptr ++] = num;
        } else if(op == '-') {
            st[ptr ++] = -num;
        } else if(op == '*') {
            st[ptr - 1] *= num;
        } else {
            st[ptr - 1] = st[ptr-1]/num;
        }

        int res = 0;
        for(int i=0; i<ptr; i++) {
            res += st[i];
        }
        return res;
    }
}