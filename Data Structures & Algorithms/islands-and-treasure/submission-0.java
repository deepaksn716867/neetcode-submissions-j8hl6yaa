class Solution {
    private static int dungeon_row_size;
    private static int dungeon_col_size;
    static class Coordinates {
        int row;
        int col;
        public Coordinates(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    private static List<Coordinates> getNeighbors(Coordinates coordinates) {
        List<Coordinates> result = new ArrayList<>();
        if(coordinates == null) {
            return result;
        }
        int[] delta_row = {-1, 0, 1, 0};
        int [] delta_col = {0, 1, 0, -1};
        for(int i = 0; i < delta_row.length; i++) {
            int cal_row = coordinates.row + delta_row[i];
            int cal_col = coordinates.col + delta_col[i];
            if(cal_row >=0 && cal_row < dungeon_row_size &&
              cal_col >=0 && cal_col < dungeon_col_size) {
                result.add(new Coordinates(cal_row, cal_col));
              }
        }
        return result;
    }
    public void islandsAndTreasure(int[][] grid) {
        // WRITE YOUR BRILLIANT CODE HERE
        Solution.dungeon_row_size = grid.length;
        Solution.dungeon_col_size = grid[0].length;
        ArrayDeque<Coordinates> queue = new ArrayDeque<Coordinates>();
        List<Coordinates> exits = new ArrayList<Coordinates>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    exits.add(new Coordinates(i,j));
                }
            }
        }
        queue.addAll(exits);
        while(queue.size() > 0) {
            Coordinates current_ele = queue.pop();
            for(Coordinates neigbhor : getNeighbors(current_ele)) {
                if(grid[neigbhor.row][neigbhor.col] == Integer.MAX_VALUE) {
                    grid[neigbhor.row][neigbhor.col] = grid[current_ele.row][current_ele.col] + 1;
                    queue.add(neigbhor);
                }
            }
        }
        //return grid;
    }
}
