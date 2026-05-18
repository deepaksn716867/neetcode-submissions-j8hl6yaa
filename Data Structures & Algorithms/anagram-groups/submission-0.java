class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroup = new HashMap<>();
        for(String str : strs) {
            int[] wordCount = new int[26];
            for(char c : str.toCharArray()) {
                wordCount[c - 'a']++;
            }
            String key = Arrays.toString(wordCount);
            anagramGroup.computeIfAbsent(key, k -> new ArrayList<String>()).add(str);
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(Map.Entry<String, List<String>> entry : anagramGroup.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
