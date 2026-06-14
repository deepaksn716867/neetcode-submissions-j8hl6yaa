class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> firstStrcharacterCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(Character c : s1.toCharArray()) {
            firstStrcharacterCount.put(c, firstStrcharacterCount.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < s1.length(); i++) {
            window.put(s2.charAt(i), window.getOrDefault(s2.charAt(i), 0) + 1);
        }
        
        if(isPermutation(firstStrcharacterCount, window)) {
            return true;
        }

        int left = 0; 
        for(int right = s1.length(); right < s2.length(); right++) {
            Character c = s2.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            Character leftChar = s2.charAt(left);
            if(window.get(leftChar) > 1) {
                window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
            } else {
                window.remove(leftChar);
            }

            if(isPermutation(firstStrcharacterCount, window)) {
                return true;
            }
            left++;
        }
        return false;
    }

    private boolean isPermutation(Map<Character, Integer> firstString, Map<Character, Integer> secondString) {
        for(Map.Entry<Character, Integer> entry : firstString.entrySet()) {
            if(secondString.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
