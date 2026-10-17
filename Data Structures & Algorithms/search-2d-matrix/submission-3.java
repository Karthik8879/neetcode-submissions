class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = (matrix.length * matrix[0].length) - 1;
        int m = matrix[0].length;
        int n = matrix.length;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int val = matrix[mid / m][mid % m];
            if(val == target) {
                return true;
            } else if(val < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
