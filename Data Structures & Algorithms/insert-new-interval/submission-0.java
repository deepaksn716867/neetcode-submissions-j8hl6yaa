class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = 0, right = intervals.length - 1;
        int target = newInterval[0];
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target < intervals[mid][0]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        List<int[]> intervalsList = new ArrayList<>();
        for(int i = 0; i < left; i++) {
            intervalsList.add(intervals[i]);
        }
        intervalsList.add(newInterval);
        for(int i = left; i < intervals.length; i++) {
            intervalsList.add(intervals[i]);
        }

        List<int[]> result = new ArrayList<>();
        for(int[] interval: intervalsList) {
            if(!result.isEmpty() && interval[0] <= result.get(result.size() - 1)[1]) {
                int[] last = result.get(result.size() - 1);
                last[1] = Math.max(last[1], interval[1]);
            } else {
                result.add(new int[]{interval[0], interval[1]});
            }
        }
        return result.toArray(new int[0][]);
    }
}
