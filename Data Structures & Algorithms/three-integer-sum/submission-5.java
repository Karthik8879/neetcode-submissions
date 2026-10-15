class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            Set<Integer> hs = new HashSet<>();
            for(int j = i+1; j < nums.length; j++) {
                int need = -nums[i]-nums[j];
                if(hs.contains(need)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], need);
                    Collections.sort(temp, (a,b) -> a-b);
                    set.add(temp);
                }
                hs.add(nums[j]);
            }
        }
        return new ArrayList<>(set);
    }
}
