class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
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
