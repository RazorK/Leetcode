class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        // construct the graph first
        // bus id -> set of bus id
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        // placeId -> set of bus id
        Map<Integer, Set<Integer>> places = new HashMap<>();
        // busId -> placeId
        Map<Integer, Set<Integer>> buses = new HashMap<>();

        for(int i = 0; i<routes.length; i++) {
            Set<Integer> curBus = new HashSet<>();
            for(int p : routes[i]) {
                places.computeIfAbsent(p, (k) -> new HashSet<>()).add(i);
                curBus.add(p);
            }
            buses.put(i, curBus);
        }

        for(Set<Integer> s : places.values()) {
            List<Integer> cur = new ArrayList<>(s);
            for(int i=0; i<cur.size(); i++) {
                int first = cur.get(i);
                for(int j=i+1; j<cur.size(); j++) {
                    int second = cur.get(j);
                    graph.computeIfAbsent(first, (k) -> new HashSet<>()).add(second);
                    graph.computeIfAbsent(second, (k) -> new HashSet<>()).add(first);
                }
            }
        }

        // bfs
        Queue<Integer> q = new LinkedList<>();
        q.addAll(places.get(S));
        int length = q.size();
        int level = 1;
        Set<Integer> visited = new HashSet<>();
        while(q.size()!=0) {
            for(int i=0; i<length; i++) {
                Integer curB = q.poll();
                if(buses.get(curB).contains(T)) return level;
                if(graph.containsKey(curB)) {
                    for(int next : graph.get(curB)) {
                        if(!visited.contains(next)) {
                            visited.add(next);
                            q.add(next);
                        }
                    }
                }
            }
            level++;
            length = q.size();
        }
        return -1;
    }
}