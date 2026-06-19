class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max_k = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++) {
            max_k = Math.max(max_k, piles[i]);
        }
        int left = 0;
        int right = max_k;
        int k = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(feasible(piles, mid, h)) {
                k = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return k;
    }
    private boolean feasible(int[] piles, int value, int target) {
        int completion_time = 0;
        for(int i = 0; i < piles.length; i++) {
            if(piles[i] <= value) {
                completion_time++;
            } else {
                completion_time+=  Math.ceil((double) piles[i] / value);
            }
        }
        return completion_time <= target;
    }
}
