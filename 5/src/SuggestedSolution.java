/**
 * 这里是推荐的做法，主要思路是只需要记录最长字符的开始位置和截止位置即可。
 * 更重要的地方：
 * 在遍历每个Char的时候，向外拓展，快速排除不合规则项
 * Created by aimin on 2017/5/9.
 */
public class SuggestedSolution {
    int start, maxLength;
    public String longestPalindrome(String s) {
        if(s.length()<=2) return s;
        for(int i=0;i<s.length();i++){
            judgeI(s,i,i);
            judgeI(s,i,i+1);
        }
        return s.substring(start,start+maxLength);
    }
    public void judgeI(String s, int i, int j) {
        System.out.println("start"+i+","+j);
        while(i>=0 && j<s.length()&&s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        if(maxLength < j-i-1){
            start = i+1;
            maxLength = j-i-1;
            System.out.println("changed to"+start+","+(start+maxLength));
        }
    }
}
