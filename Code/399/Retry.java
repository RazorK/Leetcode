class Solution {
    public class Parent{
        String str;
        double val;
        public Parent(String s, double v) {
            str = s;
            val = v;
        }
    }

    // time complexity: construct map: n log n, search n log n
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // IDEA come from Lei, the key idea is transform all equations to a tree structure
        // use union find

        // store leaf -> parent tree
        Map<String, Parent> map = new HashMap<>();

        // construct tree
        for(int i=0; i<equations.length; i++) {
            String top = equations[i][0], bot = equations[i][1];
            double value = values[i];
            if(!map.containsKey(top)) map.put(top, new Parent(top, 1.0));
            if(!map.containsKey(bot)) map.put(bot, new Parent(bot, 1.0));

            Parent topParent = findParent(top, map);
            Parent botParent = findParent(bot, map);
            
            if(topParent.str != botParent.str) {
                // connect two trees by update bot parent
                // System.out.println(topParent.val + "," + botParent.val + "," + value);
                // System.out.println(topParent.str + "," + (topParent.val / botParent.val * value));
                map.put(botParent.str, new Parent(topParent.str, topParent.val / botParent.val * value));
            }
        }
        //printMap(map);
        double [] res = new double [queries.length];
        for(int i=0; i<res.length; i++) {
            // BUG 2: here we have to find parent..
            String top = queries[i][0], bot = queries[i][1];
            if(map.containsKey(top) && map.containsKey(bot)) {
                Parent tt = findParent(top, map), bb = findParent(bot, map);
                if(tt.str != bb.str) {
                    res[i] = -1;
                } else {
                    res[i] = bb.val / tt.val;
                }
            } else {
                res[i] = -1;
            }
        }
        return res;
    }

    // a function to find the final parent in the tree
    public Parent findParent(String str, Map<String, Parent> map) {
        double value = 1.0;
        while(map.get(str).str != str) {
            // BUG 1: these two lines of code can not exchange..
            value *= map.get(str).val;
            str = map.get(str).str;
        }
        
        return new Parent(str, value);
    }

    public void printMap(Map<String, Parent> map) {
        // print map
        for(String cur: map.keySet()) {
            System.out.println(cur+',' + map.get(cur).str +',' + map.get(cur).val);
        }
    }
}