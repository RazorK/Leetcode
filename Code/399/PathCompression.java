import java.util.HashMap;
import java.util.Map;

class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        DSU dsu = new DSU();

        for(int i=0; i<equations.length; i++) {
            dsu.union(equations[i][0], equations[i][1], values[i]);
        }

        double [] res = new double [queries.length];
        for(int i=0; i<queries.length; i++) {
            Node lp = dsu.findParent(queries[i][0]);
            Node rp = dsu.findParent(queries[i][1]);
            if(lp == null || rp == null) res[i] = -1;
            else {
                if(lp.s.equals(rp.s)){
                    res[i] = lp.v/rp.v;
                } else {
                    res[i] = -1;
                }
            }
        }
        return res;
    }

    public class DSU {
        Map<String, Node> map;

        public DSU() {
            map = new HashMap<>();
        }

        public Node findParent(String key) {
            if(!map.containsKey(key)) return null;
            if(key.equals(map.get(key).s)) return new Node(key, 1);
            Node curPa = map.get(key);

            Node pa = findParent(curPa.s);
            map.put(key, new Node(pa.s, pa.v * curPa.v));
            return map.get(key);
        }

        public boolean union(String l, String r, double lr) {
            if(!map.containsKey(l)) map.put(l, new Node(l, 1));
            if(!map.containsKey(r)) map.put(r, new Node(r, 1));

            Node lp = findParent(l);
            Node rp = findParent(r);
            if(lp.s.equals(rp.s)) return false;
            map.put(lp.s, new Node(rp.s, rp.v / lp.v * lr));
            return true;
        }
    }

    public class Node {
        String s;
        double v;
        public Node(String str, double val) {
            s = str;
            v = val;
        }
    }
}