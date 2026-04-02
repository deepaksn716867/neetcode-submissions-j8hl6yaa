class Solution {
    private void dfs(int node, int parent, List<List<Integer>> adjList, Set<Integer> visited) {
        if(visited.contains(node)) {
            return;
        }
        visited.add(node);
        for(Integer neighbor : adjList.get(node)) {
            if(visited.contains(neighbor) || neighbor == parent) {
                continue;
            }
            dfs(neighbor, node, adjList, visited);
        }
    }
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> visited = new HashSet<Integer>();
        int connected = 0;
        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                connected++;
                dfs(i, -1, adjList, visited);
            }
        }
        return connected;
    }
}
