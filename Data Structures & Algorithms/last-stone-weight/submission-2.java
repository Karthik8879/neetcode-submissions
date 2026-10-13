class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int ele : stones) maxHeap.offer(ele);
        while(maxHeap.size() > 1) {
            int ele1 = maxHeap.poll();
            int ele2 = maxHeap.poll();

            int val = ele1 - ele2;
            if(val > 0) {
                maxHeap.offer(val);
            }
        }
        return maxHeap.size() == 0 ? 0 : maxHeap.peek();
    }
}
