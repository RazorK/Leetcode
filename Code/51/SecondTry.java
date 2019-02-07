import java.util.Arrays;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n<=0) return res;

        int [] resArray = new int [n];
        boolean [] visited = new boolean [n];
        
        dfs(res, resArray, visited, 0);
        return res;
    }

    public void dfs(List<List<String>> res, int [] resArray, boolean[] visited, int index) {
        if(index == resArray.length) {
            res.add(getStrList(resArray));
        }
        for(int i=0; i< resArray.length; i++) {
            if(!visited[i]) {
                if(!check(resArray, index, i)) continue;

                resArray[index] = i;
                visited[i] = true;
                dfs(res, resArray, visited, index + 1);
                visited[i] = false;
                resArray[index] = 0;
            }
        }
    }

    public boolean check(int [] resArray, int index, int cur) {
        for(int i=0; i<index; i++) {
            if(Math.abs(cur - resArray[i]) == index - i) return false;
        }
        return true;
    }

    public List<String> getStrList(int [] resArray) {
        List<String> res = new ArrayList<>();
        for(int x : resArray) {
            res.add(getString(x, resArray.length));
        }
        return res;
    }

    public String getString(int x, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            if(i == x) sb.append('Q');
            else sb.append('.');
        }
        return sb.toString();
    }
}