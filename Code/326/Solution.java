import java.util.*;
class Solution {

    // from LC
    public static boolean isPowerOfThree(int n) {
        String toBase3 = Integer.toString(n, 3);
        return baseChatoBase3nge.matches("^10*$");
    }
    
    // TLE
    public boolean firstTry(int n) {
        if(n == 1) return true;
        if(n<0) return false;
        while(n % 3 == 0) {
            n = n/3;
        }
        return n == 1;
    }

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            System.out.println(isPowerOfThree(n));
        }
    }
}