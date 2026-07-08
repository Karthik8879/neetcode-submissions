class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> keySet = new ArrayList<>(hm.keySet());
        // sorting
        keySet.sort((a, b) -> hm.get(b) - hm.get(a)); // sorting in descending order

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = keySet.get(i);
        }
        return res;
    }
}
