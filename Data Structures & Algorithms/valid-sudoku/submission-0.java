class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set> rowMap = new HashMap<>();
        Map<Integer, Set> colMap = new HashMap<>();
        Map<String, Set> gridMap = new HashMap<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                if(rowMap.computeIfAbsent(i, a -> new HashSet<Character>()).contains(board[i][j])) {
                    return false;
                } else {
                    rowMap.get(i).add(board[i][j]);
                }

                if(colMap.computeIfAbsent(j, a -> new HashSet<Character>()).contains(board[i][j])) {
                    return false;
                } else {
                    colMap.get(j).add(board[i][j]);
                }
                String gridCords = i / 3 + "," + j / 3;
                if(gridMap.computeIfAbsent(gridCords, a -> new HashSet<Character>()).contains(board[i][j])) {
                    return false;
                } else {
                    gridMap.get(gridCords).add(board[i][j]);
                }
            }
        }
        return true;
    }
}
