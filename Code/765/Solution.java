class Solution {
    // the mixed seats can be regarded as cycle, to fix the seats in the cycle, 
    // the number we need to fix the cycle is at least the number of the nodes
    public int minSwapsCouples(int[] row) {
        int res = 0;
        int [] map = new int [row.length];
        // key: people, index: id in row
        for(int i=0; i<row.length; i++) {
            map[row[i]] = i;
        }

        for(int i=0; i<row.length/2; i++) {
            res += fix(row, 2*i, map);
        }
        return res;
    }

    // id: the id of first person in the couple
    public int fix(int [] row, int id, int [] map) {
        // System.out.println(Arrays.toString(row));
        // System.out.println("Fixing: " + id + "," + row[id]);
        int curPairId = id%2 == 0 ? id + 1 : id - 1;
        if(Math.abs(row[id] - row[curPairId]) == 1) return 0;

        int tarPerson = row[id] % 2 == 0 ? row[id] + 1 : row[id] - 1;
        int tarPersonId = map[tarPerson];

        int mapFirst = row[curPairId], mapNext = row[tarPersonId];
        swap(row, curPairId, tarPersonId);
        swap(map, mapFirst, mapNext);
        
        int next = tarPersonId % 2 == 0? tarPersonId : tarPersonId - 1;
        return 1 + fix(row, next, map);
    }

    public void swap(int [] data, int x, int y) {
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }

}