import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 题目，给手机按键，输入按键数字，返回可能输入的字符串
 * 想法很直白，首先根据第一个输入字符创建字符串，之后对每个输入的数字，先对字符串进行添加，再补充新的字符串
 *
 * 注意，在循环体中对循环条件有改变的要着重考虑，如这里使用res.size()进行循环，在循环体重又有插入，则导致无限循环
 *
 * 还有个小问题马虎了 在进行添加时，要注意是否是在原本的字符串上添加。。。
 * Created by aimin on 2017/7/21.
 */
public class Solution {
    public static void main (String [] args) {
        new Solution().letterCombinations("23");
    }
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if(digits.equals("")) return res;
        String [] str = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        for(int i=0;i<digits.length();i++) {
            String temp = str[digits.charAt(i)-'2'];
            //System.out.println(temp);
            if(res.size()==0) {
                for(int j=0;j<temp.length();j++) {
                    res.add(temp.substring(j,j+1));
                    //System.out.println(res);
                }
            } else {
                //这里不能直接用res.size做循环，会无限叠加！
                int size = res.size();
                for(int j=0;j<size;j++) {
                    //先用再添加。。
                    for(int x = 1;x<temp.length();x++) {
                        res.add(res.get(j)+temp.substring(x,x+1));
                        //System.out.println(res);
                    }
                    res.set(j,res.get(j)+temp.substring(0,1));
                }
            }
        }
        //System.out.println("final:"+res);
        return res;
    }
}
