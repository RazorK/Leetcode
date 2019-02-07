class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int [] res = new int [queries.length];
        for(int i = 0; i<queries.length; i++) {
            A[queries[i][1]] += queries[i][0];
            res[i] = getEven(A);
        }
        return res;
    }

    public int getEven(int [] A) {
        int res = 0;
        for(int i : A) {
            if(i%2 == 0) {
                res += i;
            }
        }
        return res;
    }
}