class Solution {
    // This is just medium !!!?
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if(org == null || org.length == 0) return true;
        if(seqs == null || seqs.size() == 0) return false;

        // idea from LC, topological sort.
        // the main idea is to think this in a graph direction
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Set<Integer> appear = new HashSet<>();

        for(int cur : org) appear.add(cur);
        // build graph and indegree

        // BUG2 : check first
        // BUG3 : indegree should be calculated based on graph rather than the ori seqs
        boolean firstAppear = false;
        for(List<Integer> seq : seqs) {
            if(seq.size()!=0 && !appear.contains(seq.get(0))) return false;
            if(seq.size()!=0 && seq.get(0) == org[0]) {
                firstAppear = true;
            }
            for(int i = 1; i<seq.size(); i++) {
                if(!appear.contains(seq.get(i))) return false;
                if(!graph.containsKey(seq.get(i-1))) graph.put(seq.get(i-1), new HashSet<>());
                graph.get(seq.get(i-1)).add(seq.get(i));
            }
        }
        if(!firstAppear) return false;

        for(Set<Integer> ins : graph.values()) {
            for(int cur : ins) {
                indegree.put(cur, indegree.getOrDefault(cur, 0) + 1);
            }
        }


        //debug indegree
        // System.out.println(graph);
        // System.out.println(indegree);

        // topological sort
        // BUG1: the indegree will not contian the org[0]
        if(indegree.containsKey(org[0])) return false;

        Queue<Integer> q = new LinkedList<>();
        q.add(org[0]);

        int ptr = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            // System.out.println("Poll" + cur);
            if(ptr >= org.length || cur != org[ptr ++]) return false;

            boolean check = true;
            if(graph.containsKey(cur)) {
                for(int next : graph.get(cur)) {
                    if(indegree.containsKey(next)) {
                        indegree.put(next, indegree.get(next) - 1);
                        if(indegree.get(next) == 0) {
                            if(!check) return false;
                            check = false;
                            q.add(next);
                            indegree.remove(next);
                        }
                    } else return false;
                }
            }
        }
        return indegree.size() == 0 && ptr == org.length;
    }

    // a strategy to determine the position of each num... 
    public boolean fromLC(int[] org, List<List<Integer>> seqs) {
        int len = org.length;
        int[] map = new int[len + 1];//map number to its index
        Arrays.fill(map, -1);
        int[] memo = new int[org.length];//count how many numbers are smaller(on the right)
        for (int i = 0; i < len; i++) {
            map[org[i]] = i;
        }
        for (List<Integer> seq : seqs) {
            if (seq.size() == 0) continue;
            int prev = seq.get(0);
            if (prev <= 0 || prev > len || map[prev] == -1) return false;
            for (int i = 1; i < seq.size(); i++) {
                int curr = seq.get(i);
                if (curr <= 0 || curr > len || map[curr] == -1) return false;
                memo[map[prev]] = Math.max(memo[map[prev]], len - map[curr] + 1);
                prev = curr;
            }
            memo[map[prev]] = Math.max(memo[map[prev]], 1);
        }
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] != len - i) return false;
        }
        return true;
    }
}