class Solution {

    // not in place
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] nums1cp = nums1.clone();
        int count = 0;
        int i,j;
        for(i=0, j=0; i<m && j<n; ) {
            if(nums1cp[i]< nums2[j]) {
                nums1[count] = nums1cp[i];
                i++;
                count++;
            } else if(nums1cp[i]>nums2[j]){
                nums1[count] = nums2[j];
                j++;
                count++;
            } else {
                nums1[count] = nums1cp[i];
                i++;
                count ++;
                nums1[count] = nums2[j];
                j++;
                count++;
            }
        }
        if(i>=m) {
            for(;j<n;) {
                nums1[count++] = nums2[j++];
            }
        } else if(j>=n) {
            for(;i<m;) {
                nums1[count++] = nums1cp[i++];
            }
        }
    }

    //try in place, main idea swap
    public void merge_inplace(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0) {
            System.arraycopy( nums2, 0, nums1, 0, nums2.length );
            return;
        }
        if(n == 0) return;
        int end = m + n - 1;
        int count = 0;
        int i,j;

        for(i = m-1, j = n-1; i>=0 && j>=0; ) {
            if(nums1[i]>nums2[j]) {
                nums1[end-(count++)] = nums1[i--];
            } else if(nums1[i]< nums2[j]) {
                nums1[end-(count++)] = nums2[j--];
            } else {
                nums1[end-(count++)] = nums1[i--];
                nums1[end-(count++)] = nums2[j--];
            }
        }
        if(i<0) {
            for(;j>=0;) {
                nums1[end-(count++)] = nums2[j--];
            }
        } else if(j<0) {
            for(;i>=0;) {
                nums1[end-(count++)] = nums1[i--];
            }
        }
    }

    //????
    public void wtf(int[] A, int m, int[] B, int n) {
        while(n>0) A[m+n-1] = (m==0||B[n-1] > A[m-1]) ? B[--n] : A[--m];
    }
}
