class Solution {

    class Custom{
        int[] point;
        int distance;
        Custom(int[] point) {
            this.point = point;
            int xCoordinate = point[0];
            int yCoordinate = point[1];
            this.distance = xCoordinate * xCoordinate  + yCoordinate * yCoordinate;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        List<Custom> list = new ArrayList<>();
        // populating the list
        for(int[] point : points) {
            list.add(new Custom(point));
        }

        // sorting the list -> ascending order
        Collections.sort(list, (a,b) -> a.distance - b.distance);

        int[][] result = new int[k][2]; // k rows 2 columns

        for(int i = 0; i < k; i++) {
            result[i][0] = list.get(i).point[0];
            result[i][1] = list.get(i).point[1];
        }

        return result;
    }
}
