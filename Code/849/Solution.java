class Solution {
    public int firstTry(int[] seats) {
        // straight forward n^2
        // O(n) space, scan twice
        if(seats == null || seats.length == 0) return 0;
        int [] forward = new int[seats.length];
        int [] backward = new int[seats.length];

        Arrays.fill(forward, -1);
        Arrays.fill(backward, -1);

        // forward
        int preIndex = -1;
        for(int i=0; i<seats.length; i++) {
            if(seats[i] == 1) preIndex = i;
            if(preIndex == -1) {
                forward[i] = Integer.MAX_VALUE;
                continue;
            }
            forward[i] = i - preIndex;
        }

        int sufIndex = Integer.MAX_VALUE;
        for(int i=seats.length-1; i>=0; i--) {
            if(seats[i] == 1) sufIndex = i;
            if(sufIndex == Integer.MAX_VALUE) {
                backward[i] = Integer.MAX_VALUE;
                continue;
            }
            backward[i] = sufIndex - i;
        }
        System.out.println(Arrays.toString(forward));
        System.out.println(Arrays.toString(backward));        
        // find max;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<seats.length; i++) {
            if(seats[i] == 1) continue;
            int cand = Math.min(forward[i], backward[i]);
            max = Math.max(max, cand);
        }
        return max;
    }

    // try constant space, continuous zeros
    public int maxDistToClosest(int[] seats) {
        // count continuous zeros
        int max = -1;
        int count = 0;
        for(int i = 0; i<seats.length; i++) {
            if(seats[i] == 0) {
                count ++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);

        int first = max % 2 == 0 ? max / 2 - 1 : max/2;
        
        // find leading
        int leading = 0;
        for(int i=0; i<seats.length; i++) {
            if(seats[i] == 1) break;
            leading ++;
        }

        int following = 0;
        for(int i=seats.length - 1; i>=0; i--) {
            if(seats[i] == 1) break;
            following++;
        }

        return Math.max(Math.max(leading, following), first);
    }
}