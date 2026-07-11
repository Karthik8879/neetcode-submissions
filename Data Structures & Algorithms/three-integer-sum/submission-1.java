class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int low = i+1;
            int high = nums.length-1;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            while(low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if(sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[low]);
                    temp.add(nums[high]);
                    // if(!res.contains(temp)) {
                        res.add(temp);
                    // }
                    while(low < high && nums[low] == nums[low+1]) low++;
                    while(low < high && nums[high] == nums[high-1]) high--;
                    low++;
                    high--;
                } else if(sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }
}
