class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int right = ROWS * COLS - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / COLS;
            int col = mid % COLS;
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
