class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        boolean neg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        long up = Math.abs((long)dividend), down = Math.abs((long)divisor);
        long res = 0;
        while(up >= down) {
            res++;
            if(!neg && res == Integer.MAX_VALUE) return (int)res;
            if(neg && res == -(long)Integer.MIN_VALUE) return Integer.MIN_VALUE;
            up -= down;
        }
        return (int)(neg ? -res: res);
    }
}