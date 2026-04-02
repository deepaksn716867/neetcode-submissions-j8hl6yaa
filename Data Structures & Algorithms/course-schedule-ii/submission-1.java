class Solution {
    private List<List<Integer>> adjList = new ArrayList<List<Integer>>();
    private Map<Integer, Integer> inDegree = new HashMap<Integer, Integer>();

    private void buildGraph(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            inDegree.put(prerequisites[i][0], inDegree.get(prerequisites[i][0]) + 1);
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        buildGraph(numCourses, prerequisites);
        Queue<Integer> queue = new LinkedList<Integer>();
        for(Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        int count = 0;
        int[] order = new int[numCourses];
        while(queue.size() > 0) {
            int curr_node = queue.poll();
            order[count++] = curr_node;
            for(Integer nei : adjList.get(curr_node)) {
                inDegree.put(nei, inDegree.get(nei) - 1);
                if(inDegree.get(nei) == 0) {
                    queue.add(nei);
                }
            }
        }

        if(count == numCourses) {
            return order;
        }

        return new int[0];
    }
}
