class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> wordCount = new HashMap<>();
        for(char c : s.toCharArray()) {
            wordCount.put(c, wordCount.getOrDefault(c, 0) + 1);
        }
        for(char d : t.toCharArray()) {
            if(!wordCount.containsKey(d) || wordCount.get(d) == 0) {
                return false;
            }
            wordCount.put(d, wordCount.get(d) - 1);
        }

        for(Map.Entry<Character, Integer> entry: wordCount.entrySet()) {
            if(wordCount.get(entry.getKey()) > 0) {
                return false;
            }
        }
        return true;
    }
}
