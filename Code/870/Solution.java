import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        // first idea greedy
        Arrays.sort(A);
        int left = 0, right = A.length-1;
        
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int []>() {
            @Override
            public int compare(int [] l, int [] r) {
                // first value is the val in B, second is index
                return r[0] - l[0];
            }
        });

        for(int i=0; i<B.length; i++) {
            pq.add(new int[] {B[i], i});
        }

        int [] res = new int[A.length];

        while(!pq.isEmpty()) {
            int [] poll = pq.poll();
            if(A[right] > poll[0]) res[poll[1]] = A[right--];
            else res[poll[1]] = A[left++];
        }

        return res;
    }
}