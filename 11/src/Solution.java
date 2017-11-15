/**
 * 最大的木板容量
 *
 * Created by aimin on 2017/7/16.
 */
public class Solution {

    //casual O(n^2)
    public int maxArea(int[] height) {
        int max = 0;
        int now;
        for(int i=0;i<height.length-1;i++){
            for(int j=1;j<=height.length-1;j++) {
                now = Math.min(height[i],height[j])*(j-i);
                max = now>max?now:max;
            }
        }

        return max;
    }

    //理论证明
    // 两边向中间遍历，每次向中间移动值较小的一边，一定能够遍历到面积最大的容器
    // 不妨设 u>v>x>y  av, ax面积最大， 不妨设av>ax, 若au>av, 则aux>avx，矛盾;若ay>ax,则avy>avx，矛盾；所以一定可以包括avx

    /**
     * 如何想到这个办法：
     * 首先，这个问题必须要遍历，目标在于如何更快地找到目标
     * 要省略掉没有必要的值 计算条件（更小的值*间隔） 目标两边其他的选择 间隔大，更小值一定会更小（由目标思考）
     * @param height
     * @return
     */
    public int better(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}
