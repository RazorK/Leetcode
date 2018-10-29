import java.util.TreeMap;

class MyCalendar {

    private TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        if(map.containsKey(start)) return false;

        Integer c = map.ceilingKey(start);
        if(c!=null && end > c) return false;

        Integer f = map.floorKey(start);
        if(f!=null && map.get(f) > start) return false;
        
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */