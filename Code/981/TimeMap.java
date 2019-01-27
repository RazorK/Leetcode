import java.util.*;
class TimeMap {

    /** Initialize your data structure here. */
    // idea treemap

    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> cur = map.computeIfAbsent(key, (k) -> new TreeMap<>());
        if(cur.size() == 0 || !value.equals(cur.lastEntry().getValue())) cur.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key) || map.get(key).firstKey() > timestamp) return "";
        Map.Entry en = map.get(key).floorEntry(timestamp);
        if(en == null) return null;
        return (String)en.getValue();
    }

    // public static void main(String [] args) {
    //     TimeMap tm = new TimeMap();
    //     tm.set("foo", "bar", 1);
    //     System.out.println(tm.get("foo", 1));
    // }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */