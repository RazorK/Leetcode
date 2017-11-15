import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * 首先 注意空串，空数组
 *
 * 利用java String 自带的函数indexOf，可判断字符串是否包括子串
 * 也可使用startsWith
 * Created by aimin on 2017/7/17.
 */
public class Solution {
    public static void main(String [] args) {
        String [] input = {
                "123","234","345"
        };
        String res = new Solution().longestCommonPrefix(input);
        System.out.println(res);
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        else if(strs.length==1) return strs[0];
        if(strs[0].equals("")) return "";

        int i;
        for(i=0;i<strs[0].length();i++) {
            char c = strs[0].charAt(i);
            boolean innerflag = false;
            for(int j=1;j<strs.length;j++) {
                if(strs[j].length()<i+1) {
                    innerflag = true;
                    break;
                }
                char d = strs[j].charAt(i);
                if(c!=d) {
                    innerflag = true;
                    break;
                }
            }
            if(innerflag) break;
        }
        return strs[0].substring(0,i);
    }

    public String suggested(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0)  return "";
        String prefix = strs[0];
        for (int k = 1 ; k < strs.length && prefix.length() > 0; k++){
            while (strs[k].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}