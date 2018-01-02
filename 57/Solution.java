import java.util.*;
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// Given a set of non-overlapping intervals, insert a new interval into the intervals
// (merge if necessary).
//
// You may assume that the intervals were initially sorted according to their start times.
//
// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
//
// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
//
// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
class Solution {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // BUG empty intervals will raise error in binarySearch
        if(intervals.size()==0) {
            intervals.add(newInterval);
            return intervals;
        }
        int find = binarySearch(intervals, newInterval.start);
        List<Interval> result = new ArrayList<>();
        for(int i=0; i<find; i++) {
            result.add(intervals.get(i));
        }

        Interval cur = newInterval;
        if(intervals.get(find).end < newInterval.start) result.add(intervals.get(find));
        // BUG: leave this condition out
        else if(intervals.get(find).end>newInterval.end) {
            return intervals;
        }
        else{
            cur = new Interval(intervals.get(find).start, newInterval.end);
        }

        int start = find+1;
        while(start < intervals.size()) {
            // BUG: misreverse the symble
            if(intervals.get(start).start > cur.end) break;
            else {
                // here must check cur.end and start.end
                if(intervals.get(start).end<cur.end){
                    start ++ ;
                    continue;
                }
                cur =  new Interval(cur.start, intervals.get(start).end);
                start++;
            }
        }
        result.add(cur);
        for(int i = start; i<intervals.size() ; i++) result.add(intervals.get(i));
        return result;
    }

    public static int binarySearch(List<Interval> intervals, int target) {
        int start = 0, end = intervals.size();
        while(true) {
            int mid = (start + end) /2;
            Interval mid_int = intervals.get(mid);
            if(target == mid_int.start) return mid;

            // BUG: reverse the assignment of end and start
            else if(target < mid_int.start ) {
                end = mid;
                continue;
            } else {
                if(mid+1>=intervals.size()) return mid;
                if(intervals.get(mid+1).start>target) return mid;
                start = mid;
                continue;
            }
        }
    }
}
