import java.util.HashMap;
import java.util.Map;

/**
 * 1.容易的思路，遍历，在每次遍历中寻找以此为开头的最长字符串（可使用map）
 * 2.solution，map 的属性，put相同key则保留后者，利用这一属性，可实现一个扫描过程中key：key最大位置的map
 * 3. 利用map，维护了两个边界，一个范围
 * Created by aimin on 2017/5/5.
 */
public class Main {
    public static void main(String [] args){
        String a  = "abcabcdabc";
        System.out.println(solution(a));
    }
    public static int lengthOfLongestSubstring(String s){
        int result = 0;
        for(int i=0;i<s.length();i++){
            Map<Character,Integer> map = new HashMap<>();
            int temp = i+1;
            map.put(s.charAt(i),1);
            int tempresult = 1;
            result = tempresult>result?tempresult:result;
            while(temp<s.length()&&!map.containsKey(s.charAt(temp))){
                map.put(s.charAt(temp++),1);
                if(++tempresult>result){
                    result = tempresult;
                }
            }
        }
        return result;
    }

    public static int solution(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
