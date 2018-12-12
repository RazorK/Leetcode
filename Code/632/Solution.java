public class Solution {
    public int [] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        List<Num> list = new ArrayList<>();
        int [] sIndex = new int[k];

        // merge all list
        PriorityQueue<Num> pq = new PriorityQueue<Num>(new Comparator<Num>() {
            @Override
            public int compare(Num l, Num r) {
                return l.num - r.num;
            }
        });

        for(int i=0; i<k; i++) {
            if(nums.get(i).size()!=0) {
                pq.add(new Num(nums.get(i).get(sIndex[i]++), i));
            }
        }

        while(!pq.isEmpty()) {
            Num cur = pq.poll();
            int index = cur.index;
            if(sIndex[index] < nums.get(index).size()) {
                pq.add(new Num(nums.get(index).get(sIndex[index]++), index));
            }
            list.add(cur);
        }

        // two ptrs find range
        int min = Integer.MAX_VALUE;
        int [] range = new int[0];
        int left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(list.get(0).index, 1);

        while(true) {
            if(map.size() < k) {
                if(++right >= list.size()) break;
                Num cur = list.get(right);
                map.put(cur.index, map.getOrDefault(cur.index, 0) + 1);
            } else {
                if(min > list.get(right).num - list.get(left).num) {
                    range = new int[] {list.get(left).num, list.get(right).num};
                    min = range[1]- range[0];
                }
                Num cur = list.get(left++);
                map.put(cur.index, map.get(cur.index)-1);
                if(map.get(cur.index) == 0) map.remove(cur.index);
            }
        }

        return range;
    }

    public class Num {
        int num;
        int index;
        public Num(int n, int i) {
            num = n;
            index = i;
        }
    }
}