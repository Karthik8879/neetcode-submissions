class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        // [1,2,2,3,3,3]
        // 1 -> 1
        // 2 -> 2
        // 3 -> 3
       
       // 2 heaps -> 1 MinHeap and 2nd MaxHeap
       // MinHeap -> always ascending
       // MaxHeap -> always descending

       // Java -> Advantage
       // PriorityQueue -> Heap --> MinHeap
       // We have a trick by which we can convert minHeap -> maxHeap

    //    keySet.sort((a,b) -> hm.get(b) - hm.get(a))
       

    //    PriorityQueue<Integer> heap = new PriorityQueue<>(
    //     (a,b) -> hm.get(b) - hm.get(a)
    //    );

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

       PriorityQueue<Integer> heap = new PriorityQueue<>(
        (a,b) -> hm.get(a) - hm.get(b)
       );

        // 5 -> 2
        // 4 -> 6
        // 8 -> 1
        // 1 -> 50
        // 3 -> 7

        // find top 3 frequent elements
        

        // // 1st way
        // System.out.println("Key: ");
        // for(int key : hm.keySet()) {
        //     System.out.print(key + " ");
        // }
        // System.out.println("");

        // // 2nd way
        // System.out.println("Value: ");
        // for(int value : hm.values()) {
        //     System.out.print(value + " ");
        // }

        // // 3rd way
        // for(HashMap.Entry<Integer, Integer> entries : hm.entrySet()) {
        //     int key = entries.getKey();
        //     int value = entries.getValue();
        //     System.out.print(key);
        //     System.out.print(value);
        // }

        // 1, 2, 3
        // 1 -> 3
        // 2 -> 5
        // 3 -> 7
        // 4 -> 6
        // final output -> 2, 3 or 3, 2

        // 1, 2, 3

        // heap ->
        // 4, 3
        for(int key : hm.keySet()) {
            heap.add(key);
            if(heap.size() > k) {
                heap.poll();
            }
       }

        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = heap.poll();
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
