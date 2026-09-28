class Solution {
    public int search(int[] nums, int target) {
        ArrayList<int[]> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            res.add(new int[]{nums[i], i});
        }

        Collections.sort(res, (a, b) -> a[0] - b[0]);
        
        int low = 0, high = res.size()-1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(res.get(mid)[0] == target) {
                return res.get(mid)[1];
            } else if(res.get(mid)[0] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
