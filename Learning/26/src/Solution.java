import java.util.ArrayList;

/**
 * 输入排序数组，删除重复数，并将数组前result项变为删除重复后数组
 * Created by aimin on 2017/7/25.
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int res = 1;
        int flag = nums[0];
        int ptr = 1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]!=flag) {
                res++;
                flag = nums[i];
                nums[ptr++] = flag;
            }
        }
        return res;
    }

    /**
     * 我的做法里面 ptr可以用result代替呀。。
     * @param nums
     * @return
     */
    public int better(int[] nums) {
        int len=1;
        for (int i=1; i<nums.length; i++){
            if (nums[i]!=nums[i-1]){
                nums[len++]=nums[i];
            }

        }
        return len;
    }

}
