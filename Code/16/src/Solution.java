import java.util.Arrays;

/**
 * 马虎犯错
 * 1.sum和target的距离与指针移动搞反
 * 2.记得赋初始值
 *
 * 用的主要还是上一题的思路，先排序，一次遍历，根据条件进行二层遍历
 * Created by aimin on 2017/7/19.
 */
public class Solution {
    public static void main(String [] args) {
        int [] nums = {0,2,1,-3};
        int t = new Solution().threeSumClosest(nums,1);
        System.out.println(t);
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        int minGap=Integer.MAX_VALUE;

        for(int i=0;i<nums.length-2;i++) {
            int lo = i+1,hi = nums.length-1;
            int gap;
            while(hi>lo){
                //System.out.println("序号："+hi+","+lo+","+i);
                //System.out.println("sum："+nums[hi]+nums[lo]+nums[i]);
                gap = target-nums[i]-nums[hi]-nums[lo];
                //System.out.println("gap,minGap:"+gap+","+minGap);
                if(minGap> Math.abs(gap)) {
                    minGap = Math.abs(gap);
                    sum = nums[i]+nums[hi]+nums[lo];
                    //System.out.println("inchange"+sum);
                }
                if(gap>0) lo++;
                else if(gap<0) hi--;
                else return target;
            }
        }
        //System.out.println(sum);

        return sum;
    }
}
