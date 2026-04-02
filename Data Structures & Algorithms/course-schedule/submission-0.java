class Solution {
    private List<List<Integer>> adjacencyList = new ArrayList<List<Integer>>();
    private Map<Integer, Integer> inDegreeCount = new HashMap<Integer, Integer>();
    private int numOfCourses;
    private void preMap(int[][] prerequisites) {
        for(int i = 0; i < numOfCourses; i++) {
            inDegreeCount.put(i, 0);
            adjacencyList.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            inDegreeCount.put(prerequisites[i][0], inDegreeCount.get(prerequisites[i][0]) + 1);
            adjacencyList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        numOfCourses = numCourses;
        preMap(prerequisites);
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        //inDegreeCount.forEach(eachEntry -> eachEntry.getValue())
        for(Map.Entry<Integer, Integer> entry : inDegreeCount.entrySet()) {
            if(entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        int finish = 0;
        while(!queue.isEmpty()) {
            int node = queue.pop();
            finish++;
            for(Integer neighbor : adjacencyList.get(node)) {
                inDegreeCount.put(neighbor, inDegreeCount.get(neighbor) - 1);
                if(inDegreeCount.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return finish == numOfCourses;
    }
}
