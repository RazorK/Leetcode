import java.util.*;
public class Test1 {
    static int[] counts(int[] nums, int[] maxes) {
        int [] res = new int [maxes.length];
        if(nums == null || nums.length == 0 || maxes == null || maxes.length == 0) return res;

        Arrays.sort(nums);
        for(int i=0; i<maxes.length; i++) {
            int cur = maxes[i];
            int x = Arrays.binarySearch(nums, cur);
            if(x >= 0) {
                while(x<nums.length && nums[x] != cur) {
                    x++;
                }
                res[i] = x;
            } else {
                res[i] = - x - 1;
            }
        }

        return res;
    }
}
