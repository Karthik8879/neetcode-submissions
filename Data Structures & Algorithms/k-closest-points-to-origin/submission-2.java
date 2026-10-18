class Solution {
    class Custom{
        int[] point;
        int distance;
        Custom(int[] point) {
            this.point = point;
            int x = point[0];
            int y = point[1];
            this.distance = x*x + y*y;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Custom> maxHeap = new PriorityQueue<>(
            (a,b) -> b.distance - a.distance
        );

        for(int[] point : points) {
            maxHeap.offer(new Custom(point));
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][k];
        for(int i = 0; i < k; i++) {
            Custom popped = maxHeap.poll();
            res[i] = popped.point;
        }
        return res;
    }
}
