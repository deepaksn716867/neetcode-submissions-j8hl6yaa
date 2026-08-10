class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, ((a, b) -> a[0] - b[0]));
        List<int[]> result = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < intervals.length; i++) {
            if(!result.isEmpty() && intervals[i][0] < result.get(result.size() - 1)[1]) {
                count++;
                int[] last = result.get(result.size() - 1);
                if(last[1] > intervals[i][1]) {
                    last[0] = intervals[i][0];
                    last[1] = intervals[i][1];
                }
            } else {
                result.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        return count;
    }
}
