class KthLargest {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(
        (a,b) -> a - b
    );
    int k;
    int[] nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;

        for(int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > k) minHeap.poll();
        return minHeap.peek();
    }
}
