class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        
    }

    public int [] single(int [] num, int k) {
        
    }

    public int [] merge(int [] n1, int [] n2) {
        if(n1 == null) return n2;
        if(n2 == null) return n1;

        int [] res = new int [n1.length + n2.length];
        for(int left = 0, right = 0; left < n1.length || right < n2.length;) {
            if(n1[left] > n2[right]) {
                res[left + right] = n1[left];
                left ++;
            } else {
                res[left + right] = n2[right];
                right ++;
            }
        }
        return res;
    }
}