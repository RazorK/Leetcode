/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null || intervals.length <= 1) return 0;

        Arrays.sort(intervals, (l1, l2) -> l1.start - l2.start);
        int res = 0;
        
        Interval prev = intervals[0];
        for(int i=1; i<intervals.length; i++) {
            Interval cur = intervals[i];
            if(prev.end > cur.start) {
                res++;
                if(prev.end > cur.end) {
                    prev = cur;
                }
            } else {
                prev = cur;
            }
        }
        return res;
    }
}