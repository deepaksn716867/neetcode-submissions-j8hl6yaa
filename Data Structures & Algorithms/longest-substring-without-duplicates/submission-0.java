class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0; int maxLength = 0;
        Map<Character, Integer> wordCount = new HashMap<>();
        for(int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            wordCount.put(c , wordCount.getOrDefault(c, 0) + 1);
            while(wordCount.get(c) > 1) {
                Character removeChar = s.charAt(left);
                wordCount.put(removeChar , wordCount.getOrDefault(removeChar, 0) - 1);
                left++;
            }
            int currLength = right - left + 1;
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;
    }
}
