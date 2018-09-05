class Solution {

    // straight forward, but very slow
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        // get status
        int [] status = new int [ratings.length];
        for(int i = 0; i<ratings.length; i++) {
            int left = i == 0 ? Integer.MAX_VALUE : ratings[i-1] ;
            int right = i == ratings.length-1 ? Integer.MAX_VALUE: ratings[i+1];
            int cur = ratings[i];
            int res = 0;
            if(left >= cur) res += 1;
            if(right >= cur) res += 2;
            status[i] = res;
        }
        System.out.println(Arrays.toString(status));

        int[] candy = new int [ratings.length];
        Arrays.fill(candy, -1);
        for(int i=0; i<candy.length; i++) {
            if(status[i] == 3) candy[i] = 1;
            int left = i-1;
            while(left >= 0 && status[left] == 1) {
                candy[left] = candy[left+1] + 1;
                left--;
            }
            int right = i+1;
            while(right < candy.length && status[right] == 2) {
                candy[right] = candy[right-1] + 1;
                right++;
            }
        }

        for(int i=0; i<candy.length; i++) {
            int cur = candy[i];
            if(cur == -1) {
                candy[i] = Math.max(candy[i-1], candy[i+1]) + 1;
            }
        }
        System.out.println(Arrays.toString(candy));
        int res = 0;
        for(int x: candy) {
            res+= x;
        }
        return res;
    }
}