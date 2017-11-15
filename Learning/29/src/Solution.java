import java.util.ArrayList;

/**
 * Created by aimin on 2017/7/29.
 */
public class Solution {
    public static  void main(String [] args) {
        System.out.println(new Solution().better(1,1));
    }

    //超时。。 叠减
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(divisor==0) return dividend>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
        if(divisor==1) return dividend;
        if(divisor==-1) return dividend==Integer.MIN_VALUE?Integer.MAX_VALUE:-dividend;

        boolean neg = false;
        if((dividend>0&&divisor<0)||(dividend<0&&divisor>0)) neg = true;

        //坑。。  Math.abs(Integer.MIN_VALUE) = Integer.MIN_VALUE
        dividend = dividend==Integer.MIN_VALUE?Integer.MAX_VALUE:Math.abs(dividend);
        divisor = Math.abs(divisor);
        int temp = dividend;
        int res = -1;
        while (temp>=0){
            if(neg&&res==Integer.MAX_VALUE) return Integer.MIN_VALUE;
            res++;
            temp-=divisor;
        }

        return neg? -res:res;
    }

    /**
     * 这里看了看网上的算法主要有两种，一是累加法x,2x,4x,8x,…… 如此累加
     * 还有一种魔方数的计算方法
     * 还是超时。。。
     * @param dividend
     * @param divisor
     * @return
     */
    public int better(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(divisor==0) return dividend>0?Integer.MAX_VALUE:Integer.MIN_VALUE;

        boolean neg = false;
        if((dividend>0&&divisor<0)||(dividend<0&&divisor>0)) neg = true;
        dividend = dividend==Integer.MIN_VALUE?Integer.MAX_VALUE:Math.abs(dividend);
        divisor = divisor==Integer.MIN_VALUE?Integer.MAX_VALUE:Math.abs(divisor);

        int temp = divisor;
        int temp2 = 1;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> listof2 = new ArrayList<>();
        while(temp<=dividend) {
            list.add(temp);
            listof2.add(temp2);
            temp += temp;
            temp2 +=temp2;
        }

        int dtemp = dividend;
        int result = 0;
        for(int i=list.size()-1;i>=0;i--) {
            if(dtemp>=list.get(i)) {
                dtemp = dtemp-list.get(i);
                result+=listof2.get(i);
                if(neg&&result==Integer.MAX_VALUE) return Integer.MIN_VALUE;
            }
        }
        return neg?-result:result;
    }

    //用long来代替unsigned int 避免越界
    public int suggested(int dividend, int divisor) {
        //Reduce the problem to positive long integer to make it easier.
        //Use long to avoid integer overflow cases.
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        //Take care the edge cases.
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor))	return 0;

        long lans = ldivide(ldividend, ldivisor);

        int ans;
        if (lans > Integer.MAX_VALUE){ //Handle overflow.
            ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum+sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
