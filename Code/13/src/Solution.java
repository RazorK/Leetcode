import java.util.HashMap;

/**
 * Created by aimin on 2017/7/17.
 */
public class Solution {
    public int romanToInt(String s) {
        //String [] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        //C X I
        char [] oriRoman = {'M','D','C','L','X','V','I'};
        //int [] arab = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int [] oriArab = {1000,500,100,50,10,5,1};
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<oriRoman.length;i++) {
            map.put(oriRoman[i],oriArab[i]);
        }

        int res = 0;
        s = s.trim();

        for(int i=0;i<s.length();i++) {
            int temp = map.get(s.charAt(i));
            if((temp==100||temp==10||temp==1)&&i<s.length()-1) {
                int next = map.get(s.charAt(i+1));
                if(next>temp) temp = -temp;
            }
            res+=temp;
        }
        return res;
    }
}
