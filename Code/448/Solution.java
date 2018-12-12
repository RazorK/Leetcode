class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == i+1) continue;
            int temp = nums[i];
            while(nums[temp-1] != temp) {
                int next = nums[temp-1];
                nums[temp-1] = temp;
                temp = next;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != i+1) res.add(i+1);
        }

        return res;
    }
}