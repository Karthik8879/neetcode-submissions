class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int prefixSum = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            prefixSum += nums[i];
            if(hm.containsKey(prefixSum - k)) {
                cnt += hm.get(prefixSum - k);
            }
            hm.put(prefixSum, hm.getOrDefault(prefixSum, 0) + 1);
        }
        for(HashMap.Entry<Integer, Integer> entry: hm.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + " " + value);
        }
        return cnt;
    }
}