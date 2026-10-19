class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, 0, temp, res);
        return res;
    }

    void backtrack(int[] nums, int idx, List<Integer> temp, List<List<Integer>> res) {
        // base case --> boundry
        if(idx == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // take
        temp.add(nums[idx]);
        backtrack(nums, idx+1, temp, res);

        // backtrack remove the element
        temp.remove(temp.size()-1);

        // skip
        backtrack(nums, idx+1, temp, res);
    }
}
