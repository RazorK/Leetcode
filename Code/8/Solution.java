class Solution {
    // case consider:
    //  1. blank
    //  2. plus or minus operator
    //  3. empty String
    //  4. other char in str
    //  5. int.max // min mysolution: each time
    //  6. first char is not +/-/num
    public int myAtoi(String str) {
        str = str.trim();
        char [] array = str.toCharArray();
        if(array.length == 0) return 0;
        long res = 0;
        int start = 0;
        int end = array.length - 1;
        boolean neg = false;
        // BUG: start with +
        // BUG: start with +- ???
        // BUG: what if the first is not + or -
        if(array[start]>'9' || array[start]<'0') {
            char temp = array[start++];
            if(temp == '-') neg = true;
            if(temp != '+' && temp!='-') return 0;
        }
        int h = 1;
        long f_res = 0;
        for(int i=start; i<=end; i++) {
            char temp = array[i];
            if(temp>'9' || temp<'0') return (int)f_res;
            res = res*10 + temp-'0';
            f_res = neg?-res:res;
            if(f_res>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(f_res<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int)f_res;
    }


    // FROM LC
    public int myAtoi(String str) {
       char[] chars = str.trim().toCharArray();
        if (chars.length  == 0 || (!isNumberic(chars[0]) && chars[0] != '+' && chars[0] != '-')) {
            return 0;
        }
        int flag = chars[0] == '-' ? -1 : 1;
        int horne = isNumberic(chars[0]) ? (chars[0] - '0') : 0;

        for (int i = 1; i < chars.length; i++) {
            if (isNumberic(chars[i])) {
                if(Integer.MAX_VALUE/10 < horne || Integer.MAX_VALUE/10 == horne && Integer.MAX_VALUE %10 < (chars[i] - '0'))
                    return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                horne = horne * 10 + (chars[i] - '0');
            } else {
                break;
            }

        }

        return horne * flag;

    }

    public boolean isNumberic(char chr) {
        return chr >= '0' && chr <= '9';
    }
}
