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
        if(intervals == null || intervals.size() <=0) {
            return 0;
        }
        List<int[]> timeLine = new ArrayList<>();
        int maxRooms = 0;
        for(Interval interval: intervals) {
            timeLine.add(new int[]{interval.start, 0});
            timeLine.add(new int[]{interval.end, 1});
        }
        timeLine.sort((a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        int curCount = 0;
        for(int[] time: timeLine) {
            if(time[1] == 0) {
              curCount++;  
            } else {
                curCount--;
            }
            maxRooms = Math.max(maxRooms, curCount);
        }
        return maxRooms;
    }
}
