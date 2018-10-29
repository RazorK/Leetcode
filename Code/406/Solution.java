class Solution {

    // first idea n^2..
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int []> () {
            @Override
            public int compare(int [] left, int [] right) {
                return left[0] - right[0];
            }
        });
        
        int [][] res = new int [people.length][2];
        Arrays.fill(res, null);
        for(int [] cur : people) {
            int height = cur[0];
            int rank = cur[1];

            for(int i=0; i<res.length; i++) {
                int [] find = res[i];
                if(find == null && rank == 0){
                    res[i] = cur;
                }
                if(find == null || find[0] == height) rank--;
            }
        }
        return res;
    }

    // from LC, nlogn idea
    // sort and insert
    // idea is really cool, start with the biggest item, and then the second rank can be directly used as the index.
    // here the problem is that we have to think with the idea that list are flexible.
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int []> () {
            @Override
            public int compare(int [] left, int [] right) {
                return left[0] == right[0] ? left[1] - right[1] : right[0] - left[0];
            }
        });

        List<int []> res = new ArrayList<>();

        // sorted like [1,0] [1,1] [0,0] [0,1]
        for(int [] cur : people) {
            res.add(cur[1], cur);
        }

        return res.toArray(new int[people.length][2]);
    }
}