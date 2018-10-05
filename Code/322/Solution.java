import java.util.*;
public class Solution {

    // Main recursive part: res[n] = min(for all coin: res[n - coin]) +1
    public int coinChange(int[] coins, int amount) {
        int [] count = new int[amount + 1];
        return helper(coins, amount, count);
    }

    public int helper(int [] coins, int amount, int [] count) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(count[amount] != 0) return count[amount];
        
        int res = Integer.MAX_VALUE;
        for(int coin : coins) {
            int inner = helper(coins, amount-coin, count);
            if(inner >= 0 && inner < res) {
                res = inner + 1;
            }
        }

        if(res != Integer.MAX_VALUE) {
            count[amount] = res;
            return res;
        } else {
            // the bug is really here, we have to caputre the result of unsatisfied amount as well. Otherwise, we will spend way much more time to figure out.
            count[amount] = -1;
            return -1;
        }
    }

    public static void main(String [] args) {
        int [] ar = {186,419,83,408};
        int num = 6249;
        System.out.println(new Solution().coinChange(ar, num));
    }
}