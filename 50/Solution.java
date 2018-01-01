class Solution {

    // Implement pow(x, n).
    // Example 1:
    //
    // Input: 2.00000, 10
    // Output: 1024.00000
    // Example 2:
    //
    // Input: 2.10000, 3
    // Output: 9.26100


    // BUG 1 n<0
    // BUG 2 n==0 result = 1 rather than 0
    // Still time limit exceed.
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(x == 0) return 0;
        double result = 1;
        if(n>0) {
            for(int i=0; i<n; i++){
                result = result * x;
            }
        } else {
            for(int i=0; i<-n; i++){
                result = result * x;
            }
            result = 1.0/result;
        }
        return result;
    }

    // faster by store the result..
    public double byStore(double x, int n) {
        if(n == 0) return 1;
        if(x == 0) return 0;
        boolean neg = n<0;
        n = n<0? -n : n;
        HashMap<Integer, Double> map = new HashMap<>();
        map.put(0,1.0);
        double result = recur(x,n, map);
        if(neg) return 1.0/result;
        return result;
    }

    public double recur(double x, int n, HashMap<Integer, Double> map) {
        if(map.containsKey(n)) return map.get(n);
        double result = 1;
        if(n%2 == 0) {
            double temp = recur(x, n/2, map);
            result = temp * temp;
        } else {
            double temp = recur(x, n/2, map);
            result = temp * temp * x;
        }
        map.put(n, result);
        return result;
    }

    // try not use hashmap, which turns out to be better
    public double recur1(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        if(n<0){
            // return myPow(1/x,-n);
            // BUG：attention what if n = Max, -n will be overflow
            // solution : myPow(1/x,-n-1)/x;
            return recur1(1/x,-n-1)/x;
        }
        double half = recur1(x,n/2);
        if(n%2==0){
            return half*half;
        }
        return half*half*x;
    }

    // IDEA: treat the integer n as a binary number, and manpulate x.
    public double fast(double x, int n) {
       if (x == 0) {
            return 0D;
        }

        // process int n as binary number.
        // when regarding n as binary, it is already divided into sum of binary search path.
        // NOTE: the connection between binary number and binary search.
        double result = 1;
        while (n != 0) {
            // n&1 the last bit of n
            if ((n & 1) == 1) {
                if (n > 0) {
                    result *= x;
                } else {
                    result /= x;
                }
            }
            // manipulate x , left shift
            x *= x;
            n /= 2;
        }

        return result;
    }
}
