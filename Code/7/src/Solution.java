/**
 * Spot： StringBuilder.reverse,Integer.MAX_VALUE&& Integer.MIN_VALUE
 * 我的解法： 使用字符串的翻转来实现，StringBuilder 的reverse函数可以实现
 * 问题： 首先没有检测翻转过后有没有超出界限
 * 优解： 从个位依次处理，超出界限或处理完毕返回
 * Created by aimin on 2017/7/15.
 */
public class Solution {
    public int reverse(int x) {
        String s = String.valueOf(x);
        String num = s;
        boolean flag = true;
        if(s.charAt(0)=='-'){
            num = s.substring(1);
            flag = false;
        }

        StringBuilder sb = new StringBuilder(num).reverse();

        int i;
        try{
            i = Integer.parseInt(sb.toString());
        } catch (java.lang.NumberFormatException e){
            return 0;
        }
        if(!flag) i = -i;
        return i;
    }

    public int suggested(int x){
        double result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int)result;
    }
}
