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
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1) return intervals;
        // sort
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval fir, Interval sec) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                if(fir.start<sec.start) return -1;
                if(fir.start>sec.start) return 1;
                if(fir.end<sec.end) return -1;
                if(fir.end>sec.end) return 1;
                return 0;
            }
        });

        // merge
        List<Interval> result = new ArrayList<>();
        Interval cur = intervals.get(0);
        for(int i=1; i<intervals.size(); i++) {
            Interval next = intervals.get(i);
            if(next.start>cur.end) {
                result.add(cur);
                cur = next;
                continue;
            } else {
                if(next.end<= cur.end) continue;
                else cur = new Interval(cur.start, next.end);
            }
        }

        // BUG: forget to add the last one
        result.add(cur);
        return result;
    }
}
