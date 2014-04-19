
// assume the board is 3 * 3
public boolean hasWon(char[][] board) {
	for (int i = 0; i < 3; i++) {
		// row
		if (board[i][0] != '' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
			reutrn true;
		}
		
		// col
		if (board[0][i] != '' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
			return true; 
		}
	}
	
	// top left to bottom right
	if (board[0][0] != '' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
	
	// bottom left to top right
	if (board[2][0] != '' && board[2][0] == board[1][1] && board[1][1] == board[0][2]) return true;
	
	return false;
}

// N * N
public boolean hasWon(char[][] board) {
	
	// row
	for (int i = 0; i < N; i++) {
		if (board[i][0] == '') continue;
		int j = 1;
		for (j = 1; j < N; j++) {
			if (board[i][j] != board[i][j-1]) {
				break;
			}
		}
		
		if (j == N) return true;
	}
	
	// col
	for (int i = 0; i < N; i++) {
		if (board[0][i] != '') {
			int j = 1;
			for (j = 1; j < N; j++) {
				if (board[j][i] != board[j-1][i]) {
					breal;
				}
			}
			
			if (j == N) return true;
		}
	}
	
	// diag
	if (board[0][0] != '') {
		for (int i = 1; i < N; i++) {
			if (board[i][i] != board[i-1][i-1]) {
				break;
			}
		}
		
		if (i = N) return true;
	}
	
	// rev diag
	if (board[N-1][0] != '') {
		for (int i = 1; i < N; i++) {
			if (board[N-i-1][i] != board[N-i][i-1]) {
				break;
			}
		}
		
		if (i == -1) return true;
	}

	return false;	
}
