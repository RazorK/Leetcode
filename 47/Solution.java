class Solution {
    // Given a collection of numbers that might contain duplicates, return all possible unique permutations.
    // For example,
    // [1,1,2] have the following unique permutations:
    // [
    //   [1,1,2],
    //   [1,2,1],
    //   [2,1,1]
    // ]

    // notice the permit for duplicates here.
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length ==0 || nums == null) return result;
        Arrays.sort(nums);
        dfsHelper(nums, result, 0);
        return result;
    }

    public static void dfsHelper(int [] nums, List<List<Integer>> result, int index) {
        if(index==nums.length-1) {
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i< nums.length; i++) {
                temp.add(nums[i]);
            }
            result.add(temp);
            return;
        }
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i=index; i<nums.length; i++) {
            // BUG 1:
            // here this may cause duplicates
            // for each value, should appear only once for the index place
            // if(i!=index && nums[i]==nums[index]) continue;

            // Improve here:
            // instead of using swap here, just sort and adding to new array
            // works better here.
            if(map.containsKey(nums[i])) continue;
            map.put(nums[i], true);
            swap(nums, i, index);
            dfsHelper(nums, result, index+1);
            swap(nums, i, index);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
