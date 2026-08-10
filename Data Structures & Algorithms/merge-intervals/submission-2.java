class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return new int[1][1];
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++) {
            if(!result.isEmpty() && intervals[i][0] <= result.get(result.size() - 1)[1]) {
                int[] last = result.get(result.size() - 1);
                last[1] = Math.max(intervals[i][1], last[1]);
                last[0] = Math.min(intervals[i][0], last[0]);
            } else {
                result.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        return result.toArray(new int[0][]);
    }
}
