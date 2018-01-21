import java.util.*;
class Solution {
    // Given an index k, return the kth row of the Pascal's triangle.
    //
    // For example, given k = 3,
    // Return [1,3,3,1].
    //
    // Note:
    // Could you optimize your algorithm to use only O(k) extra space?

    // iterate
    public List<Integer> firstTry(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        if(rowIndex == 0) return res;

        for(int i=1; i<=rowIndex; i++) {
            // BUG must first add 1 here.
            for(int j=i-1; j>=1; j--) {
                res.set(j, res.get(j-1) + res.get(j));
            }
            res.add(1);
        }
        return res;
    }

    // try formula, still overflow..
    public List<Integer> formula(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0; i<=rowIndex; i++) {
            res.add((int)getC(i, rowIndex));
        }
        return res;
    }

    public long getC(int m, int n) {
        if(m==0 || m==n) return 1;
        long above = 1, below = 1;
        System.out.println(m+","+n);
        for(int i=m+1; i<=n; i++) {
            above *= i;
        }
        for(int i=1; i<=n-m; i++) {
            below*= i;
        }
        System.out.println(above);
        System.out.println(below);
        return above/below;
    }

    // getIdeaFrom LC
    // use formula and iterate.
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        result.add(1);
        long prev = 1;
        long rowIndexPlusOne = rowIndex + 1;
        for(int i = 1; i <= rowIndex; i++){
            prev = (prev * (rowIndexPlusOne - i)) / i;
            result.add((int)prev);
        }
        return result;
    }
}
