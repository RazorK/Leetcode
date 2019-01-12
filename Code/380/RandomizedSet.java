import java.util.*;

class RandomizedSet {

    /** Initialize your data structure here. */
    List<Integer> data;
    // val -> index in data
    Map<Integer, Integer> map;
    public RandomizedSet() {
        //get the idea to use the data structure, hashmap and list
        data = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, data.size());
        data.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int tar = map.get(val);
        map.remove(val);
        if(tar == data.size()-1) {
            data.remove(tar);
        } else {
            // move the last one to tar
            int last = data.get(data.size()-1);
            data.set(tar, last);
            map.put(last, tar);
            data.remove(data.size()-1);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rm = new Random();
        return data.get(rm.nextInt(data.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */