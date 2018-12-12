class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            //BUG 1, empty input doesn't lead to empty output
            res.add(getRange(lower, upper));
            return res;
        }

        if(nums[0] != lower) res.add(getRange(lower, nums[0]-1));
        for(int i=1; i<nums.length; i++) {
            // BUG 2 : the situation that nums[i] == nums[i-1]
            if(nums[i] == nums[i-1] + 1 || nums[i] == nums[i-1]) continue;
            res.add(getRange(nums[i-1]+1, nums[i]-1));
        }
        if(nums[nums.length-1] != upper) res.add(getRange(nums[nums.length-1] + 1, upper));
        return res;
    }

    public String getRange(int start, int end) {
        return start == end ? Integer.toString(start) : start + "->" + end;
    }
}