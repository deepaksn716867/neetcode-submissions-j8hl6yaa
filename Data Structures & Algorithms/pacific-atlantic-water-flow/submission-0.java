class Solution {
    class Coordinate {
        int row;
        int col;
        Coordinate(int _row, int _col) {
            row = _row;
            col = _col;
        }
    }
    private List<Coordinate> getNeighbors(Coordinate node, int[][] heights) {
        List<Coordinate> neighbors = new ArrayList<Coordinate>();
        int[] delta_row = {-1, 0, 1, 0};
        int[] delta_col = {0, 1, 0, -1};
        for(int i = 0; i < delta_row.length; i++) {
            int cal_row = node.row + delta_row[i];
            int cal_col = node.col + delta_col[i];
            if(cal_row >=0 && cal_row < heights.length &&
               cal_col >=0 && cal_col < heights[0].length) {
                neighbors.add(new Coordinate(cal_row, cal_col));
            }
        }
        return neighbors;
    }

    private void bfs(ArrayDeque<Coordinate> queue, boolean[][] visited, int[][] heights) {
        //null checks and size checks.
        while(queue.size() > 0) {
          Coordinate curr_node = queue.pop();
          visited[curr_node.row][curr_node.col] = true;
          for(Coordinate neighbor : getNeighbors(curr_node, heights)) {
            if(!visited[neighbor.row][neighbor.col] && heights[curr_node.row][curr_node.col] <= heights[neighbor.row][neighbor.col]) {
                queue.add(neighbor);
            }
          }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacificVisited = new boolean[heights.length][heights[0].length];
        boolean[][] atlanticVisited = new boolean[heights.length][heights[0].length];
        ArrayDeque<Coordinate> pacQueue = new ArrayDeque<Coordinate>();
        ArrayDeque<Coordinate> atlQueue = new ArrayDeque<Coordinate>();

        for(int i = 0; i < heights[0].length; i++) {
            pacQueue.add(new Coordinate(0, i));
            atlQueue.add(new Coordinate(heights.length - 1, i));
        }

        for(int j = 0; j < heights.length; j++) {
            pacQueue.add(new Coordinate(j, 0));
            atlQueue.add(new Coordinate(j, heights[0].length - 1));
        }

        bfs(pacQueue, pacificVisited, heights);
        bfs(atlQueue, atlanticVisited, heights);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < heights.length; i++) {
            for(int j = 0; j < heights[0].length; j++) {
                if(pacificVisited[i][j] && atlanticVisited[i][j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
}
