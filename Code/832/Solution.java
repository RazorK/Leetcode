class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i=0; i<A.length; i++) {
            flipRop(A[i]);
        }
        return A;
    }

    public static void flipRop(int [] row) {
        int left = 0, right = row.length-1;
        while(left <= right) {
            if(left == right) row[left] = reverse(row[left]);
            else {
                int temp = row[left];
                row[left] = reverse(row[right]);
                row[right] = reverse(temp);
            }
            left ++;
            right--;
        }
    }

    // fromLC, this function can be replaced by 1-i
    public static int reverse(int i) {
        return i == 1 ? 0 : 1;
    }
}