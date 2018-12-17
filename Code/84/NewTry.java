class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        int ll = heights.length;
        int [] length = new int [ll];
        Arrays.fill(length, 1);

        // two pass
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<ll; i++) {
            int cur = heights[i];
            if(st.isEmpty()) {
                st.push(i);
                continue;
            }

            while(!st.isEmpty() && heights[st.peek()] > cur) {
                int pre = st.pop();
                length[pre] += i - pre - 1;
            }

            st.push(i);
        }

        while(!st.isEmpty()) {
            int pre = st.pop();
            length[pre] += ll - pre - 1;
        }
 
        st = new Stack<>();
        for(int i=ll-1; i>=0; i--) {
            int cur = heights[i];
            if(st.isEmpty()) {
                st.push(i);
                continue;
            }

            while(!st.isEmpty() && heights[st.peek()] > cur) {
                int pre = st.pop();
                length[pre] += pre - i -1;
            }

            st.push(i);
        }

        while(!st.isEmpty()) {
            int pre = st.pop();
            length[pre] += pre;
        }

        // find max
        int max = 0;
        for(int i=0; i<ll; i++) {
            max = Math.max(max, heights[i] * length[i]);
        }
        return max;
    }
}