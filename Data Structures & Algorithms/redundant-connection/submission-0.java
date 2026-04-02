class Solution {
    private List<List<Integer>> adjList = new ArrayList<List<Integer>>();
    private Set<Integer> cycle = new HashSet<Integer>();
    private int cycleStart = -1;
    Set<Integer> visited = new HashSet<Integer>();
    public int[] findRedundantConnection(int[][] edges) {

        for(int i = 0; i <= edges.length; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        dfs(1,-1);
        for(int i = edges.length - 1; i >=0 ; i--) {
            if(cycle.contains(edges[i][0]) && cycle.contains(edges[i][1])) {
                return new int[]{edges[i][0],edges[i][1]};
            }
        }
        return new int[0];
    }

    private boolean dfs(int node, int parent) {
        if(visited.contains(node)) {
            cycleStart = node;
            return true;
        }
        visited.add(node);
        for(int nei : adjList.get(node)) {
            if(nei == parent) {
                continue;
            }
            if(dfs(nei,node)) {
                if(cycleStart != -1) {
                    cycle.add(node);
                } 
                if(cycleStart == node) {
                    // cycle.add(node);
                     cycleStart = -1;
                }
                return true;
            }

        }
        return false;
    }
}
