class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        List<Integer> sequenceStart = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(numSet.contains(nums[i] - 1)) {
                continue;
            }
            sequenceStart.add(nums[i]);
        }
        int runningCount = 1;
        int maxSequenceCount = 0;
        int n = 1;
        for(Integer start : sequenceStart) {
            while(numSet.contains(start + n++)) {
                runningCount++;
            }
            maxSequenceCount = Math.max(runningCount, maxSequenceCount);
            runningCount = 1;
            n = 1;
        }
        return maxSequenceCount;
    }
}
