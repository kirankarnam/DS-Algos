package com.matrix;

public class NumOfIslands {

	// use DFS to check if the four neighbors are set and update them to 0
	
	public static void main(String[] args) {
		char[][] mat = {{'1','1','1','1','0'},
		{'1','1','0','1','0'},
		{'1','1','0','0','0'},
		{'0','0','0','0','0'}};
		
		NumOfIslands ni = new NumOfIslands();
		
		System.out.println(ni.numOfIslands(mat));

	}
	
	public int numOfIslands(char[][] mat) {
		if(mat ==null)
			return 0;
		
		int count = 0;
		int rows = mat.length;
		int cols = mat[0].length;
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(mat[i][j] =='1') {
					DFS(mat,i,j);
					count++;
				}
					
			}
		}
		
		return count;
	}

	private void DFS(char[][] mat, int i, int j) {
		if(i < 0 || j < 0 || mat ==null || i >= mat.length || j>=mat[0].length || mat[i][j]=='0')
			return;
		
		mat[i][j] ='0';
		
		DFS(mat,i+1,j);
		DFS(mat,i-1,j);
		DFS(mat,i,j+1);
		DFS(mat,i,j-1);
		
	}

}
