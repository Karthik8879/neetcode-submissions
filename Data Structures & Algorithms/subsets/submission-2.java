class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, 0, temp, res);
        return res;
    }

    void backtrack(int[] nums, int start, List<Integer> temp, List<List<Integer>> res) {
        // base case
        // always going to be added on each and every level
        res.add(new ArrayList<>(temp));

        for(int i = start; i < nums.length; i++) {
            // take
            temp.add(nums[i]);
            backtrack(nums, i+1, temp, res);
            // backtracking step
            temp.remove(temp.size()-1);
        }
    }
}
