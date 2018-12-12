class Solution {
    public int calculate(String s) {
        // first idea recursion
        return helper(s, 0)[0];
    }

    public int[] helper(String s, int start) {
        // the index start must be 0 or left bracket

        int ptr = start;
        int res = 0;
        int num = 0;
        boolean plus = true;

        while(true) {
            if(ptr == s.length() || s.charAt(ptr) == ')') {
                return new int[] {res + (plus ? num : -num), ptr};
            }

            char cur = s.charAt(ptr++);
            if(cur == ' ') continue;
            if(cur == '+' || cur == '-') {
                res += plus ? num : -num;
                plus = cur == '+' ? true : false;
                num = 0;
            } else if(cur >= '0' && cur <= '9') {
                num = num*10 + cur - '0';
            } else if(cur == '(') {
                int [] recur = helper(s, ptr);
                num = recur[0];
                ptr = recur[1] + 1;
            }
        }
    }
}