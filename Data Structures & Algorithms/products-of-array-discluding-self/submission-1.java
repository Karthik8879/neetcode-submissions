class Solution {

    public int[] productExceptSelf(int[] nums) {
        int pre = 1;
        int post = 1;
        int n = nums.length;
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1); // filling all of the values as 1;
        for(int i = 0; i < nums.length; i++) {
            ans[i] = pre;
            pre = nums[i] * pre; 
        }

        for(int i = n-1; i >= 0; i--) {
            ans[i] = post * ans[i];
            post = nums[i] * post;
        }

        return ans;
    }

    public int[] productExceptSelfBetter(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int[] suffixSum = new int[nums.length];

        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] * nums[i];
        }

        suffixSum[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i+1] * nums[i];
        }

        int[] res = new int[nums.length];
        int n = nums.length;

        for(int i = 0; i < res.length; i++) {
            int left = (i == 0) ? 1 : prefixSum[i - 1];
            int right = (i == n - 1) ? 1 : suffixSum[i + 1];
            res[i] = left * right;
        }

        return res;
    }

    public int[] productExceptSelfBruteforce(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int p = 1;
            for(int j = 0; j < nums.length; j++) {
                if(i != j) {
                    p *= nums[j];
                    res[i] = p;
                }
            }
        }
        return res;
    }
}  
