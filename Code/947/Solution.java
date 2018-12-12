class Solution {
    public int removeStones(int[][] stones) {
        // idea from 1p3a, regard the matrix as a graph, and each connected part can remove stones until one left
        // the stones are stored in the sparse format, so we can think in union find method
        Map<Integer, Set<Integer>> row2col = new HashMap<>();
        Map<Integer, Set<Integer>> col2row = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        for(int [] st : stones) {
            int x = st[0], y = st[1];
            String key = getKey(x, y);
            parent.put(key, parent.getOrDefault(key, key));
            String curP = key;

            // find all col
            if(row2col.containsKey(x)) {
                for(int col : row2col.get(x)) {
                    String newKey = getKey(x, col);
                    String newP = findParent(newKey, parent);
                    if(newP.equals(curP)) continue;
                    parent.put(curP, newP);
                    curP = newP;
                }
            }

            if(col2row.containsKey(y)) {
                for(int row: col2row.get(y)) {
                    String newKey = getKey(row, y);
                    String newP = findParent(newKey, parent);
                    if(newP.equals(curP)) continue;
                    parent.put(curP, newP);
                    curP = newP;
                }
            }

            row2col.computeIfAbsent(x, (kk) -> new HashSet<>()).add(y);
            col2row.computeIfAbsent(y, (kk) -> new HashSet<>()).add(x);
        }

        return stones.length - getNum(parent);
    }

    public int getNum(Map<String,String> map) {
        Set<String> pa = new HashSet<>();
        for(String cur : map.keySet()) {
            String p = findParent(cur, map);
            pa.add(p);
        }
        return pa.size();
    }

    public String getKey(int x, int y) {
        return x + "," + y;
    }

    public String findParent(String str, Map<String, String> parent) {
        while(parent.get(str) != str) {
            str = parent.get(str);
        }
        return str;
    }
}