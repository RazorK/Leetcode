import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * 23354 23534
 * 455432 52
 * 想法是从低到高 找到非递减排序的 然后把
 *
 * 出现的问题 一是length=1时未考虑，应考虑边界情况
 * 第二个问题 本来想不用分最大->最小情况的，但是貌似失败了
 * 第三个问题在判断是否继续时， > 和 >=不能等同，遇到时要考虑一下
 *
 * Created by aimin on 2017/8/17.
 */
public class Solution {
    public static void main(String [] arsgs) {
        int [] nums = {5,1,1};
        new Solution().nextPermutation(nums);
    }
    public void nextPermutation(int[] nums) {
        if(nums.length<=1) return;
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        int temp = 0;
        int i=0;

        //find the not descending number i, add the history to list
        boolean find = false;
        for(i=nums.length-1;i>=0;i--) {
            list.add(nums[i]);
            if(nums[i]>=max) max = nums[i];
            else {
                temp = nums[i];
                find = true;
                break;
            }
        }
        Collections.sort(list);
        //System.out.println(list.toString());
        if(find) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) > temp) {
                    nums[i++] = list.get(j);
                    list.remove(j);
                    break;
                }
            }
            int j = 0;
            for (; i < nums.length; i++) {
                nums[i] = list.get(j++);
            }
        } else {
            for(int j=0;j<list.size();j++) {
                nums[j] = list.get(j);
            }
        }
    }

    public void printl(int [] nums) {
        //print
        for(int x = 0;x<nums.length;x++) {
            System.out.println(nums[x]+", ");
        }
    }

    /**
     * leetcode上最快的算法
     * 主要是利用了原序列末尾原本的递减序列，而非直接使用排序
     *
     * @param nums
     */
    public void suggested(int[] nums) {
        // special cases
        if (nums.length <= 1) return;
        // scan from end to start
        for (int i=nums.length-1; i>0; i--) {
            int j = nums.length-1; // another swap index
            // if find the pair that's increasing
            if (nums[i-1]<nums[i]) {
                // swap the i-1 with the smallest but bigger than i-1 elt
                while (nums[j]<=nums[i-1]) j--; // find the desired index
                int tmp = nums[i-1];
                nums[i-1] = nums[j];
                nums[j] = tmp;
                // reverse the elts in range i -> n-1
                helperreverse(nums, i, nums.length-1);
                return;
            }
        }
        // reverse all the elts (lowest)
        helperreverse(nums,0,nums.length-1);
    }

    public void helperswap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void helperreverse(int[] nums, int i, int j) {
        while (i<j) {
            helperswap(nums,i,j);
            i++;
            j--;
        }
    }
}
