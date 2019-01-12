import java.util.Map;

class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        
    }

    public class DSU {
        Map<String, Node> parents;
        public DSU() {
            parents = new HashMap<>();
        }

        public Node findParent(String cur) {
            if(!parents.containsKey(cur)) return null;
            if(parents.get(cur).p.equals(cur)) {
                
            }
        }
    }

    public class Node {
        double val;
        String p;
        public Node(double v, String pa) {
            this.p = pa;
            this.val = v;
        }
    }
}