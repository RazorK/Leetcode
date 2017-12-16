import java.util.*;
class Solution {
	// requirement: linear time, constant space
	public static int missingNumber(int[] nums) {
		if(nums.length==0) return 0;
		int count = 0;
		while(count< nums.length) {
			if(nums[count] != count) {
				if(nums[count]>= nums.length)
				{count++;
				 continue; }
				swap(nums, count, nums[count]);

                // bug 1 forget continue here
                continue;
			}
			count++;
			continue;
		}
		for(int i=0; i<nums.length; i++) {
			if(nums[i]!=i) return i;
		}
		return nums.length;
	}

	public static void swap(int [] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
        //System.out.println(Arrays.toString(nums));
	}


    // faster
    // wtf use sum to solve the problem!!!
    
    public int fastest(int[] nums) {
        int count = 0;
        for(int num: nums) {
            count += num;
        }
        int size = nums.length;
        int real = 0;
        for(int i =0; i <= size; i++) {
            real += i;
        }
        return real - count;
    }
}
