class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int ele : nums) {
            list.add(ele);
        }

        Collections.sort(list, (a,b) -> b - a);

        return list.get(k-1);
    }
}
