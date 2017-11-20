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
    
}
