import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int max = -1;
        for(int h : houses) {
            int i = Arrays.binarySearch(heaters, h);
            if(i >= 0) max = Math.max(max, 0);
            else {
                i = - i - 1;
                int can1 = i == 0? Integer.MAX_VALUE : h - heaters[i-1];
                int can2 = i == heaters.length ? Integer.MAX_VALUE : heaters[i] - h;
                max = Math.max(max, Math.min(can1, can2));
            }
        }
        return max;
    }
}