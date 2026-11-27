class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int start = 0, end = n*m-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int val = matrix[mid/m][mid%m];
            System.out.println(val);
            if(val == target) {
                return true;
            } else if(val > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }
}
