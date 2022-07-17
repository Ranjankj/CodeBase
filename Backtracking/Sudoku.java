//https://leetcode.com/problems/sudoku-solver/

// solution

class Solution {
    
    public void solveSudoku(char[][] board) {
        solve(board,0);
    }
    
    public boolean solve(char [][] board,int cell){
        while (cell < 81 && board[cell / 9][cell%9] != '.') {
            cell++;
        } 
        
		if (cell == 81) return true;
        
		int i = cell / 9, j = cell%9;
		for (char c = '1'; c <= '9'; ++c) {
			if (isValid(board, i, j, c)) {
				board[i][j] = c;
				if (solve(board, cell + 1))
					return true;
				else
					board[i][j] = '.';
			}
		}

		return false;
        
    }
    
    public boolean isValid(char [][]board, int i, int j, char c){
        for (int k = 0; k < 9; ++k) {
            if (board[i][k] == c) return false;
            if (board[k][j] == c) return false;
            if (board[3*(i/3)+k/3][3*(j/3)+k%3] == c) return false;
        }
        return true;
    }
}
