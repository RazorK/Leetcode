/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.*;
class Solution {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> res = new ArrayList<Interval>();
        int ap = 0, bp = 0;
        while(ap < A.length && bp < B.length) {
            int st = Math.max(A[ap].start, B[bp].start), ed = Math.min(A[ap].end, B[bp].end);
            if(st <= ed) res.add(new Interval(st, ed));

            if(A[ap].end > B[bp].end) bp ++;
            else ap ++;
        }
        return res.toArray(new Interval[res.size()]);
    }
}