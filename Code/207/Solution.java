class Solution {
    // There are a total of n courses you have to take, labeled from 0 to n-1.
    //
    // Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
    //
    // Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
    //
    // Example 1:
    //
    // Input: 2, [[1,0]]
    // Output: true
    // Explanation: There are a total of 2 courses to take.
    //              To take course 1 you should have finished course 0. So it is possible.
    // Example 2:
    //
    // Input: 2, [[1,0],[0,1]]
    // Output: false
    // Explanation: There are a total of 2 courses to take.
    //              To take course 1 you should have finished course 0, and to take course 0 you should
    //              also have finished course 1. So it is impossible.
    // Note:
    //
    // The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
    // You may assume that there are no duplicate edges in the input prerequisites.

    // bfs keep a structure that stores the infomation about
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 1) return true;
        if(prerequisites == null || prerequisites.length == 0) return true;

        List<List<Integer>> board = new ArrayList<List<Integer>>();

        for(int i=0; i<numCourses; i++) {
            board.add(new ArrayList<Integer>());
        }

        for(int i=0; i< prerequisites.length; i++) {
            int [] cur = prerequisites[i];
            // assume no duplicates
            board.get(cur[0]).add(cur[1]);
        }

        List<Set<Integer>> reach = new ArrayList<Set<Integer>>();
        for(int i=0; i<numCourses; i++) {
            Set<Integer> cur = new HashSet<Integer>();
            cur.add(i);
            reach.add(cur);
        }

        //BFS without dp => TLE, try DP
        // still very slow..
        Set<Integer> visit = new HashSet<>();

        for(int i=0; i<numCourses; i++) {
            boolean change = true;
            while(change) {
                change = false;
                // spread to next
                Set<Integer> it = new HashSet<>(reach.get(i));
                for(Integer cur : it) {
                    for(Integer next: board.get(cur)) {
                        if(visit.contains(next)) {
                            reach.get(i).addAll(reach.get(next));
                            continue;
                        }
                        if(next == i) return false;
                        if(!reach.get(i).contains(next)) {
                            change = true;
                            reach.get(i).add(next);
                        }
                    }
                }
            }
            visit.add(i);
        }

        return true;
    }


    // my solution are all very slow, get this code from leetcode
    public boolean faster(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] p: prerequisites) {
            graph[p[1]].add(p[0]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!valid(graph, i, visited)) {
                return false;
            }
        }
        return true;
    }

    // recursive but dfs. What's better:
    // 1. use DP, make use of previous infomation
    // 2. rely on the return chain to report false
    // 3. use visited to store the path infomation,
    //  if we encounter a visited pointe, directly return false
    private boolean valid(ArrayList<Integer>[] graph, int curr, int[] visited) {
        if (visited[curr] == 1) {
            return false;
        }
        if (visited[curr] == 2) {
            return true;
        }
        visited[curr] = 1;
        for (int next: graph[curr]) {
            if (!valid(graph, next, visited)) {
                return false;
            }
        }
        visited[curr] = 2;
        return true;
    }
}
