class Solution {
    // Implement a basic calculator to evaluate a simple expression string.
    //
    // The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
    //
    // Example 1:
    //
    // Input: "3+2*2"
    // Output: 7
    // Example 2:
    //
    // Input: " 3/2 "
    // Output: 1
    // Example 3:
    //
    // Input: " 3+5 / 2 "
    // Output: 5
    // Note:
    //
    // You may assume that the given expression is always valid.
    // Do not use the eval built-in library function.
    public static int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        int num = 0;
        int store = 1;

        // 0 for +, 1 for -
        int op1 = 0;
        // 0 for *, 1 for /
        int op2 = -1;

        int ptr = 0;
        while(ptr < s.length()) {
            char cur = s.charAt(ptr);
            if(cur == ' ') continue;
            if(cur >= '0' && cur <= '9') {
                num = num*10 + cur - '0';
            } else {

                if(op2 != -1) {
                    num = op2 == 0 ? num * store : store / num;
                    store = 1;
                    op2 = -1;
                }

                if(cur == '+' || cur == '-') {
                    res = op1 == 0? num + res : res - num;
                    op1 = cur == '+' ? 0 : 1;
                } else if(cur == '*' || cur == '/') {
                    op2 = cur == '*' ? 0 : 1;
                    store = num;
                }
                num = 0;
            }
            ptr++;
        }

        if(op2 != -1) {
            num = op2 == 0 ? num * store : store / num;
        }

        res = op1 == 0? num + res : res - num;
        
        return res;
    }

    public static void main(String [] args) {
        System.out.println(calculate("3/2"));
    }
}
