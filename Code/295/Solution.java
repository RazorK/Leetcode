import java.util.*;
class MedianFinder {

    /** initialize your data structure here. */
    List<Integer> data;
    public MedianFinder() {
        data = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int insertIndex = binarySearch(data, num);
        // if(insertIndex>=data.length()) {
        //     data.add(num);
        //     return;
        // }

        data.add(insertIndex, num);
    }

    public static int binarySearch(List<Integer> data, int num) {
        int left = 0, right = data.size()-1;
        if(data.size() == 0 || data.get(right) <= num) {
            return data.size();
        }

        while(left < right) {
            int mid = left + (right - left)/2;
            if(num > data.get(mid)) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    public double findMedian() {
        int size = data.size();
        if(size%2==0) {
            double res = data.get(size/2) + data.get(size/2-1);
            return res/2;
        } else {
            return data.get(size/2);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */