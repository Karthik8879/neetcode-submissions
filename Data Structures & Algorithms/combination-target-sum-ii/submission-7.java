class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(candidates, 0, 0, target, temp, res);
        return res;
    }

    void backtrack(int[] candidates, int start, int sum, int target, List<Integer> temp, List<List<Integer>> res) { 
        // base case
        if(sum > target) return;

        if(sum == target) {
            if(!res.contains(temp)) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            // cases of removing duplcates
            if(i > start && candidates[i] == candidates[i-1]) continue;
            // optimization step
            if(candidates[i] > target) continue;
            // take
            temp.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, i+1, sum, target, temp, res);
            sum -= candidates[i];
            temp.remove(temp.size()-1);
        }
    }
}
