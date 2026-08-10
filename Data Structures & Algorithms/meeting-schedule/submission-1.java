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
        if(intervals == null || intervals.size() <= 0) {
            return true;
        }
        intervals.sort((a,b) -> a.start - b.start);
        int lastEndTime = Integer.MIN_VALUE;
        for(Interval interval : intervals) {
            if(lastEndTime > 0 && interval.start < lastEndTime) {
                return false;
            } else {
                lastEndTime = interval.end;
            }
        }
        return true;
    }
}
