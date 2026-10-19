/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<int[]> events = new ArrayList<>();
        for(Interval interval : intervals) {
            events.add(new int[]{interval.start, 1});
            events.add(new int[]{interval.end, -1});
        }

        Collections.sort(events, (a,b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1]; // here we are simulating case where we are having start wrt end and we want to show overlap so we are having to do this
            }
            return a[0] - b[0];
            }
        );

        int maxOverlap = 0;
        int overlap = 0;
        for(int[] event : events) {
            overlap += event[1];
            maxOverlap = Math.max(maxOverlap, overlap);
        }

        return maxOverlap;
    }
}
