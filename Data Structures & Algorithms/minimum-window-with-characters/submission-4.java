class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> tCharacterCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(int j = 0; j < t.length(); j++) {
            tCharacterCount.put(t.charAt(j), tCharacterCount.getOrDefault(t.charAt(j), 0) + 1);
        }
        
        int have = 0;
        int need = tCharacterCount.size();
        int resLen = Integer.MAX_VALUE;
        int[] res = new int[2];

        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if(tCharacterCount.containsKey(c)) {
                if(tCharacterCount.get(c).equals(window.get(c))) {
                    have++;
                }
            }
            
            while(have == need) {
                if(resLen > (right - left + 1)) {
                    resLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }
                Character removeChar = s.charAt(left);
                window.put(removeChar, window.get(removeChar) - 1);
                if(tCharacterCount.containsKey(removeChar)) {
                    if(window.getOrDefault(removeChar, 0) < tCharacterCount.get(removeChar)) {
                        have--;
                    }
                }
                left++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}