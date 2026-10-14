class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        int post = 1;
        for(int i = res.length-2; i >= 0; i--) {
            res[i] = res[i] * post * nums[i+1];
            post = post * nums[i+1];
        }

        return res;
    }
}  
