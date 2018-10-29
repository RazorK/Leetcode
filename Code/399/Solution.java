class Solution {

    // first idea full-map
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        if(queries.length == 0) return new double [0];
        // create full map
        Map<String, Map<String, Double>> map = new HashMap<>();
        for(int i=0; i<equations.length; i++) {
            String [] ab = equations[i];
            String left = ab[0], right = ab[1];

            add(map, left, right, values[i]);
        }

        double [] res = new double[queries.length];
        for(int i=0; i<queries.length; i++) {
            String left = queries[i][0], right = queries[i][1];
            if(map.containsKey(left) && map.get(left).containsKey(right)) {
                res[i] = map.get(left).get(right);
            } else {
                res[i] = -1.0;
            }
        }
        return res;
    }

    public void add(Map<String, Map<String, Double>> map, String a, String b, double v) {
        if(!map.containsKey(a)) {
            map.put(a, new HashMap<>());
            map.get(a).put(a, 1.0);
        }
        if(!map.containsKey(b)) {
            map.put(b, new HashMap<>());
            map.get(b).put(b, 1.0);
        }

        if(map.get(a).containsKey(b) || map.get(b).containsKey(a)) return;
        
        map.get(a).put(b, v);
        for(String x : new HashSet<String>(map.get(a).keySet())) {
            add(map, x, b, v/map.get(a).get(x));
        }

        map.get(b).put(a, 1.0/v);
        for(String x : new HashSet<String>(map.get(b).keySet())) {
            add(map, a, x, v*map.get(b).get(x));
        }
    }
} 