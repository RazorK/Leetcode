class Solution {
    // my basic idea:
    // for each pixel, it shoule be totate with 3 other pixel using one another temp integer
    // just repeat this for half height * (width-1)

    // pay attention here, different process for even and odd length

    public void rotate(int[][] matrix) {
        int n = matrix.length -1;
        int half = n%2==0? n/2:(n/2)+1;
        int oneHalf = n%2==0? half:half+1;
        for(int i=0; i<oneHalf; i++) {
            for(int j=0; j<half; j++) {
                rotateOne(matrix, i, j);
            }
        }
    }

    public void rotateOne(int [][] matrix, int width, int height) {
        int n = matrix.length-1;
        int temp = matrix[height][width];
        matrix[height][width] = matrix[n - width][height];
        matrix[n-width][height] = matrix[n-height][n - width];
        matrix[n-height][n - width] = matrix[width][n-height];
        matrix[width][n-height] = temp;
    }

    // how they did this
    // basically no difference
    public void faster(int[][] matrix) {
        int n = matrix.length;

        for(int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n - layer - 1;
            for(int i=first; i < last; i++){
                int offset = i - first;
                int temp = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = temp;
            }
        }

    }
}
