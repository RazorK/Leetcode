class Solution {
    class Solution {
        public double minmaxGasDist(int[] stations, int K) {
            
        }
    }

    // incorrect
    public double firstTry(int[] stations, int K) {
        // first idea priority queue
        if(stations == null || stations.length <= 1) return 0;
        PriorityQueue<Double> pq = new PriorityQueue<>((l, r) -> (r == l ? 0 : (r > l ? 1 : -1)));

        for(int i=0; i<stations.length-1; i++) {
            pq.add((double)(stations[i+1] - stations[i]));
        }

        for(int i=0; i<K; i ++) {
            double max = pq.poll();
            pq.add(max/2);
            pq.add(max/2);
        }
        return pq.poll();
    }
}