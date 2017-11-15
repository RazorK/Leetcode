import java.util.HashMap;

/**
 * Spot：StringBuilder 更快、更省资源地组合字符串
 * Created by aimin on 2017/5/23.
 */

public class Solution {
    /**
     *
     * @param s 输入字符串
     * @param numRows 行数
     * @return
     */
    /*public String convert(String s, int numRows) {
        //记录每行行数？？
        HashMap<Integer,Integer> rowLength = new HashMap<>();//rownum, length

        //cycle 为一个循环
        int cycle = 2*numRows-2;
        //mod 最后一个循环中剩余的个数
        int mod = s.length()%cycle;
        //循环数
        int result = s.length()/cycle;

        rowLength.put(0,mod==0?result:result+1);
        rowLength.put(numRows-1,mod>numRows-1?result+1:result);
        for(int i=1;i<numRows-1;i++){
            if(mod<i+1)
                rowLength.put(i,2*result);
            else if(mod>=i+1&&mod<2*numRows-i-1)
                rowLength.put(i,2*result+1);
            else
                rowLength.put(i,2*result+2);
        }
        System.out.println(rowLength.toString());
        return null;
    }*/

    public String convert_new (String s, int numRows ){
        if(s.length()<=numRows||numRows==1) return s;
        String result = "";
        int recyc = 2*numRows-2;
        for(int i=0;i<numRows;i++) {
            int gap1,gap2;
            if(i==0 || i==numRows-1) {
                gap2 = recyc;
                gap1 = gap2;
            } else {
                gap1 = 2*(numRows-i)-2;
                gap2 = recyc-gap1;
            }

            int ptr = i;
            do{
                result+=s.charAt(ptr);
                ptr+=gap1;
                if(ptr>=s.length()) break;
                result+=s.charAt(ptr);
                ptr+=gap2;
            } while(ptr<s.length());
        }
        return result;
    }

    public String convert_better (String s, int numRows ){
        if(s.length()<=numRows||numRows==1) return s;
        StringBuilder sb = new StringBuilder();
        int recyc = 2*numRows-2;
        for(int i=0;i<numRows;i++) {
            int gap1,gap2;
            if(i==0 || i==numRows-1) {
                gap2 = recyc;
                gap1 = gap2;
            } else {
                gap1 = 2*(numRows-i)-2;
                gap2 = recyc-gap1;
            }

            int ptr = i;
            do{
                sb.append(s.charAt(ptr));
                ptr+=gap1;
                if(ptr>=s.length()) break;
                sb.append(s.charAt(ptr));
                ptr+=gap2;
            } while(ptr<s.length());
        }
        return sb.toString();
    }
}

/*

x                            x+2n-2
x+1                 x+2n-3

x+n-1  x+n+1
x+n

 */
