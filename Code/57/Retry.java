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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // a solution with lots of corner case
        // find index to delete
        int start = Collections.binarySearch(intervals, newInterval, (l, r) -> l.start - r.start);
        if(start < 0) {
            start = -start - 1;
        }
        if(start != 0) {
            if(intervals.get(start-1).end >= newInterval.start) newInterval.start = intervals.get(--start).start;
        }

        // find end index to delete
        int end = Collections.binarySearch(intervals, newInterval, (l, r) -> l.end - r.end);
        if(end < 0) {end = - end - 1;}
        if(end != intervals.size()) {
            if(intervals.get(end).start <= newInterval.end) newInterval.end = intervals.get(end++).end;
        }
        //System.out.println(start+"," + end + "," + newInterval.start +"," +newInterval.end);

        // delete all the intervals
        for(int i = start; i<end; i++) {
            intervals.remove(start);
        }

        intervals.add(start, newInterval);
        return intervals;
    }
}