class Solution {

    private boolean dfs(Integer node, int parent, List<List<Integer>> adjList, Set<Integer> visited) {
        if(visited.contains(node)) {
            return false;
        }
        visited.add(node);
        for(Integer neighbor: adjList.get(node)) {
            if(neighbor == parent) {
                continue;
            }
            if(!dfs(neighbor, node, adjList, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n -1) {
            return false;
        }
        if(edges.length <= 1) {
            return true;
        }
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
            
        }

        Set<Integer> visited = new HashSet<Integer>();
        boolean isValid = dfs(edges[0][0], -1, adjList, visited);
        return isValid && visited.size() == n;
    }
}
