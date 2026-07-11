class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int low = i+1;
            int high = nums.length-1;
            while(low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if(sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[low]);
                    temp.add(nums[high]);
                    if(!res.contains(temp)) {
                        res.add(temp);
                    }
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
