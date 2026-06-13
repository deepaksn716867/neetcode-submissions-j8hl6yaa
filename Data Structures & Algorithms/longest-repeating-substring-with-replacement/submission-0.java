class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxSubLen = Integer.MIN_VALUE;
        Map<Character, Integer> window = new HashMap<>();
        for(int right = 0; right < s.length(); right++) {
           window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
           while(((right - left + 1) - maxFreqCount(window)) > k) {
                Character c = s.charAt(left);
                if(window.get(c) > 1) {
                    window.put(c, window.get(c) - 1);
                } else {
                    window.remove(c);
                }
                left++;
            }
           int currLen = right - left + 1;
           maxSubLen = Math.max(currLen, maxSubLen);
        }
        return maxSubLen;
    }

    private int maxFreqCount(Map<Character, Integer> freqCount) {
        int maxCount = Integer.MIN_VALUE;
        for(Integer count : freqCount.values()) {
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
