class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, 0, temp, res);
        return res;
    }

    void backtrack(int[] nums, int start, List<Integer> temp, List<List<Integer>> res) {
        // base case
        // we are going to make use of a loop based approach so we do not have to care about the case
        // all of the subsets are going to be valid
        res.add(new ArrayList<>(temp));


        for(int i = start; i < nums.length; i++) {
            // take
            temp.add(nums[i]);
            backtrack(nums, i+1, temp, res);
            // remove
            temp.remove(temp.size()-1);
        }
    }
}
