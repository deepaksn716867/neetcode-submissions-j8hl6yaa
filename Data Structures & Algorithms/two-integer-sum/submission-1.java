class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int indexPos = 0;
        for(int num : nums) {
            indexMap.put(num, indexPos++);
        }
        for(int i = 0; i < nums.length; i++) {
           int diff = target - nums[i];
           if(indexMap.containsKey(diff) && i != indexMap.get(diff)) {
                int mapPos = indexMap.get(diff);
                if(mapPos > i) {
                    return new int[]{i, mapPos};
                }
                return new int[]{mapPos, i};
           }
        }
        return new int[]{-1,-1};
    }
}
