class MedianFinder {
    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        largeHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        smallHeap.offer(num);
        if(!smallHeap.isEmpty() && !largeHeap.isEmpty()) {
            int largeEleOfSmallHeap = smallHeap.peek();
            int smallEleOfLargeHeap = largeHeap.peek();
            if(largeEleOfSmallHeap > smallEleOfLargeHeap) {
                    int ele = smallHeap.poll();
                    largeHeap.offer(ele);
            }
        }
        while(Math.abs(smallHeap.size() - largeHeap.size()) > 1) {
            int smallHeapSize = smallHeap.size();
            int largeHeapSize = largeHeap.size();
            if(smallHeapSize > largeHeapSize) {
                int ele = smallHeap.poll();
                largeHeap.offer(ele);
            } else {
                int ele = largeHeap.poll();
                smallHeap.offer(ele);
            }
        }
    }
    
    public double findMedian() {
        int totalSize = smallHeap.size() + largeHeap.size();
        if(totalSize % 2 == 0) {
            return (double)(smallHeap.peek() + largeHeap.peek()) / 2;
        } 
        if(smallHeap.size() > largeHeap.size()) {
            return smallHeap.peek();
        }
        return largeHeap.peek();
    }
}
