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
    public boolean canAttendMeetings(List<Interval> intervals) {
        // base case
        if(intervals.size() <= 1) return true;

        Collections.sort(intervals, (a,b) -> a.end - b.end); // sorting based on end time

        int endTime = intervals.get(0).end;

        for(int i = 1; i < intervals.size(); i++) {
            if(endTime > intervals.get(i).start) {
                return false;
            }
            endTime = intervals.get(i).end;
        }
        return true;
    }
}
