/**
 * 处理整数考虑溢出
 * Created by aimin on 2017/7/16.
 */
public class Solution {
    public static void main(String [] args) {

    }
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        String s = String.valueOf(x);
        s = s.trim();

        for(int i=0,j=s.length()-1;j>=i;i++,j--) {
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    //似乎没做溢出考虑？
    public boolean faster(int x) {

        if(x <10 && x >-1) return true;
        int input = x;
        int rev = 0;
        while(x>0) {
            rev= rev*10 + (x%10) ;
            x =x/10 ;
        }
        if(rev == input) return true;

        return false;
    }
}
