class Solution {
    //first idea, binary search, logn
    public static int searchInsert(int[] nums, int target) {
      if(nums.length==0) return 0;
      if(target<nums[0]) return 0;
      if(target>nums[nums.length-1]) return nums.length;
      int start = 0, end = nums.length-1;
      return binary(nums, start, end, target);
    }

    public static int binary(int[] nums, int start, int end, int target) {
      int mid = (start + end)/2;
      if(nums[mid] == target) return mid;

      //spend a lot of time here, should think of how many situations here
      // but if start >= end, then the answer can only be start or start + 1
      if(start >= end)
        if (nums[start] > target) return start;
        else if (nums[start] < target) return start +1;
      if(nums[mid] > target)
        return binary(nums, start, mid - 1, target);
      else
        return binary(nums, mid+1, end, target);
    }

    // -- linear try --
    public static int linear(int[] nums, int target) {
      if(target<nums[0]) return 0;
      if(target>nums[nums.length-1]) return nums.length;
      for(int i = 0; i< nums.length; i++) {
        if(nums[i] == target) return i;
        if(nums[i]< target && nums[i+1] > target) return i+1;
      }
      return 0;
    }

    //without recursion
    public static int withoutRec(int [] nums, int target) {
      if(nums.length==0) return 0;
      if(target<nums[0]) return 0;
      if(target>nums[nums.length-1]) return nums.length;
      int start = 0, end = nums.length-1;
      while(true) {
        int mid = (start + end)/2;
        if(target == nums[mid]) return mid;
        else if(start >= end) {
          if(nums[start] > target) return start;
          else return start + 1;
        }
        if(nums[mid]>target) end = mid-1;
        else start = mid + 1;
      }
    }
}
