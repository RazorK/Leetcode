import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目 给出随机整数数组 和目标  选出所有不重复的和为目标的数字组合
 * Created by aimin on 2017/7/21.
 */
public class Solution {
    public static void main(String [] args) {
        int [] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
        System.out.println(new Solution().fastest(nums,-9));
    }


    /**
     * 根据之前3Sum的做法，直接加一层循环就差不多，但是这里考虑重复情况比较复杂，直接在添加前进行重复检测
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();

        int i = 0;
        while(i<nums.length-3) {
            int j=i+1;
            while(j<nums.length-2) {
                int lo = j+1,hi = nums.length-1;
                System.out.println("first:"+i+j+lo+hi);
                if(nums[hi]+nums[hi-1]+nums[i]+nums[j]<target) {j++;continue;}
                if(nums[lo]+nums[lo+1]+nums[i]+nums[j]>target) break;

                while(hi>lo) {
                    System.out.println("index:"+i+j+lo+hi);

                    int sum = nums[hi]+nums[lo]+nums[i]+nums[j];
                    if(sum == target) {
                        List<Integer> temp =Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]);
                        if(!res.contains(temp))
                        res.add(temp);
                        hi--;
                        if(hi>lo) lo++;
                    }
                    else if(sum>target) hi--;
                    else if(sum<target) lo++;
                }
                j++;
            }
            i++;
        }

        return res;
    }

    /**
     * 这里通过限制合理地跳过相同项而不需要验证重复添加的过程
     * 所有合理情况必须只探讨一次，这个比较困难
     * 首先，要考虑清楚哪些地方可以跳过：
     * 在结果添加之后，跳过相同项hi lo
     * 对于i、j 相同项可以跳过，因为若需要重复i、j当前相同项的情况一定已讨论过
     * 对于hi lo未添加项，!!!不可以直接跳过之后重复项  因为有可能跳过合理情况
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> better(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();

        int i = 0;
        while(i<nums.length-3) {
            int j=i+1;
            if(i > 0 && nums[i] == nums[i-1]) {i++;continue;};
            while(j<nums.length-2) {
                int lo = j+1,hi = nums.length-1;
                //System.out.println("first:"+i+j+lo+hi);
                if(nums[hi]+nums[hi-1]+nums[i]+nums[j]<target) {j++;continue;}
                if(nums[lo]+nums[lo+1]+nums[i]+nums[j]>target) break;

                if(j>i+1 && nums[j]==nums[j-1]) {j++;continue;};
                while(hi>lo) {
                    //System.out.println("index:"+i+j+lo+hi);

                    int sum = nums[hi]+nums[lo]+nums[i]+nums[j];
                    if(sum == target) {
                        List<Integer> temp =Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]);
                        res.add(temp);
                        while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++;hi--;
                    }

                    //hi lo未添加项
                    else if(sum>target) hi--;
                    else if(sum<target) lo++;
                }
                j++;
            }
            i++;
        }

        return res;
    }

    public List<List<Integer>> fastest(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> l = new LinkedList<>();
        int lo = 0;
        int hi = nums.length - 1;
        int sum = 0;
        for(int i = 0; i < nums.length-3; i++) {
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;
            if(nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]<target) continue;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < nums.length-2; j++) {
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) break;
                lo = j+1;
                hi = nums.length-1;
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                while(lo < hi) {
                    sum = nums[i] + nums[j]+ nums[lo] + nums[hi];
                    if(sum == target) {
                        l.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        //System.out.println("h-1-:"+i+j+lo+hi);
                        while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                        //System.out.println("h-2-:"+i+j+lo+hi);
                        while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                        //System.out.println("h-3-:"+i+j+lo+hi);
                        lo++; hi--;
                        //System.out.println("h-w-:"+i+j+lo+hi);
                    } else if(sum < target) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }



        }
        return l;

    }
}
