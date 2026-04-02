class Solution {
    Map<String, List<String>> adjList;
    
    private List<String> getNeighbors(String node) {
        List<String> neighbors = new ArrayList<>();
        for(int i = 0; i < node.length(); i++) {
            String wildCardWord = node.substring(0, i) + "*" + node.substring(i + 1);
            if(adjList.containsKey(wildCardWord)) {
                neighbors.addAll(adjList.get(wildCardWord));
            }
        }
        return neighbors;
    }

    private Map<String, List<String>> buildAdjList(String startWord, List<String> wordList) {
        adjList = new HashMap<>();
        List<String> fullWordList = new ArrayList<String>();
        fullWordList.add(startWord);
        fullWordList.addAll(wordList);
        for(String word : fullWordList) {
            for(int i = 0; i < word.length(); i++) {
                String wildCardWord = word.substring(0, i) + "*" + word.substring(i + 1);
                //for(String eachWord : fullWordList) {
                    //String wordListWildCard = eachWord.substring(0, i) + "*" + eachWord.substring(i + 1);
                    //if(wildCardWord.equals(wordListWildCard)) {
                        adjList.computeIfAbsent(wildCardWord, k -> new ArrayList<>()).add(word);
                    //}
                //}
            }
        }
        return adjList;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean endWordExists = false;
        for(String word : wordList) {
            if(word.equals(endWord)) {
                endWordExists = true;
                break;
            }
        }
        if(!endWordExists) {
            return 0;
        }
        Map<String, List<String>> adjList = buildAdjList(beginWord, wordList);
        Queue<String> queue = new ArrayDeque<String>();
        Set<String> visited = new HashSet<String>();
        queue.add(beginWord);
        visited.add(beginWord);
        int distance = 1;
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                String node = queue.poll();
                for(String nei : getNeighbors(node)) {
                    if(nei.equals(endWord)) {
                        return distance + 1;
                    }
                    if(visited.contains(nei)) {
                        continue;
                    }
                    queue.add(nei);
                    visited.add(nei);
                }
            }
            distance++;
        }
        return 0;
    }
}
