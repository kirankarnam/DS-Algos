package com.other;

import java.util.HashSet;

public class SudokuSolver {
	
	public boolean solveSudoku(int [][] board) {
		return solve(board);
	}
	
	public boolean solve(int[][] board) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[i][j] != -1)
					continue;
				
				for(int k=1;k<=9;k++) {
					board[i][j] = k;
					if(isValid(board,i,j) && solve(board))
						return true;
					board[i][j] = -1;
				}
				return false;
			}
		}
		return true;
	}

	private boolean isValid(int [][] board, int i, int j) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int k=0;k<9;k++) {
			if(set.contains(board[i][k]))
				return false;
			
			if(board[i][k] != -1)
				set.add(board[i][k]);
		}
		set.clear();
		for(int k=0;k<9;k++) {
			if(set.contains(board[k][j]))
				return false;
			
			if(board[k][j] != -1)
				set.add(board[k][j]);
		}
		set.clear();
		
		for(int m=0 ;m<3;m++) {
			for(int n=0; n<3; n++){
				int x = i/3*3+m;
				int y = j/3*3+n;
	            if(set.contains(board[x][y]))
	                return false;
	 
	            if(board[x][y]!=-1){
	                set.add(board[x][y]);
			}
			}
			
		}
		return true;
	}

	public static void main(String[] args) {
		SudokuSolver sudoku = new SudokuSolver();
		int[][] grid = {{3, -1, 6, 5, -1, 8, 4, -1, -1},
                {5, 2, -1, -1, -1, -1, -1, -1, -1},
                {-1, 8, 7, -1, -1, -1, -1, 3, 1},
                {-1, -1, 3, -1, 1, -1, -1, 8, -1},
                {9, -1, -1, 8, 6, 3, -1, -1, 5},
                {-1, 5, -1, -1, 9, -1, 6, -1, -1},
                {1, 3, -1, -1, -1, -1, 2, 5, -1},
                {-1, -1, -1, -1, -1, -1, -1, 7, 4},
                {-1, -1, 5, 2, -1, 6, 3, -1, -1}};
		if (sudoku.solveSudoku(grid) == true) {
			
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(grid[i][j]+"   ");
				}
				System.out.println();
			}
			
		}
		else
			System.out.println("No solution exists");

	}

}
