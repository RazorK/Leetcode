import java.util.ArrayList;

class Solution {
    public List<List<Integer>> getFactors(int n) {
        if(n<=1) return new ArrayList<List<Integer>>();
        List<Integer> factors = splitToPrime(n);
        Collections.sort(factors);
        System.out.println(factors);
        List<List<Integer>> res = new ArrayList<>();
        dfs(factors, res, 0, new ArrayList<>(), 1, n);
        return res;
    }

    public List<Integer> splitToPrime(int n) {
        if(n<=1) return null;

        for(int i=2; i<n/2; i++) {
            if(n%i == 0) {
                List<Integer> res = splitToPrime(n/i);
                if(res == null) {res = new ArrayList<>();}
                res.add(i);
                return res;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(n);
        return res;
    }

    public void dfs(List<Integer> factors, List<List<Integer>> res, int cur, List<Integer> curList, int curValue, int target) {
        if(cur >= factors.size()) {
            if(curValue!=1 && curValue!=target) {
                curList.add(curValue);
                res.add(new ArrayList<>(curList));
                curList.remove(curList.size()-1);
            }
            return;
        }

        int updateValue = curValue * factors.get(cur);
        
        // pass
        dfs(factors, res, cur+1, curList, updateValue, target);

        // add
        curList.add(updateValue);
        dfs(factors, res, cur+1, curList, 1, target);
        curList.remove(curList.size()-1);
    }
}