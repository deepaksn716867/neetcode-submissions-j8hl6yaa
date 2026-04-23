class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int eachStone : stones) {
            maxHeap.offer(eachStone);
        }
        while(maxHeap.size() > 1) {
            int firstStone = maxHeap.poll();
            int secondStone = maxHeap.poll();
            int diff = firstStone - secondStone;
            if(Math.abs(diff) > 0) {
                maxHeap.offer(Math.abs(diff));
            }
        }
        return maxHeap.size() != 0 ? maxHeap.poll() : 0;
    }
}
