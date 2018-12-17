class MyCalendarTwo {
    /**
     * key: start < s[1] && end > s[0]
     * bug: (start >= s[0] && start < s[1]) || (end > s[0] && end <= s[1])
     */
    List<int []> first;
    List<int []> second;
    public MyCalendarTwo() {
        first = new ArrayList<>();
        second = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        // check any overlay with second
        for(int [] s : second) {
            if(start < s[1] && end > s[0]) return false;
        }

        // add it to first and to second;
        for(int [] s: first) {
            if(start < s[1] && end > s[0]) {
                second.add(new int [] {Math.max(start , s[0]), Math.min(end, s[1])});
            }
        }

        first.add(new int [] {start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */ 