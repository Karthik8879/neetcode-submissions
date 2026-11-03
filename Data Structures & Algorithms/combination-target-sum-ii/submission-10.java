class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int start = 0;
        int n = candidates.length;
        int sum = 0;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(candidates, start, sum, temp, res, target, n);
        return res;
    }

    void backtrack(int[] candidates, int start, int sum, List<Integer> temp, List<List<Integer>> res, int target, int n) {
        // base case
        if(sum > target) {
            return;
        }

        // base case
        if(sum == target) {
            if(!res.contains(temp)) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        // base case
        if(start == n) {
            return;
        }

        for(int i = start; i < n; i++) {
            if(i > start && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) continue; // optimization step
            // take step
            temp.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, i+1, sum, temp, res, target, n);
            // backtrack case
            sum -= candidates[i];
            temp.remove(temp.size()-1);
        }

        
    }
}
