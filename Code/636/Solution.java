class Solution {
    class Log{
        int id;
        boolean start;
        int time;
        public Log(String log) {
            String [] s = log.split(":");
            id = Integer.parseInt(s[0]);
            start = s[1].charAt(0) == 's';
            time = Integer.parseInt(s[2]);
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        Log [] st = new Log [n];
        int top = 0;

        int [] res=  new int[n];

        int preEnd = -1;
        for(String str : logs) {
            Log cur = new Log(str);
            if(top == 0) {
                st[top ++] = cur;
                continue;
            }
            if(cur.start) {
                // two situations:
                // 1. a c...
                // 2. a b b c
                if
            }
        }
    }
}