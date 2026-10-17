class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a,b) -> b - a
        );

        for(int s : stones) {
            maxHeap.offer(s);
        }

        while(maxHeap.size() > 1) {
            if(maxHeap.size() >= 2) {
                int p1 = maxHeap.poll();
                int p2 = maxHeap.poll();
                int val = Math.abs(p1 - p2);
                maxHeap.offer(val);
            }
        }
        if(maxHeap.isEmpty()) {
            return 0;
        } else {
            return maxHeap.peek();
        }
    }
}
