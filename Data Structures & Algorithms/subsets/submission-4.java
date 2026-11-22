class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int idx = 0;
        backtrack(nums, idx, n, res, temp);
        return res;
    }

    void backtrack(int[] nums, int idx, int n, List<List<Integer>> res, List<Integer> temp) {
        res.add(new ArrayList<>(temp));

        for(int i = idx; i < n; i++) {
            // take step
            temp.add(nums[i]);
            // call backtrack
            backtrack(nums, i+1, n, res, temp);
            // remove step
            temp.remove(temp.size()-1);
        }
    }
}
