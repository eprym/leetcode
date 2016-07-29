public class TicTacToe {

    int[] rows, cols;
    int[][] data;
    int diag = 0, antiDiag = 0;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        data = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rows[row]++;
        cols[col]++;
        data[row][col] = player;
        int n = rows.length;
        if(row == col)  diag++;
        if(row == (n - 1 - col))    antiDiag++;
        if(rows[row] == n && isWin(data, row, player, "row"))   return player;
        if(cols[col] == n && isWin(data, col, player, "col"))   return player;
        if(diag == n && isWin(data, -1, player, "diag"))    return player;
        if(antiDiag == n && isWin(data, -1, player, "antiDiag"))    return player;
        return 0;
    }
    
    private boolean isWin(int[][] data, int index, int player, String flag) {
        switch(flag){
            case "row" : {
                for(int i = 0; i < data.length; i++) {
                    if(data[index][i] != player)    return false;
                }
                return true;
            }
            case "col": {
                for(int i = 0; i < data.length; i++) {
                    if(data[i][index] != player)    return false;
                }
                return true;
            }
            case "diag": {
                for(int i = 0; i < data.length; i++) {
                    if(data[i][i] != player)    return false;
                }
                return true;
            }
            case "antiDiag": {
                for(int i = 0; i<data.length; i++) {
                    if(data[i][data.length - 1 - i] != player)  return false;
                }
                return true;
            }
            default : throw new IllegalArgumentException("Invalid flag");
        }
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
