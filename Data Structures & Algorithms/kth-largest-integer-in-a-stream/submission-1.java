class KthLargest {
    int k;
    PriorityQueue<Integer> minHeap; // initializing minHeap

    // constructor
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for(int n : nums) {
            add(n);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}