class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, 0, 0, target, temp, res);
        return res;
    }

    void backtrack(int[] nums, int start, int sum, int target, List<Integer> temp, List<List<Integer>> res) {
        // base cases
        if(sum > target) return;
        if(sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i < nums.length; i++) {
            // take
            temp.add(nums[i]);
            sum += nums[i];
            backtrack(nums, i, sum, target, temp, res);
            // remove sum
            sum -= nums[i];
            temp.remove(temp.size()-1);
        }
    }
}
