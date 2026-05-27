class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqCount = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            freqCount.put(nums[i], freqCount.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();  // Pre-initialize every slot
        }

        for(Map.Entry<Integer, Integer> entry: freqCount.entrySet()) {
            bucket[entry.getValue() - 1].add(entry.getKey());
        }
        
        int count = 0;
        int[] result = new int[k];
        for(int i = bucket.length - 1; i >= 0 && count < k ; i--) {
            for(Integer ele: bucket[i])
                result[count++] = ele;
        }

        return result;
    }
}
