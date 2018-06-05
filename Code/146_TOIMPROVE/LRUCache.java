public class LRUCache {
    int cap;
    Map<Integer, CacheItem> map;
    int time;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        time = 0;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            map.get(key).a = time++;
            return map.get(key).v;
        }
        else return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            CacheItem it = map.get(key);
            it.v = value;
            it.a = time++;
            return;
        }

        if(map.size()>=cap) {
            int min = Integer.MAX_VALUE;
            CacheItem minIt = null;
            for(Map.Entry<Integer, CacheItem> en:map.entrySet()) {
                if(min > en.getValue().a) {
                    min = en.getValue().a;
                    minIt = en.getValue();
                }
            }
            map.remove(minIt.k);
        }

        map.put(key, new CacheItem(key, value, time++));
    }

    public  class CacheItem {
        public int k, v, a;
        public CacheItem(int key, int val, int age) {
            k = key;
            v = val;
            a = age;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
