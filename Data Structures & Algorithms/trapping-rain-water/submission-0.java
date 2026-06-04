class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        //min(max(l), max(r)) - h[i]
        int left = 0, right = height.length - 1;
        int maxLeft = height[left], maxRight = height[right], result = 0;
        while(left < right) {
            if (maxLeft < maxRight) {
                left++;
                result += maxLeft - height[left] >= 0 ? maxLeft - height[left] : 0;
                maxLeft = Math.max(maxLeft, height[left]);
            } else {
                right--;
                result += maxRight - height[right] >= 0 ? maxRight - height[right] : 0;
                maxRight = Math.max(maxRight, height[right]);
            }
        }
        return result;
    }
}
