import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给出只包含()[]{}的字符串，判断该字符串是否符合括号规则，"(){}[]"、"{[()]}" 均属于正确规则
 * 使用栈就可以了
 * 其实可以直接使用char [] 自己实现栈的，这里还是做复杂了
 * 注意特殊情况 多出正括号时，不考虑会直接成功； 多出反括号时，栈可能会越界
 * Created by aimin on 2017/7/22.
 */
public class Solution {
    public static void main(String [] args) {
        System.out.println(new Solution().isValid("))"));
    }
    public boolean isValid(String s) {
        s = s.trim();
        if(s.length()%2==1) return false;
        if(s.equals("")) return true;

        LinkedList<Character> left = new LinkedList<>();
        left.add('(');
        left.add('[');
        left.add('{');

        LinkedList<Character> right = new LinkedList<>();
        right.add(')');
        right.add(']');
        right.add('}');

        Stack<Character> st = new Stack();
        for(int i=0;i<s.length();i++) {
            if(left.contains(s.charAt(i))) st.push(s.charAt(i));
            else if(st.size()<=0||right.get(left.indexOf(st.pop()))!=s.charAt(i)) return false;
        }

        if(st.size()==0) return true; else return false;
    }
}
