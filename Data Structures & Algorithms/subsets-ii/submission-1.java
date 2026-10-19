class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, 0, temp, res);
        return res;
    }

    void backtrack(int[] nums, int start, List<Integer> temp, List<List<Integer>> res) {
        // base case
        // always add it
        if(!res.contains(temp)) {
            res.add(new ArrayList<>(temp));
        }

        for(int i = start; i < nums.length; i++) {
            // not considering the similar case
            // if(i > start && nums[i] == nums[i-1]) continue;
            // take
            temp.add(nums[i]);
            backtrack(nums, i+1, temp, res);
            // backtrack
            temp.remove(temp.size()-1);
        }
    }
}
