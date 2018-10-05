class NumArray {

    int [] accu_sum;
    public NumArray(int[] nums) {
        accu_sum = new int [nums.length];
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            accu_sum[i] = sum;
        }
    }
    
    public int sumRange(int i, int j) {
        if(i==0) return accu_sum[j];
        else return accu_sum[j]-accu_sum[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */