class Solution {
    // Write an algorithm to determine if a number is "happy".
    //
    // A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
    //
    // Example:
    //
    // Input: 19
    // Output: true
    // Explanation:
    // 12 + 92 = 82
    // 82 + 22 = 68
    // 62 + 82 = 100
    // 12 + 02 + 02 = 1

    // first idea, I guess that endless comes from repeat rather than never stop,
    // so try capture repeat first.
    public boolean isHappy(int n) {
        Set<Integer> map = new HashSet<>();
        while(!map.contains(n)) {
            if(n==1) return true;
            map.add(n);
            n = trans(n);
        }
        return false;
    }

    // this part can be improved.
    public int trans(int x) {
        char[] a = Integer.toString(x).toCharArray();
        int res = 0;
        for(char c: a) {
            int temp = c - '0';
            res += temp*temp;
        }
        return res;
    }
}
