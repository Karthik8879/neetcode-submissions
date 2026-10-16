class Solution {

    class Custom{
        int position;
        int speed;
        double time;
        Custom(int position, int speed, int target) {
            this.position = position;
            this.speed = speed;
            this.time = (double) (target - position) / speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Custom[] cars = new Custom[position.length];

        for(int i = 0; i < position.length; i++) {
            cars[i] = new Custom(position[i], speed[i], target);
        }

        // Sorting based on position
        Arrays.sort(cars, (a,b) -> b.position - a.position);

        int fleets = 0;
        double previousTime = 0;

        for(int i = 0; i < position.length; i++) {
            if(cars[i].time > previousTime) {
                fleets++;
                previousTime = cars[i].time;
            }
        }

        return fleets;
    }
}
