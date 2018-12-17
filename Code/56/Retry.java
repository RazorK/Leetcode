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
        if(intervals == null || intervals.size() <=1 ) return intervals;
        // sort by start
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval l, Interval r) {
                return l.start - r.start;
            }
        });

        List<Interval> res = new ArrayList<>();
        Interval prev = null;
        for(int i=0; i<intervals.size(); i++) {
            if(prev == null)  {
                prev = intervals.get(i);
                continue;
            }
            Interval cur = intervals.get(i);
            if(prev.end < cur.start) {
                res.add(prev);
                prev = cur;
            } else {
                prev = new Interval(prev.start, Math.max(prev.end, cur.end));
            }
        }
        res.add(prev);
        return res;
    }
}