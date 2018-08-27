import java.util.Map;

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

    // first idea sort & merge
    // very slow..
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        if(intervals.length == 1) return 1;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval left, Interval right) {
                return left.start - right.start;
            }
        });

        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for(int i=0; i<intervals.length; i++) {
            Interval cur = intervals[i];
            int count = 1;
            Map<Integer, Integer> ori = new HashMap<>(map);
            for(Map.Entry en: ori.entrySet()) {
                int key = (int)en.getKey();
                int value = (int)en.getValue();

                if(key <= cur.start) {
                    map.remove(key);
                } else {
                    if(key < cur.end) {
                        map.put(key, value+1);
                        max = Math.max(max, value+1);
                    } else {
                        count = Math.max(value + 1, count);
                    }
                }
            }
            map.put(cur.end, count);
            max = Math.max(max, count);
            System.out.println(map.toString());
        }

        return max;
    }

    public int fromLC_brillia(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        
        for (int index= 0; index < intervals.length; index++){
            starts[index] = intervals[index].start;
            ends[index] = intervals[index].end;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int endIter = 0;
        int rooms = 0;
        for (int i= 0; i < starts.length; i++){
            if(starts[i] < ends[endIter])
                rooms+=1;
            else
                endIter++;
        }
        return rooms;
    }
}