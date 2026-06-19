class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> minStack = new Stack<>();
        int max_height = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++) {
            int lastPopedindex = -1;
            while(!minStack.isEmpty() && heights[i] < minStack.peek()[1]) {
                int[] popedHeight = minStack.pop();
                int width = i - popedHeight[0];
                int area = width * popedHeight[1];
                max_height = Math.max(max_height, area);
                lastPopedindex = popedHeight[0];
            }
            int index = lastPopedindex > -1 ? lastPopedindex : i;
            minStack.push(new int[]{index, heights[i]});
        }
        while(!minStack.isEmpty()) {
            int[] popedHeight = minStack.pop();
            int width = (heights.length) - popedHeight[0];
            int area = width * popedHeight[1];
            max_height = Math.max(max_height, area);
        }
        return max_height;
    }
}
