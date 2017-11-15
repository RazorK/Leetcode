import java.util.HashMap;
import java.util.Map;

/**
 * 主要是使用了java中的map，利用map.containsKey来代替一次遍历
 * Created by aimin on 2017/5/4.
 */
public class SuggestedSolution {
    public static int[] towSum(int[] nums,int target) {
        int [] result =  new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
