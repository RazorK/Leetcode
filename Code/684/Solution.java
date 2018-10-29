class Solution {
    // typical union find
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Integer> parent = new HashMap<>();

        for(int [] edge : edges) {
            int left = edge[0], right = edge[1];
            int leftP = findParent(parent, left), rightP = findParent(parent, right);

            if(leftP == rightP) return edge;

            parent.put(rightP, leftP);
        }
        return null;
    }

    public int findParent(Map<Integer, Integer> parent, int cur) {
        if(!parent.containsKey(cur)) return cur;
        
        int res = parent.get(cur);
        while(parent.containsKey(res)) {
            res = parent.get(res);
        }
        return res;
    }
}