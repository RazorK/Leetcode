import java.util.*;
class Solution {
    // first idea, sort and replace, maintain the offset
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        PriorityQueue pq = new PriorityQueue<Replace>(new Comparator<Replace> () {
            public int compare(Replace l, Replace r) {
                return l.index == r.index ? 0 : l.index - r.index;
            }
        });

        for(int i=0; i<indexes.length; i++) {
            int cur = indexes[i];
            int end = cur + sources[i].length();
            if(cur >= 0 && cur < S.length() && end >=0 && end <= S.length() && sources[i].equals(S.substring(cur, end))) {
                pq.add(new Replace(cur, targets[i], sources[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        int start = 0;
        while(!pq.isEmpty()) {
            Replace cur = (Replace)pq.poll();
            sb.append(S.substring(start, cur.index));
            sb.append(cur.target);
            start = cur.end;
        }
        sb.append(S.substring(start, S.length()));
        return sb.toString();
    }

    class Replace {
        int index;
        String target;
        int end;
        public Replace(int i, String t, String s) {
            index = i;
            target = t;
            end = index + s.length();
        }
    }
}