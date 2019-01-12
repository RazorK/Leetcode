class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int [] res = new int [n];
        // BUG the execution stack can be larger than the number of functions...
        // int [] st = new int [n];
        Stack<Integer> st = new Stack<>();

        int preTime = 0;
        for(String cur : logs) {
            String [] sp = cur.split(":");
            int id = Integer.parseInt(sp[0]), time = Integer.parseInt(sp[2]);
            if(sp[1].equals("start")) {
                if(!st.isEmpty()) res[st.peek()] += time - preTime;
                st.push(id);
            } else {
                time ++;
                // id should be the same as st.peek()
                res[st.pop()] += time - preTime;
            }
            preTime = time;
        }

        return res;
    }
}