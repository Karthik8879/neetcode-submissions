class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        // here we don't have a start because we want to have that particular index multiple times
        // if we are moving forward wrt start then we are not going to be visiting it every agian
        // this is like taking exmaple of case where we were havin j loop start from 0 again instead of starting from i
        // where we are going to again visit those ele instead of not visiting those at all
        backtrack(nums, temp, res, visited);
        return res;
    }

    void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> res, boolean[] visited) {
        // base case
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;
            // take
            temp.add(nums[i]);
            visited[i] = true;
            backtrack(nums, temp, res, visited);
            // backtrack
            temp.remove(temp.size()-1);
            visited[i] = false;
        }
    }
}
