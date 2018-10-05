import java.util.*;
class AllPossibleResult {
    int NUM = 6;
    public static List<List<Integer>> getResultNum(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n<=0) return res;
        dfs(res, 1, n, new ArrayList<>());
        return res;
    }

    public static void dfs(List<List<Integer>> res, int min, int n, List<Integer> curList) {
        if(curList.size() == n) {
            res.add(new ArrayList<Integer>(curList));
            return;
        }
        for(int i = min; i<=6; i++) {
            curList.add(i);
            dfs(res, i, n, curList);
            curList.remove(curList.size()-1);
        }
    }

    public static void main(String [] args) {
        System.out.println(getResultNum(3));
    }
}