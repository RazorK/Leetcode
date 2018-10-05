class Solution {

    // TLE...
    int [] max;
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int [] res = new int [k];
        helper(nums1, nums2, 0, 0, new int[k], 0);
        return max;
    }

    public void helper(int [] nums1, int [] nums2, int start1, int start2, int [] cur, int index) {
        if(start1 < 0 || start2 < 0 || start1 > nums1.length || start2 > nums2.length) return;
        if(index >= cur.length) {
            if(max == null || largerThan(cur, max)) {
                max = Arrays.copyOf(cur, cur.length);
            }
            return;
        }

        int candi1 = -1;
        for(int i = start1; i < nums1.length && index + (nums1.length - i) + (nums2.length - start2) >= cur.length ; i++) {
            if(candi1 == -1 || nums1[i] > nums1[candi1]) {
                candi1 = i;
            }
        }

        int candi2 = -1;
        for(int i = start2; i < nums2.length && index + (nums2.length - i) + (nums1.length - start1) >= cur.length; i++) {
            if(candi2 == -1 || nums2[i] > nums2[candi2]) {
                candi2 = i;
            }
        }

        if(candi2 == -1 || candi1 != -1 && nums1[candi1] >= nums2[candi2]) {
            cur[index] = nums1[candi1];
            helper(nums1, nums2, candi1 + 1, start2, cur, index + 1);
        } 

        if(candi1 == -1 || candi2 != -1 && nums1[candi1] <= nums2[candi2]) {
            cur[index] = nums2[candi2];
            helper(nums1, nums2, start1, candi2 + 1, cur, index + 1);
        }
    }

    public boolean largerThan(int[] nums1, int [] nums2) {
        for(int i=0; i<nums1.length; i++) {
            if(nums1[i] != nums2[i]) {
                return nums1[i] > nums2[i];
            }
        }
        return false;
    }
}