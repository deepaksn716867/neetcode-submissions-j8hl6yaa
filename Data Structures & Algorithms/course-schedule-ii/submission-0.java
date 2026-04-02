class Solution {
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
    Map<Integer, Integer> inDegree = new HashMap<Integer, Integer>();
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
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree.get(i) == 0) {
                queue.add(i);
            }
        }

        int[] order = new int[numCourses];
        int insert = 0;
        while(queue.size() > 0) {
            int node = queue.pop();
            order[insert++] = node;
            for(Integer neighbor : adjList.get(node)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if(inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if(insert == numCourses) {
            return order;
        }

        return new int[0];
    }
}
