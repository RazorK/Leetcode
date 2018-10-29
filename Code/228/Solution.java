class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;

        int start = nums[0], end = nums[0];
        for(int i=1; i < nums.length; i++) {
            int cur = nums[i];
            if(cur == end+1) {
                end++;
            } else {
                res.add(getRange(start, end));
                start = cur;
                end = cur;
            }
        }
        // BUG 1: forget to add the last one
        res.add(getRange(start, end));
        return res;
    }

    public String getRange(int start, int end) {
        if(start == end) return Integer.toString(start);
        return start + "->" + end;
    }
}