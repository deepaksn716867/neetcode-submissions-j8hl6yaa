class Solution {
    class Coordinate {
        int row;
        int col;
        Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    private List<Coordinate> getNeighbors(Coordinate node, int[][] grid) {
        List<Coordinate> result = new ArrayList<>();
        int row_delta[] = {-1, 0, 1, 0};
        int col_delta[] = {0, 1, 0, -1};
        for(int i = 0; i < row_delta.length; i++) {
            int cal_row = node.row + row_delta[i];
            int cal_col = node.col + col_delta[i];
            if(cal_row >=0 && cal_row < grid.length &&
            cal_col >= 0 && cal_col < grid[0].length) {
                result.add(new Coordinate(cal_row, cal_col));
            }
        }
        return result;
    }
    private int bfs(Coordinate root, int[][] grid) {
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(root);
        grid[root.row][root.col] = 0;
        int area = 1;
        while(queue.size() > 0) {
            Coordinate node = queue.pop();
            for(Coordinate neighbor : getNeighbors(node, grid)) {
                if(grid[neighbor.row][neighbor.col] == 0) {
                    continue;
                }
                queue.add(new Coordinate(neighbor.row, neighbor.col));
                grid[neighbor.row][neighbor.col] = 0;
                area++;
            }
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        //Set<> visited = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int area = bfs(new Coordinate(i , j), grid);
                    maxArea = area > maxArea ? area : maxArea;
                }
            }
        }
        return maxArea;
    }
}
