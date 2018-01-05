import java.util.HashMap;
import java.util.Map;

/**
 * 自己编程中出现的问题：
 * s.substring(i,j)是取第i个字符到第j-1个字符 如（0，2） 是取0,1两个字符（j-i即length）
 * Created by aimin on 2017/5/9.
 */
public class Solution {

    Map<String,Integer> strMap;

    public String solution(String s){
        int longCount = 0;
        Map<Integer,String> map = new HashMap<>();
        strMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(j-i<=longCount) continue;
                if(isP(s.substring(i,j))){
                    strMap.put(s.substring(i,j),1);
                    map.put(j-i,s.substring(i,j));
                    longCount = longCount<(j-i)?(j-i):longCount;
                }
            }
        }
        return map.get(longCount);
    }

    public boolean isP(String s){
        for(int i=0;i<s.length()/2;i++){
            if(!(s.charAt(i) == s.charAt(s.length()-1-i))){
                return false;
            } else {
                if(strMap.containsKey(s.substring(i,s.length()-i)))
                    return true;
            }
        }
        return true;
    }
}
