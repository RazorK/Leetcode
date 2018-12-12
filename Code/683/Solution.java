import java.util.TreeSet;

class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        if(flowers == null || flowers.length <= 1) return -1;

        int [] date = new int[flowers.length];
        for(int i=0; i<flowers.length; i++) {
            date[flowers[i]-1] = i;
        }

        TreeSet<Integer> set = new TreeSet<>();
        int left = 0;

        if(left + k + 1 >= flowers.length) return -1;

        for(int i=0; i<k-1; i++) {
            int cur = date[1 + i];
            set.add(cur);
        }
        
        for(; left + k + 1 < flowers.length; left ++) {
            set.add(date[left + k]);
            int first = date[left];
            int second = date[left + k + 1];
            if(first < set.first() && second < set.first()) {
                return Math.max(first, second) + 1;
            }

            set.remove(date[left + 1]);
        }
        return -1;
    }
}