class Solution {

    class Custom{
        int[] point;
        int distance;
        Custom(int[] point) {
            this.point = point;
            int x = point[0];
            int y = point[1];
            this.distance = x * x + y * y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Custom> maxHeap = new PriorityQueue<>(
            (a,b) -> b.distance - a.distance
        );

        // Reason behind making use of maxHeap -->
        // Distances:   4,  9, 16, 25
        // we are going to be storing wrt k = 2
        // 4
        // 9 4
        // 9 4
        // 9 4
        // we are going to return 9 and 4
        // so we are going to be removing the elements which is going to come to the top spot always
        // if we woudl have minHeap we would fire min ele which we want to return

        for(int[] point : points) {
            maxHeap.offer(new Custom(point));
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().point;
        }

        return res;
    }
}
