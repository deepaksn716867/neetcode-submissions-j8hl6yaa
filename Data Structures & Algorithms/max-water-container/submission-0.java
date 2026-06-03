class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int max = Integer.MIN_VALUE;
        while(left < right) {
            int length = (right - left);
            int height = Math.min(heights[left], heights[right]);
            max = Math.max(max, length * height);
            if(heights[left] < heights[right]) {
                left++;
            } else if(heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
