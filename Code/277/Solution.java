/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n<=1) return n;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) q.add(i);
        while(q.size() > 1) {
            int a = q.poll();
            int b = q.poll();
            if(knows(a, b)) {
                q.add(b);
            } else {
                q.add(a);
            }
        }

        int pos = q.poll();
        for(int i=0; i<n; i++) {
            if(i == pos) continue;
            if(knows(pos, i))  return -1;
            if(!know(i, pos)) return -1;
        }
        return pos;
    }
}