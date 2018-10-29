class NumArray {
    int [] segTree;
    int [] ori;
    public NumArray(int[] nums) {
        int size = (int)Math.pow(2, Math.ceil(Math.log(nums.length)/Math.log(2))) * 2;
        segTree = new int [size];
        ori = nums;
        construct(0, nums.length-1, 0);
    }

    private int construct(int start, int end, int id) {
        if(start > end) return 0;
        if(start == end) segTree[id] = ori[start];
        else {
            int mid = start + (end - start) / 2;

            int left = construct(start, mid, id*2 + 1);
            int right = construct(mid + 1, end, id*2 + 2);

            segTree[id] = left + right;
        }

        return segTree[id];
    }

    public void update(int i, int val) {
        int diff = val - ori[i];
        ori[i] = val;
        updateRecur(0, ori.length-1, 0, i, diff);
    }

    private void updateRecur(int start, int end, int i, int tar, int diff) {
        if(start > end) return;

        segTree[i] += diff;
        if(start == end) return;
        int mid = start + (end - start) / 2;
        if(tar <= mid)
            updateRecur(start, mid, i * 2 + 1, tar, diff);
        else
            updateRecur(mid+1, end, i*2 + 2, tar, diff);
    }

    public int sumRange(int i, int j) {
        return sumRecur(0, ori.length-1, 0, i, j);
    }

    public int sumRecur(int start, int end, int i, int rl, int rr) {
        if(start > end) return 0;
        if(rr < start || end < rl) return 0;
        if(rl <= start && rr >= end) return segTree[i];
        int mid = start + (end - start) /2;
        return sumRecur(start, mid, i * 2 + 1, rl, rr) + sumRecur(mid+1, end, i*2 + 2, rl, rr);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */