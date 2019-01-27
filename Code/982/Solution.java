import java.util.*;
class Solution {
    public int countTriplets(int[] A) {
        int ln = A.length;
        int res = 0;

        for(int i=0; i<ln; i++) {
            for(int j=i; j<ln; j++) {
                for(int k=j; k<ln; k++) {
                    if((A[i] & A[j] & A[k]) == 0) res += get(i, j, k);
                }
            }
        }

        return res;
    }

    public int get(int i, int j, int k) {~
        if(i == j && j == k) return 1;
        if(i == j || j == k) return 3;
        return 6;
    }
}