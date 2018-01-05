import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * 带符号+, 带符号+-？？？？
 * 排除空格和首位0
 * 若出现多个符号则返回0
 * 处理数字时出现其他字符，则按字符前的数字返回
 * 首位数字出现后
 *
 * !!trim()直接去除空格
 *
 * 从前向后组合整数时，num*10+val， 判断使用Max/10来判断
 *
 * int 范围 负范围绝对值比正范围绝对值大一
 * Created by aimin on 2017/7/15.
 */
public class Solution {
    public int myAtoi(String str) {
        if(str.equals("")) return 0;
        boolean neg = false;
        double result = 0;

        //char c = str.charAt(0);
        boolean sign=false;

        while(str.length()>=1){
            char c = str.charAt(0);

            if(c=='+'){
                if(str.length()==1||sign) return 0;
                sign = true;
            } else if(c=='-'){
                neg = true;
                if(str.length()==1||sign) return 0;
                sign = true;
            } else if(c==' ');
            else if(c<='9'&&c>='0') break;
            else if(str.length()==1) return 0;
            else return 0;

            str = str.substring(1);
        }

        //System.out.println("middle"+str);
        int mul = 0;
        List<Integer> num = new ArrayList<>();

        for(int i=0;i<str.length();i++){
            int a = str.charAt(i)-'0';
            if(a<0||a>9) break;
            else num.add(a);
        }
        System.out.println(num);
        System.out.println(neg);
        for(int i=num.size()-1,j=0;i>=0;i--,j++){
            result += (int)Math.pow(10,i)*num.get(j);
            if(!neg&&result>Integer.MAX_VALUE){
                result = Integer.MAX_VALUE;
            } else if(neg&&-result<Integer.MIN_VALUE){
                result = -(double)Integer.MIN_VALUE;
            }

        }

        if(neg) return (int)-result;
        else return (int)result;
    }

    //舍弃字符串前所有空格
    //非空格第一个可为加减号
    //加减号后尽可能多解释数字
    //注意Max&&Min
    public int newTry(String str) {
        if(str.equals("")) return 0;
        char c = str.charAt(0);
        while(c==' '){
            if(str.length()<=1) return 0;
            str = str.substring(1);
            c = str.charAt(0);
        }

        boolean neg = false;
        if(c=='-'){
            neg = true;
            str = str.substring(1);
        } else if (c == '+') {

            str = str.substring(1);
        }

        double result = 0;
        int mul = 0;
        List<Integer> num = new ArrayList<>();

        for(int i=0;i<str.length();i++){
            int a = str.charAt(i)-'0';
            if(a<0||a>9) break;
            else num.add(a);
        }

        //System.out.println(num);
        //System.out.println(neg);
        if(num.size()==0) return 0;
        for(int i=num.size()-1,j=0;i>=0;i--,j++){
            result += (int)Math.pow(10,i)*num.get(j);
            if(!neg&&result>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            } else if(neg&&-result<Integer.MIN_VALUE){
                return  Integer.MIN_VALUE;
            }

        }

        if(neg) return (int)-result;
        else return (int)result;
    }

    public int suggested(String str) {

        //Check if String is empty or null
        if(str.length()==0 || str == null) return 0;

        //Remove only the leading and trailing White Spaces.
        str = str.trim();

        int sign =1, total =0,index=0,len = str.length(),val=0;

        if(str.charAt(index) =='+' || str.charAt(index) =='-')
        {
            sign = str.charAt(index) == '+'? 1 :-1;
            index++;
        }

        while(index < len )
        {
            val = str.charAt(index)-'0';
            if(val < 0 || val >9) break;

            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/ 10 == total && Integer.MAX_VALUE%10 < val) {
                return sign == 1 ? Integer.MAX_VALUE :Integer.MIN_VALUE;

            }
            total = total*10 + val;
            index++;
        }

        return sign*total;

    }
}
