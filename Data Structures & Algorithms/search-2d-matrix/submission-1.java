class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0, high = (n * m) - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int val = matrix[mid/m][mid%m];
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

    public boolean searchMatrix1(int[][] matrix, int target) {
        for(int[] row : matrix) {
            int low = 0, high = row.length-1;
            while(low <= high) {
                int mid = low + (high - low) / 2;
                if(row[mid] == target) {
                    return true;
                } else if(row[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }
}
