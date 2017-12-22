class Solution {

// Given a collection of distinct numbers, return all possible permutations.
// For example,
// [1,2,3] have the following permutations:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]

    // First idea. Just simply create the result we want.
    // recursion, array of buildin basic data type pass parameter by reference..
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length == 0) return result;
        boolean [] flags = new boolean[nums.length];
        Arrays.fill(flags, true);
        ArrayList<Integer> cur = new ArrayList<>();
        recursion(result, nums, flags, cur, 0);
        return result;
    }

    public static void recursion(List<List<Integer>> result, int [] nums,
    boolean [] flag, ArrayList<Integer> cur, int number) {
        if(number == nums.length) {
            result.add(cur);
            return;
        }
        number = number+1;
        for(int i=0; i<nums.length; i++) {
            if(flag[i] == false) continue;
            flag[i] = false;
            List<Integer> temp = (ArrayList<Integer>)cur.clone();
            cur.add(nums[i]);
            recursion(result, nums, flag, (ArrayList<Integer>)temp, number);
            flag[i] = true;
        }
    }


    // another try to implement by swap
    // DFS
    // by swaping each item to index, and fix this index part, we achieve that
    // iterate each item in each place in order.

    // still note that array of basic type pass by reference..
    public static List<List<Integer>> suggested(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length==0 || nums == null) return result;
        dfsHelper(result, nums, 0);
        return result;
    }

    public static void dfsHelper(List<List<Integer>> result, int [] nums, int index) {
        // remember here nums also pass by reference..
        if(index == nums.length - 1) {
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                temp.add(nums[i]);
            }
            result.add(temp);
            return;
        }

        for(int i=index; i<nums.length; i++) {
            swap(nums, index, i);
            dfsHelper(result, nums, index+1);
            swap(nums, index, i);
        }
    }

    public static void swap(int [] nums, int i, int j) {
        int temp  = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // same as first one
    // public static List<List<Integer>> permute(int[] nums) {
    //     List<List<Integer>> result = new ArrayList<List<Integer>>();
    //     if(nums.length == 0) return result;
    //
    //     ArrayList<Boolean> lflags = new ArrayList<Boolean>();
    //     for(int i=0; i< nums.length; i++) {
    //         lflags.add(true);
    //     }
    //
    //     ArrayList<Integer> cur = new ArrayList<>();
    //     recursion(result, nums, lflags, cur, 0);
    //     return result;
    // }
    //
    // public static void recursion(List<List<Integer>> result, int [] nums,
    // ArrayList<Boolean> flag, ArrayList<Integer> cur, int number) {
    //     if(number == nums.length) {
    //         result.add(cur);
    //         return;
    //     }
    //     number = number+1;
    //     for(int i=0; i<nums.length; i++) {
    //         if(flag.get(i) == false) continue;
    //
    //         List<Boolean> temp_flag = (ArrayList<Boolean>)flag.clone();
    //         temp_flag.set(i,false);
    //
    //         List<Integer> temp = (ArrayList<Integer>)cur.clone();
    //
    //         temp.add(nums[i]);
    //         recursion(result, nums, temp_flag, (ArrayList<Integer>)temp, number);
    //     }
    // }
}
