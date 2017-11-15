/**
 * Created by aimin on 2017/8/21.
 */
public class Solution {
    public static void main(String [] args) {
        int [] nums1 = new int[] {1,2};
        int [] nums2 = new int[] {3,4,5};
        System.out.println(new Solution().findMedianSortedArrays(nums1,nums2));
    }
    public double tryAgain(int[] nums1, int [] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        if(l1==0) return nums2[l2/2];
        if(l2==0) return nums1[l1/2];

        int count, target1,target2;



    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length,l2 = nums2.length;
        if(l1==0) return nums2[l2/2];
        if(l2==0) return nums1[l1/2];
        int count = 0,end;
        int p1=0,p2=0;
        boolean f1 = true;
        boolean returnFlag = false;
        if((l1+l2)%2==0) returnFlag = true;
        end = (l1+l2)/2;
        while(count<end) {
            if(nums1[p1]<nums2[p2]) {
                p1++;
                count++;
                f1 = true;
            } else {
                p2++;
                count++;
                f1 = false;
            }
        }
        System.out.println(end+","+p1+""+p2);
        return returnFlag?(f1?nums1[p1]:nums2[p2]):(nums1[p1]+nums2[p2])/2;
    }
}
