class Solution {
    // There are N children standing in a line. Each child is assigned a rating value.
    //
    // You are giving candies to these children subjected to the following requirements:
    //
    // Each child must have at least one candy.
    // Children with a higher rating get more candies than their neighbors.
    // What is the minimum candies you must give?
    //
    // Example 1:
    //
    // Input: [1,0,2]
    // Output: 5
    // Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
    // Example 2:
    //
    // Input: [1,2,2]
    // Output: 4
    // Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
    //              The third child gets 1 candy because it satisfies the above two conditions.

    // IDEA: each step is assigned one, which will minimum the total candy number
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int [] nums = new int [ratings.length];
        nums[0] = 1;
        for(int i=1; i<ratings.length ;i++) {
            int temp = ratings[i];
            int pre = ratings[i-1];
            if(pre == temp) {
                nums[i] = nums[i-1] -1;
            } else if(temp > pre) {
                nums[i] = nums[i-1] + 1;
            } else {
                nums[i] = nums[i-1] -1;
            }
        }
        // move the nums above to zero
        int gap = Integer.MAX_VALUE;
        int sum = 0;
        for(int n : nums) {
            sum+=n;
            if(n<gap) {
                 gap = n;
            }
        }

        return sum + (ratings.length * (1-gap));
    }
}
