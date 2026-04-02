class Solution {
    static class Coordinates {
        int row;
        int col;
        public Coordinates(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static List<Coordinates> getNeigbhors(Coordinates coordinate, char[][] grid) {
        int[] delta_row = {-1, 0, 1, 0};
        int [] delta_col = {0, 1, 0, -1};
        List<Coordinates> neigbhors = new ArrayList<Coordinates>();
        for(int i = 0; i < delta_row.length; i++) {
            int calRow = coordinate.row + delta_row[i];
            int calCol = coordinate.col + delta_col[i];
            if(calRow >=0 && calRow < grid.length &&
              calCol >=0 && calCol < grid[0].length) {
                if(grid[calRow][calCol] == '1') {
                    neigbhors.add(new Coordinates(calRow, calCol));
                }
              }
        }
        return neigbhors;
    }

    /**
    
    **/
    private static void bfs( char[][] grid, Coordinates coordinate) {
        Deque<Coordinates> queue = new ArrayDeque<>();
        queue.add(coordinate);
        while(queue.size() > 0) {
            Coordinates currentCell = queue.pop();
            for(Coordinates getNeigbhor : getNeigbhors(currentCell, grid)) {
                queue.add(getNeigbhor);
                grid[getNeigbhor.row][getNeigbhor.col] = '0';
            }
        }
    }

    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
               if(grid[row][col] == '0') {
                   continue;
               }
                bfs(grid, new Coordinates(row, col));
                numOfIslands++;
            }
        }
        return numOfIslands;
    }
}
