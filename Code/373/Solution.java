import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int []> res = new ArrayList<>();
        // remove duplicate
        Map<Integer, Set<Integer>> set = new HashMap<>();
        
        if(nums1.length == 0 || nums2.length == 0) return res;
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int []>() {
            @Override
            public int compare(int [] l, int [] r) {
                int ll = nums1[l[0]] + nums2[l[1]];
                int rr = nums1[r[0]] + nums2[r[1]];
                return ll - rr;
            }
        });
        pq.add(new int [] {0, 0});

        for(int i=0; i<k && pq.size()!=0; i++) {
            int [] min = pq.poll();
            int x = min[0], y = min[1] ;
            res.add(new int[] {nums1[x], nums2[y]});

            if(x + 1 < nums1.length && (!set.containsKey(x + 1) || !set.get(x+1).contains(y))) {
                pq.add(new int[] {x + 1, y});
                if(!set.containsKey(x + 1)) set.put(x + 1, new HashSet<>());
                set.get(x + 1).add(y);
            }
            if(y + 1 < nums2.length && (!set.containsKey(x) || !set.get(x).contains(y + 1))) {
                pq.add(new int [] { x, y + 1});
                if(!set.containsKey(x)) set.put(x, new HashSet<>());
                set.get(x).add(y + 1);
            }
        }
        return res;
    }
}