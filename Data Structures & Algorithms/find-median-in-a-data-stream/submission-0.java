class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap =  new PriorityQueue<>(
        (a,b) -> b - a
    );
        minHeap = new PriorityQueue<>(
        (a,b) -> a - b
    );
    
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        // populate the minHeap wrt maxValue of maxHeap
        minHeap.offer(maxHeap.poll());
        // balance both the heaps
        if(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) {
            // odd case
            return maxHeap.peek();
        } else {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2.0; // even case
        }
    }
}
