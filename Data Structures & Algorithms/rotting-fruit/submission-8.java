class Solution {
    class Coordinate {
        int row;
        int col;
        public Coordinate(int _row, int _col) {
            row = _row;
            col = _col;
        }
    }
    private List<Coordinate> getNeighbor(Coordinate curr_node, int[][] grid) {
        int[] delta_row = {-1, 0, 1, 0};
        int[] delta_col = {0, 1, 0, -1};
        List<Coordinate> neighbors = new ArrayList<Coordinate>();
        for(int i = 0; i < delta_row.length; i++) {
            int cal_row = curr_node.row + delta_row[i];
            int cal_col = curr_node.col + delta_col[i];
            if(cal_row >=0 && cal_row < grid.length &&
            cal_col >= 0 && cal_col < grid[0].length) {
                neighbors.add(new Coordinate(cal_row, cal_col));
            }
        }
        return neighbors;
    }
    
    public int orangesRotting(int[][] grid) {
        int minimumNumberOfMins = 0;
        int fresh = 0;
        List<Coordinate> rottenBananas = new ArrayList<Coordinate>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    rottenBananas.add(new Coordinate(i,j));
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.addAll(rottenBananas);
        //grid[cur_coordinate.row][cur_coordinate.col] = -1;
        int minMinutes = 0;
        while(fresh > 0 && queue.size() > 0) {
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                Coordinate curr_node = queue.pop();
                for(Coordinate neighbor : getNeighbor(curr_node, grid)) {
                    if(grid[neighbor.row][neighbor.col] != 1) {
                        continue;
                    }
                    queue.add(neighbor);
                    grid[neighbor.row][neighbor.col] = 2;
                    fresh--;
                }
            }
            minMinutes++;
        }
        return fresh == 0 ? minMinutes : -1;
    }
}
