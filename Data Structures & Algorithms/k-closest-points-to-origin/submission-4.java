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
        List<Custom> list = new ArrayList<>();

        for(int[] point : points) {
            list.add(new Custom(point));
        }
        
        Collections.sort(list, (a,b) -> a.distance - b.distance);

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            res[i] = list.get(i).point;
        }
        return res;
    }
}
