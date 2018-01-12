class Solution {
    // The gray code is a binary numeral system where two successive values differ in only one bit.
    //
    // Given a non-negative integer n representing the total number of bits in the
    // code, print the sequence of gray code. A gray code sequence must begin with 0.
    //
    // For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
    //
    // 00 - 0
    // 01 - 1
    // 11 - 3
    // 10 - 2
    // Note:
    // For a given n, a gray code sequence is not uniquely defined.
    //
    // For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
    //
    // For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

    // my first idea is find by summary.. tree idea.
    // if we put grayCode in tree, we can find the idea rule if a node is a right child,
    // it's left child will be 1, or be 0.
    public List<Integer> dfsTry(int n) {
        List<Integer> result = new ArrayList<>();
        if(n==0) {
            result.add(0);
            return result;
        }
        int[] current = new int[n];
        dfs(current, result, n, 0, true);
        return result;
    }

    public void dfs(int [] current, List<Integer> result, int target, int cur, boolean zero) {
        if(cur == target-1) {
            result.add(convert(current));
            return;
        }
        int insert = zero? 0:1;
        current[cur] = insert;
        dfs(current, result, target, cur+1, true);
        current[cur] = (insert + 1)%2;
        dfs(current, result, target, cur+1, false);
    }

    public int convert(int [] array) {
        int result = 0;
        int scale = 1;
        for(int i=array.length - 1; i>=0; i--) {
            result += array[i]*scale;
            scale = scale * 2;
        }
        return result;
    }

    // get from lc..
    // magic idea.
    public List<Integer> grayCode(int n) {
        List<Integer> rs=new ArrayList<Integer>();
        rs.add(0);

        // n loops, every time double the size.
        // NOTE dp idea. gray(s) = gray(s-1) + (add bit 1 in front of backward traverse of gray(s-1)).
        for(int i=0;i<n;i++){
            int size=rs.size();
            // NOTE great idea to loop backward, which avoids influence of the adding from previous loop.
            // NOTE the backward also is required to promise that the connection only change one bit.
            for(int k=size-1;k>=0;k--)
                // rs.get(k) | 1<<i, force the i bit of k to be 1.
                rs.add(rs.get(k) | 1<<i);
        }
        return rs;
    }
}
