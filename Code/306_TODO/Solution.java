import java.util.*;

class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() <= 2) return false;
        for(int i=0; i<num.length()/2; i++) {
            int start1 = Integer.parseInt(num.substring(0, i+1));
            for(int j=i+1; j<num.length(); j++) {
                int start2 = Integer.parseInt(num.substring(i+1, j+1));
                if(helper(num, j+1, start1, start2)) return true;
            }
        }
        return false;
    }

    public boolean helper(String num, int index, int pre1, int pre2) {
        if(index == num.length()) return true;
        if(num.charAt(index) == '0') return false;

        int res = pre1 + pre2;
        int len = getDigisNum(res);
        if(index+len+1 > num.length()) return false;
        if(res == Integer.parseInt(num.substring(index, index+len+1))) return helper(num, index+len+1, pre2, res);

        return false;
    }

    public int getDigisNum(int num) {
        if(num<0) return -1;
        int res = 0;
        while(num > 0) {
            num = num/10;
            res++;
        }
        return res;
    }

    public static void main(String [] args) {
        String in = "19910011992";
        System.out.println(new Solution().isAdditiveNumber(in));
    }
}