class Solution {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int left = 0; left<nums.length-1; left ++) {
            int low = Math.min(left+k, nums.length-1);
            for(int i=left+1; i<=low; i++) {
                long a = (long)nums[i];
                long b = (long)nums[left];
                if(Math.abs(a-b) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String [] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int []{1,5,9,1,5,9}, 2, 3));
    }
}
