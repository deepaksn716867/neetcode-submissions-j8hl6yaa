class Solution {

    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for(String eachString: strs) {
            sb.append(eachString.length()).append("#").append(eachString);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while(index < str.length()) {
            int poundIndex = str.indexOf("#", index);
            int len = Integer.parseInt(str.substring(index, poundIndex));
            int startIndex = poundIndex + 1;
            int endIndex = startIndex + len;
            String word = str.substring(startIndex, endIndex);
            result.add(word);
            index = endIndex;
        }
        return result;
    }
}
