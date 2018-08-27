import java.util.Comparator;

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
    // first idea N^2
    // second idea sort & scan NlogN
    public boolean firstTry(Interval[] intervals) {
        if(intervals == null || intervals.length <= 1) return true;
        for(int i=0; i<intervals.length-1; i++) {
            for(int j=i; j<intervals.length; j++) {
                Interval a = intervals[i];
                Interval b = intervals[j];

                if(a.start >= b.end || b.start >= a.end) continue;
                return false;
            }
        }

        return true;
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length <= 1) return true;

        // nlogn sort
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval left, Interval right) {
                return left.start - right.start;
            }
        });

        for(int i=0; i<intervals.length-1; i++) {
            Interval a = intervals[i];
            Interval b = intervals[i+1];
            if(b.start >= a.end) continue;
            return false;
        }

        return true;
    }


    // From LC
    public boolean LC(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 1; i < start.length; i++) {
            if (start[i] < end[i - 1]) {
                return false;
            }
        }
        return true;
    }
} 