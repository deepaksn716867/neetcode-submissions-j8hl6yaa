class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0; int maxLength = 0;
        Set<Character> window = new HashSet<>();
        for(int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            while(window.contains(c)) {
                Character removeChar = s.charAt(left);
                window.remove(removeChar);
                left++;
            }
            window.add(c);
            int currLength = right - left + 1;
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;
    }
}
