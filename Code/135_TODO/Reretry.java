class Solution {
    public int candy(int[] ratings) {
        int [] candy  = new int[ratings.length];
        Arrays.fill(candy, 1);

        for(int i=1; i<candy.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                candy[i] = candy[i-1] + 1;
            }
        }

        for(int i = candy.length-2; i>=0; i--) {
            if(ratings[i] > ratings[i+1]) {
                if(candy[i] != 1) {
                    candy[i] = Math.max(candy[i-1], candy[i+1]) + 1;
                } else {
                    candy[i] = candy[i+1] + 1;
                }
            }
        }

        int res = 0;
        for(int x : candy) {
            res += x;
        }
        return res;
    }
}