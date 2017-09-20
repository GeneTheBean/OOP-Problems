public class Sodoku {
	
	public boolean solve(char[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col] == '_') {
					for (int k = 1; k <= 9; k++) {
						board[row][col] = (char) ('0' + k);
						
						if (isValid(board, row, col) && solve(board)) 
							return true;
						else 
							board[row][col] = '_';
						
					}
					return false;
				}
			}
		}
		return true;
	}
	
	//checks row, column and grid
	public boolean isValid(char[][] board, int row, int col) {
		//check row
		boolean[] r = new boolean[9];
		for (int i = 0; i < 9; i++) {
			if (board[row][i] >= '1' && board[row][i] <= '9') {
				if (r[board[row][i] - '1'] == false) 
					r[board[row][i] - '1'] = true;
				
				else 
					return false;
			}
		}

		boolean[] c = new boolean[9];
		for (int i = 0; i < 9; i++) {
			if (board[i][col] >= '1' && board[i][col] <= '9') {
				if (c[board[i][col] - '1'] == false) 
					c[board[i][col] - '1'] = true;
				
				else 
					return false;
			}
		}	

		boolean[] grid = new boolean[9];
		for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
			for (int j = (col / 3) * 3; j < (col / 3) * 3 + 3; j++) {
				if (board[i][j] >= '1' && board[i][j] <= '9') {
					if (grid[board[i][j] - '1'] == false) 
						grid[board[i][j] - '1'] = true;
					
					else 
						return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Sodoku  s = new Sodoku ();
		char[][] board = {{'5', '3', '_', '_', '7', '_', '_', '_', '_'},
						  {'6', '_', '_', '1', '9', '5', '_', '_', '_'},
						  {'_', '9', '8', '_', '_', '_', '_', '6', '_'},
						  {'8', '_', '_', '_', '6', '_', '_', '_', '3'},
						  {'4', '_', '_', '8', '_', '_', '_', '_', '1'},
						  {'7', '_', '_', '_', '2', '_', '_', '_', '6'},
						  {'_', '_', '_', '_', '_', '_', '_', '_', '_'},
						  {'_', '_', '_', '_', '_', '_', '_', '_', '_'},
						  {'_', '_', '_', '_', '_', '_', '_', '_', '_'}};
    
    	s.solve(board);
    	
    	for(int i = 0;i < 9;i++){
    		for(int j = 0;j < 9;j++)
    			System.out.print(board[i][j] + " ");
    		System.out.println();
    	}
	}
}