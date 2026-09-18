class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length-1;
        while(low < high) {
            int sum = numbers[low] + numbers[high];
            if(sum == target) {
                return new int[]{low+1, high+1};
            } else if(sum < target) low++;
            else high--;
        }
        return new int[]{-1, -1};
    }


    public int[] twoSum1(int[] numbers, int target) {
        int low = 0, high = numbers.length-1;
        int[] res = new int[2];
        while(low <= high) {
            int sum = numbers[low] + numbers[high];
            if(sum == target) {
                res[0] = low+1;
                res[1] = high+1;
                return res;
            } else if(sum > target) {
                high--;
            } else {
                low++;
            }
        }
        return res;
    }
}
