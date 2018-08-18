class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long x = getArea(A, B, C, D) + getArea(E, F, G, H);
        return x - getOverLap(C, G, A, E) * getOverLap(D, H, B, F);
    }

    public int getOverLap(int high1, int high2, int low1, int low2) {
        int high = Math.min(high1, high2);
        int low = Math.max(low1, low2);
        return Math.max(0, high - low);
    }

    public int getArea(int A, int B, int C, int D) {
        return (C-A) * (D-B);
    }
}
