import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 想了好长时间才想到递归。。  主要是之前没真正用递归解决过问题，想到这个问题可能会用堆栈或者二叉树，又去看了看算法书才想到
 * 要用递归主要是这种情况，有限分类，而且每个分类中都需要继续循环分类。。 例如遍历二叉树 例如这个
 *
 * 我想到用的这个方法主要是遍历了太多无效项，之后再将其排除， 应该在生成处排除比较好。
 * Created by aimin on 2017/7/23.
 */
public class Solution {

    public static void main(String [] args) {
        System.out.println(new Solution().better(3));
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        result(res,"",0,true,n);

        return res;
    }

    public void result(ArrayList<String> res, String now, int stack, boolean push, int n) {
        if(push) {
            now += "(";
            stack++;
        }
        else {
            now+=")";
            stack--;
        }

        if(now.length()>=2*n) {
            //System.out.println(now+stack);
            if(stack==0)
                res.add(now);
            return;
        }

        if(stack<2*n) result(res,now,stack,true,n);
        if(stack>0) result(res,now,stack,false,n);

    }

    public List<String> better(int n) {
        List<String> list=new ArrayList<>();
        findParenthesis(0, 0, "", list, n);
        return list;
    }
    private void findParenthesis(int left, int right, String s, List<String> list, int n){
        System.out.println(s);
        if(left==n && right==n){
            list.add(s);
            return;
        }
        if(left<n) findParenthesis(left+1, right, s+'(', list, n);
        if(left>right) findParenthesis(left, right+1, s+')', list, n);
    }
}
