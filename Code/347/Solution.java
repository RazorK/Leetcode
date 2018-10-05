import java.util.HashMap;
import java.util.Map;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0 || k<=0) return res;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(!map.containsKey(num)) map.put(num, 0);
            map.put(num, map.get(num) + 1);
        }

        Queue<Integer> pq = new PriorityQueue<Integer>(11,
            new Comparator<Integer>() {
                public int compare(Integer i1, Integer i2) {
                    return map.get(i2) - map.get(i1);
                }
        });

        for(Map.Entry en : map.entrySet()) {
            pq.offer((Integer)en.getKey());
        }
        
        for(int i=0; i<k; i++) {
            res.add(pq.poll());
        }
        
        return res;
    }

    // From LC bucket sort
} 