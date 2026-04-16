class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<Integer>();

        for(int num : nums) {
            minHeap.add(num);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        while(minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
