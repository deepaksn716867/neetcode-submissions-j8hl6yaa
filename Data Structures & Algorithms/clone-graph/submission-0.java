class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        queue.add(node);
        Map<Node, Node> clonedGraph = new HashMap<Node, Node>();
        clonedGraph.put(node, new Node(node.val));
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(node.val);
        while(queue.size() > 0) {
            Node curr_node = queue.pop();
            Node clonedNode = clonedGraph.get(curr_node);
            for(Node neighbor : curr_node.neighbors) {
                if(!clonedGraph.containsKey(neighbor)) {
                    clonedGraph.put(neighbor, new Node(neighbor.val));
                }
                clonedNode.neighbors.add(clonedGraph.get(neighbor));
                if(visited.contains(neighbor.val)) {
                    continue;
                }
                queue.add(neighbor);
                visited.add(neighbor.val);
            }
        }
        return clonedGraph.get(node);
    }
}