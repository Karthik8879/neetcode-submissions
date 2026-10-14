class Solution {
    // bucket sorting
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length+1];

        for(int key : hm.keySet()) {
            int freq = hm.get(key);
            // populating the buckets
            if(buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        int[] res = new int[k];
        int idx = 0;

        for(int i = buckets.length-1; i >= 0; i--) {
            if(buckets[i] != null) {
                for(int ele : buckets[i]) {
                    res[idx] = ele;
                    idx++;
                    if(idx == k) return res;
                }
            }
        }

        return new int[k];
    }
}
