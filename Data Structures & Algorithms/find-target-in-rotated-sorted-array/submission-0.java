class Solution {
    public int search(int[] nums, int target) {
        ArrayList<int[]> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            res.add(new int[]{nums[i], i});
        }
        Collections.sort(res, (a, b) -> a[0] - b[0]);
        for(int i = 0; i < res.size(); i++) {
            if(res.get(i)[0] == target) {
                return res.get(i)[1];
            }
        }
        return -1;
    }
}
