class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        // [1,2,2,3,3,3]
        // 1 -> 1
        // 2 -> 2
        // 3 -> 3
        // descending order soring
        // 3 -> 3
        // 2 -> 2
        // 1 -> 1

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        // 1, 2, 3
        List<Integer> keySet = new ArrayList<>(hm.keySet());

        // 3, 2, 1
        keySet.sort((a,b) -> hm.get(b) - hm.get(a));

        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = keySet.get(i);
        }

        return ans;
    }

    // O(nlogk) - time
    // O(nlongk) - space

    public int[] topKFrequentOptimal(int[] nums, int k) {

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
