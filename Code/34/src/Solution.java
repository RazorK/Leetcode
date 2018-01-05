/**
 * input : a sorted array, a integer target
 * output : range of index [3,4], [-1,-1] if not found
 * requirement: O(lgn)
 * Created by aimin on 2017/8/20.
 */
public class Solution {
    public static void main(String [] args) {
        int [] nums = new int[] {5,6,6,7,7,10};
        int target = 7;
        System.out.println(new Solution().moniteSearch(nums, target));
    }

    //超时。。
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0) return new int[] {-1,-1};
        if(target<nums[0]||target>nums[nums.length-1]) return new int[] {-1,-1};
        int left = 0,right = nums.length-1;
        int mid = (left+right)/2;
        while (true) {
            if(left>right) return new int[] {-1,-1};
            if(target>nums[mid]) {
                left = mid;
                mid = (left+right)/2;
            } else if(target<nums[mid]) {
                right = mid;
                mid = (left+right)/2;
            } else  {
                left = mid;
                right = mid;
                while (left>=0&&nums[left] == target) left--;
                while (right<=nums.length-1&&nums[right]==target) right++;
                return new int[] {left+1,right-1};
            }
        }
    }

    //这里建议的做法是只找到比target大的index,节省时间的过程主要是 不需要进行两边拓展查询


    public int[] suggested(int[] A, int target) {
        int start = Solution.firstGreaterEqual(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, Solution.firstGreaterEqual(A, target + 1) - 1};
    }

    //find the first number that is greater than or equal to target.
    //could return A.length if target is greater than A[A.length-1].
    //actually this is the same as lower_bound in C++ STL.
    private static int firstGreaterEqual(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            //low <= mid < high
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                //should not be mid-1 when A[mid]==target.
                //could be mid even if A[mid]>target because mid<high.
                high = mid;
            }
        }
        return low;
    }

    public int [] moniteSearch(int [] nums, int target) {
        int smaller = largerIndex(nums,target);
        if (smaller>=nums.length||nums[smaller]!= target){
            return new int [] {-1,-1};
        }
        return  new int [] {smaller, Solution.largerIndex(nums, target+1)};
    }
    public static int largerIndex(int [] nums, int target) {
        int mid = nums.length/2;
        int left = 0;
        int right = nums.length;

        while(left<right) {
            mid = (left+right)/2;
            if(target > nums[mid] ){
                left = mid + 1;
            } else if(target <= nums[mid]) {
                right = mid;
            }
        }
        return right;
    }
}
