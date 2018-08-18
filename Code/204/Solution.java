import java.util.*;
class Solution {
    // Count the number of prime numbers less than a non-negative number, n.
    //
    // Example:
    //
    // Input: 10
    // Output: 4
    // Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

    // TLE
    public int firstTry(int n) {
        if(n <= 2) return 0;
        int[] primes = new int [n];
        int ptr = 0;

        primes[ptr++] = 2;

        for(int i=3; i<n; i+=2) {
            boolean isPri = true;
            for(int j=0; j<ptr; j++) {
                if(i % primes[j] == 0) {
                    isPri = false;
                    break;
                }
            }
            if(isPri) primes[ptr++] = i;
        }
        return ptr;
    }

    //get Idea from LC
    // still can't understand why this faster
    // if we don't count the judgement the time complexity is n
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for(int i=2; i<n; i++) {
            if(!notPrime[i]) {
                count++;
                for(int j=2; j*i<n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }

}
