class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for(int i = 0; i < k; i++) {
            maxHeap.add(new int[]{i, nums[i]});
        }
        result.add(maxHeap.peek()[1]);
        int left = 0;
        for(int right = k; right < nums.length; right++) {
            maxHeap.add(new int[]{right, nums[right]});
            left++;
            // int[] element = maxHeap.peek();
            while(!(maxHeap.peek()[0] >=left && maxHeap.peek()[0] <=right)) {
                maxHeap.poll();
            }
            result.add(maxHeap.peek()[1]);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
