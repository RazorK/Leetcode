class Solution {
    // first idea, use a stack to traverse all the file, the find the max;
    public int lengthLongestPath(String input) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        String [] split = input.split("\n");

        for(String cur : split) {
            int level = 0;
            int len = cur.length();
            for(int i=0; i<cur.length(); i++) {
                if(cur.charAt(i) == '\t') {
                    level ++;
                    len--;
                } else {
                    break;
                }
            }

            if(level > st.size()) {
                assert level == st.size() + 1;
            } else {
                while(st.size() != level) {
                    st.pop();
                }
            }

            if(cur.contains(".")) {
                if(!st.isEmpty()) {
                    max = Math.max(max, len + st.peek());
                } else {
                    max = Math.max(max, len);
                }
            } else {
                st.push(st.isEmpty() ? len + 1 : st.peek() + len + 1);
            }
        }

        return max;
    }

    // public static void main(String [] args) {
    //     String x = "\n\n";
    //     System.out.println(x.length());
    // }
}