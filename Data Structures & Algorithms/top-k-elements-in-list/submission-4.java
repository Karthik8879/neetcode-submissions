class Solution {

    // O(nlogk) - time
    // O(nlongk) - space

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a,b) -> hm.get(a) - hm.get(b)
        );
        
        for(int key : hm.keySet()) {
            heap.add(key);
            if(heap.size() > k) heap.poll();
        }

        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }

        return ans;
    }
}
