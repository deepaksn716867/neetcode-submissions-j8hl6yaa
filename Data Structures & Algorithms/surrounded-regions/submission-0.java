class Solution {
    private int ROWS;
    private int COLS;

    private void capture(int r, int c, char[][] grid) {
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] != 'O') {
            return;
        }
        grid[r][c] = 'T';
        capture(r + 1, c, grid);
        capture(r - 1, c, grid);
        capture(r, c + 1, grid);
        capture(r, c - 1, grid); // fixed
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;

        ROWS = board.length;
        COLS = board[0].length;

        // Left and Right borders
        for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == 'O') {
                capture(r, 0, board);
            }
            if (board[r][COLS - 1] == 'O') {
                capture(r, COLS - 1, board);
            }
        }

        // Top and Bottom borders
        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') {
                capture(0, c, board);
            }
            if (board[ROWS - 1][c] == 'O') {
                capture(ROWS - 1, c, board);
            }
        }

        // Flip surrounded O to X, and T back to O
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}