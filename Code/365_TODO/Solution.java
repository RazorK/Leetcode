import java.util.*;

class Solution {
    // looks like we can solve it by dfs
    // work but too complex;
    public boolean canMeasureWater(int x, int y, int z) {
        return dfs(0, 0, x, y, z, new HashSet<>(), new HashSet<>());
    }

    public boolean dfs(int xx, int yy, int x, int y, int z, Set<String> failed, Set<String> curStack) {
        if(xx == z || yy == z) return true;
        
        String key = getKey(xx, yy); 
        if(failed.contains(key) || curStack.contains(key)) return false;
        System.out.println(xx + "," + yy);

        curStack.add(key);

        // all ops
        if( dfs(0, yy, x, y, z, failed, curStack) ||
            dfs(xx, 0, x, y, z, failed, curStack) ||
            dfs(x, yy, x, y, z, failed, curStack) ||
            dfs(xx, y, x, y, z, failed, curStack)) return true;
        
        // pour
        if(xx > y - yy && dfs(xx - y + yy, y, x, y, z, failed, curStack))  return true;
        if(xx < y - yy && dfs(0, xx + yy, x, y, z, failed, curStack)) return true;

        if(yy > x - xx && dfs(x, yy - x + xx, x, y, z, failed, curStack)) return true;
        if(yy < x - xx && dfs(xx + yy, 0, x, y, z, failed, curStack)) return true;

        failed.add(key);
        return false;
    }

    public String getKey(int x, int y) {
        return x + "," + y;
    }
}