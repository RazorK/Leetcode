import java.util.*;
class Solution {
    // The set [1,2,3,.. ,n] contains a total of n! unique permutations.
    //
    // By listing and labeling all of the permutations in order,
    // We get the following sequence (ie, for n = 3):
    //
    // "123"
    // "132"
    // "213"
    // "231"
    // "312"
    // "321"
    // Given n and k, return the kth permutation sequence.
    //
    // Note: Given n will be between 1 and 9 inclusive.

    // first idea: determine each bit in order.
    public static String getPermutation(int n, int k) {
        int fact = 1;
        ArrayList<Character> board = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            fact *= i;
            board.add((char)('0'+i));
        }

        // calculate order
        int [] order = new int[n];
        // BUG k-1
        int value = k-1;
        fact = fact / n;
        for(int i=0; i<n; i++) {
            System.out.println(fact);
            order[i] = value/fact;
            // BUG although these are useless in the last iteration, still need
            // to consider whether the divider is zero.
            if(fact!=0&&(n-i-1)!=0) {
                value = value%fact;
                fact = fact/(n-i-1);
            }
        }
        // System.out.println(Arrays.toString(order));
        int length = n-1;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=n-1; i++) {
            sb.append(board.get(order[i]));
            board.remove(order[i]);
        }
        return sb.toString();
    }


    // My solution turn out to be very slow...

    // try check the faster Solution
    // basically same idea, didn't store the order.
    public String fast_getPermutation(int n, int k) {
        int[] factorial = new int[n+1];
        List<Integer> numbers = new ArrayList<Integer>();
        StringBuilder res = new StringBuilder();

        // get factorial
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;
        }

        for(int i=1; i<=n; i++){
            numbers.add(i);
        }

        k--;
        for(int i = 1; i <= n; i++){
            int index = k / factorial[n-i];
            res.append(numbers.get(index));
            numbers.remove(index);
            k -= index*factorial[n-i];
        }

        return res.toString();
    }
}
