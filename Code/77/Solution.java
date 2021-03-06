import java.util.*;
class Solution {
    // Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
    //
    // For example,
    // If n = 4 and k = 2, a solution is:
    //
    // [
    //   [2,4],
    //   [3,4],
    //   [2,3],
    //   [1,2],
    //   [1,3],
    //   [1,4],
    // ]

    // first try dfs.
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if( n<k || n==0 || k==0 ) return result;
        List<Integer> current = new ArrayList<>();
        dfs(result, current, n, k);
        return result;
    }

    public static void dfs(List<List<Integer>> result, List<Integer> current, int n, int k) {
        if(k == 0) {
            // BUG cannot directly add current here, because the current will be added as reference
            // and the current will change later

            // BUG to use clone function, we shoule first transform list to arraylist
            // but the clone function return an instance of Object type, and we should transform it to List<Integer> type.
            //List<Integer> copy = (List<Integer>)((ArrayList<Integer>)current).clone();

            // NOTE another way to clone, learn from leetcode
            result.add(new ArrayList<Integer>(current));

            // BUG miss return here, correct but seems slower.
            // add a return turn out slower???? wtf..
            // return;
        }
        for(int i=n; i>=1; i--) {
            current.add(i);
            dfs(result, current, i-1, k-1);
            current.remove(current.size()-1);
        }
    }


    // get from leetcode
    // another idea, not very clear...
    // C(n,k)=C(n-1,k-1)+C(n-1,k)
    public List<List<Integer>> combine_new(int n, int k) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, current, 1, n, k);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> current, int c, int n, int k) {
        if (c + k > n + 1) {
            return;
        }
        if (k == 0) {
            List<Integer> tmpList = new ArrayList<>(current);
            result.add(tmpList);
            return;
        }
        current.add(c);
        dfs(result, current, c + 1, n, k - 1);
        current.remove(current.size() - 1);
        dfs(result, current, c + 1, n, k);
    }
}
