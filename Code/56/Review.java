class Solution {
    // Given a collection of intervals, merge all overlapping intervals.
    //
    // For example,
    // Given [1,3],[2,6],[8,10],[15,18],
    // return [1,6],[8,10],[15,18].

    // QUESTION: sorted?
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1) return intervals;
        // sort
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval left, Interval right) {
                if(left.start>right.start) return 1;
                else if(left.start<right.start) return -1;
                else return 0;
            }
        });

        List<Interval> result = new ArrayList<>();
        Interval cur = intervals.get(0);
        for(int i=1; i< intervals.size(); i++) {
            Interval com = intervals.get(i);
            if(cur.end < com.start) {
                result.add(cur);
                cur = com;
                continue;
            }
            //BUG here, we don't know which one is bigger cur.end or com.end
            cur = new Interval(cur.start, Math.max(cur.end, com.end));
        }
        result.add(cur);
        return result;
    }

    public List<Interval> suggested(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i=0;i<n;i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        List<Interval> ans = new ArrayList<>();
        for(int i=0,startIter = 0;i<n;i++){
            if(i == n-1 || end[i] < start[i+1]){
                ans.add(new Interval(start[startIter],end[i]));
                startIter = i+1;
            }
        }
        return ans;
    }
}
