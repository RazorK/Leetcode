/**
 * 输入整数数组和整数val，移除整数数组中所有值为val的值并返回新数组
 *
 * 审题出错。。  看成了返回删除的个数
 * Created by aimin on 2017/7/25.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length==0) return 0;
        int ptr = 0;
        int res = 0;

        for(int i=0;i<nums.length;i++) {
            if(nums[i] != val) {
                res++;
                nums[ptr++] = nums[i];
            }
        }
        return res;
    }
}
