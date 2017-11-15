import java.util.HashMap;

/**
 * I  V  X  L   C    D    M
 * 1  5 10 50 100  500 1000
 *  IV  IX   XL   XC    CD   DCCC    CM
 *  4    9   40   90   400   800     900
 * Created by aimin on 2017/7/16.
 */
public class Solution {


    //有点蠢的。。
    public String intToRoman(int num) {
        String re = "";

        //M 1000
        if(num > 1000) {
            int t = num/1000;
            num = num%1000;
            for(int i=0;i<t;i++)
                re+="M";
        }

        if(num > 900) {
            num = num-900;
            re+="CM";
        }

        if(num> 500) {
            num = num-500;
            re+="D";
        }

        if(num>100) {
            int t = num/100;
            num = num%100;
            for(int i=0;i<t;i++)
                re+="C";
        }
        return null;
    }


    /**
     * I  V  X  L   C    D    M
     * 1  5 10 50 100  500 1000
     *  IV  IX   XL   XC    CD   DCCC    CM
     *  4    9   40   90   400   800     900
     *
     *  疯狂超时。。 输出注释就好了。。
     * Created by aimin on 2017/7/16.
     */
    public String better(int num) {
        StringBuilder res = new StringBuilder();
        //System.out.println("hello");
        String [] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int [] arab = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        while(num>0) {
            for(int i=0;i<roman.length;i++){
                if(num>=arab[i]){
                    //System.out.println(i+","+num);
                    num -= arab[i];
                    res.append(roman[i]);
                    break;
                }
            }
            //System.out.println(num);
        }
        //ystem.out.println(res.toString());
        return res.toString();
    }

    public static void main(String [] args) {
        System.out.println(new Solution().better(3999));
    }

    public String saveTime(int num) {
        return null;
    }
}
