/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// binary search
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // left = 0, make this solution right.... Because there are no such kind of 0 version.
        int left = 0, right = n;
        // assume there exist a bad version
        while(left <= right) {
            if(left >= right-1) return right;
            int mid = left + (right - left)/2;
            if(isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    public int retry(int n) {
        int left = 1, right = n;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}