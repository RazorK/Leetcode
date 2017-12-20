class Solution {

    // Problem:
    // Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
    // For example,
    // Given the following matrix:
    //
    // [
    //  [ 1, 2, 3 ],
    //  [ 4, 5, 6 ],
    //  [ 7, 8, 9 ]
    // ]
    // You should return [1,2,3,6,9,8,7,4,5].
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0) return result;
        int rowS = 0, rowE =matrix[0].length-1, colS = 0, colE = matrix.length-1;

        // BUG
        //  remember to process the situation rowS==rowE and colS == rowE;
        while(rowS<=rowE && colS<=colE) {
            for(int i=rowS; i<rowE; i++) result.add(matrix[colS][i]);
            for(int i=colS; i<colE; i++) result.add(matrix[i][rowE]);
            if(colS!=colE) {
                for(int i=rowE; i>rowS; i--) result.add(matrix[colE][i]);
            } else {
                result.add(matrix[colS][rowE]);
            }
            if(rowS!=rowE){
                for(int i=colE; i>colS; i--) result.add(matrix[i][rowS]);
            } else {
                result.add(matrix[colE][rowS]);
            }
            if(colS==colE && rowS==rowE) {
                result.remove(result.size()-1);
            }
            rowS++; rowE--; colS++; colE--;
        }
        return result;
    }
}
