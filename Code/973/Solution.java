import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if(points == null || points.length <= K) return points;
        // use a heap, nlogk
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int []>() {
            @Override
            public int compare(int [] l, int [] r) {
                return (r[0] * r[0] + r[1] * r[1]) - (l[0] * l[0] + l[1] * l[1]);
            }
        });

        for(int [] p : points) {
            if(pq.size() < K) pq.add(p);
            else {
                int [] min = pq.peek();
                if(p[0] * p[0] + p[1] * p[1] < min[0] * min[0] + min[1] * min[1]) {
                    pq.poll();
                    pq.add(p);
                }
            }
        }

        int [][] res = new int [K][2];
        for(int i=0; i<K; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}