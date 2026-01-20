class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rows = matrix.length;
        int cols = matrix[0].length - 1;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][cols]) {
                int low = 0, high = cols;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (matrix[i][mid] == target)
                        return true;
                    else if (matrix[i][mid] > target)
                        high = mid - 1;
                    else
                        low = mid + 1;
                }
            }
        }
        return false;
    }
}