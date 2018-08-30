class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length<=1) return true;
        return helper(preorder, 0, preorder.length-1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean helper(int [] order, int start, int end, int limitStart, int limitEnd) {
        // BUG boarder handle
        if(start >= order.length || start >= end) return true;

        // assume no duplicates
        int cur = order[start];
        if(!check(cur, limitStart, limitEnd)) return false;
        int split = -1;
        for(int i=start + 1; i<=end; i++) {
            int now = order[i];
              if(split == -1 && now > cur) split = i;
            if(!check(now, limitStart, limitEnd)) return false;
        }
        
        if(split == -1) return helper(order, start+1, end, limitStart, cur);
        return helper(order, start+1, split-1, limitStart, cur) && helper(order, split, end, cur, limitEnd);
    }

    public boolean check(int cur, int start, int end) {
        return cur >= start && cur <=end;
    }

    public boolean verifyPreorder(int[] preorder) {
        int min = Integer.MIN_VALUE, index = -1;
        for (int p : preorder) {
            if (p < min) {
                return false;
            }
            while (index >= 0 && p > preorder[index]) {
                min = preorder[index];
                index--;
            }  
            index++;
            preorder[index] = p;
        }
        return true;
    }
}