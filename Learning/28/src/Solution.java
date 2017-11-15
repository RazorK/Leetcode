/**
 * 主要注意边界检查，检查时应在haystack.length-needle.length处结束
 * Created by aimin on 2017/7/29.
 */
public class Solution {
    public static void main (String [] args) {
        System.out.println(new Solution().strStr("3322332","2332"));
    }
    public int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;
        if(haystack.equals("")) return -1;

        for(int i=0;i<haystack.length();i++) {
            if(i+needle.length()>haystack.length()) return -1;
            if(haystack.substring(i,i+needle.length()).equals(needle))
                return i;
        }

        return -1;
    }
}
