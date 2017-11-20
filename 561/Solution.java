class Solution {
    //main idea is to prove the result is exactly the second biggest, the forth, the sixth and so on
    // proof:
    // the smallest must be in the Solution
    // the (a,b) for the smallest must be the second smallest
    // continue to the end.

    //sort nlogn
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int i=0;i<nums.length;i++) {
            if(i%2 == 0){
                result += nums[i];
            }
        }
        return result;
    }


    //idea to solve this in linear time, use bucket to achieve it.
    public int fastest(int[] nums) {
        int[] array = new int[20001]{0};
        for (int num : nums) {
            array[num + 10000]++;
        }
        boolean flag = true;
        int sum = 0;
        for (int i = 0; i < 20001; i++) {
            for (int remain = array[i]; remain > 0; remain--) {
                if (flag) {
                    sum += i - 10000;
                }
                flag = !flag;
            }
        }
        return sum;
    }
}
