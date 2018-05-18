class Solution {
    // Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
    //
    // Note:
    //
    // Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
    //
    // Example 1:
    //
    // Input: [2,2,3,2]
    // Output: 3
    // Example 2:
    //
    // Input: [0,1,0,1,0,1,99]
    // Output: 99
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        for(Map.Entry<Integer, Integer> en: map.entrySet()) {
            if(en.getValue()!=3) return en.getKey();
        }
        return 0;
    }

    // traverse bits solution.
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0; i<32; i++) {
            int temp = 0;
            for(int num : nums){
                if(((num >> i) & 1) == 1)  temp ++;
            }
            if(temp%3 != 0) {
                int x = 1;
                res+= (x << i);
            }
        }
        return res;
    }

    //incredible
    public int fromLC(int[] nums) {
        int one = 0, two = 0;
        for (int i : nums) {
            one = (one ^ i) & ~two;
            two = (two ^ i) & ~one;
        }
        return one;
    }
}
