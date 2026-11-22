class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int start = 0;
        backtrack(nums, start, n, res, temp);
        return res;
    }

    void backtrack(int[] nums, int start, int n, List<List<Integer>> res, List<Integer> temp) {

        for(int i = start; i < n; i++) {
            // take step
            temp.add(nums[i]); // temp = [1,2,3], res = []
            // call backtrack
            backtrack(nums, i+1, n, res, temp); 
            // remove step
            temp.remove(temp.size()-1);
        }
        res.add(new ArrayList<>(temp));
    }
}
