import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int M = quality.length;
        Integer [] index = new Integer[M];
        for(int i=0; i<index.length; i++) index[i] = i;
        Arrays.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer l, Integer r) {
                double left = (0.0 + wage[l])/quality[l];
                double right = (0.0 + wage[r])/quality[r];
                if(left == right) return 0;
                return right < left ? 1 : -1;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            // sorted by quality
            public int compare(Integer l, Integer r) {
                return quality[r] - quality[l];
            }
        });

        int qSum = 0;
        for(int i=0; i<K; i++) {
            pq.add(index[i]);
            qSum += quality[index[i]];
        }

        double res = qSum * ((wage[index[K-1]]+0.0)/quality[index[K-1]]);
        // each time we pop the one with largest quality and insert the one with new small e/q
        for(int i=K; i<M; i++) {
            int poll = pq.poll();
            int insert = index[i];

            qSum = qSum - quality[poll] + quality[insert];
            double r = (double)wage[insert] / (double)quality[insert];
            pq.add(insert);
            res = Math.min(res, qSum * r);
        }

        return res;

    }
}