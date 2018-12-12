class Solution {
    // a really good question
    // required O(n) time

    // first step: for each bit, traverse the array, is still O(n) time. O(32n) = O(n)
    // second step: this is really tricky one, just like the two sum. If we have a xor target and a set,
    //     we can find whether two num in the set can xor to the target.
    // third step: kind of dp, find the max bit by bit
    // xor : a ^ b = c <=> a = b ^ c <=> b ^ a = c
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for(int i=31; i>=0; i--) {
            int tar = max | 1 << i;
            mask = mask | 1 << i;

            Set<Integer> set = new HashSet<>();
            for(int num : nums) {
                set.add( num & mask);
            }

            // find whether the tar can be fulfill
            for(int a : set) {
                int b = tar ^ a;
                if(set.contains(b)) {
                    max = tar;
                    break;
                }
            }
        }
        return max;
    }
}