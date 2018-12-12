class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        if(tokens == null || tokens.length == 0) return 0;
        Arrays.sort(tokens);
        int curP = P;
        int max = 0;
        int points = 0;
        int left = 0, right = tokens.length-1;
        while(true) {
            if(curP > tokens[left]) {
                curP -= tokens[left++];
                points++;
                max = Math.max(points, max);
            } else if(points>=1) {
                points--;
                curP += tokens[right--];
            }
            if(left >= right) break;
        }
        return max;
    }
}