package com.matrix;

public class PrintSpiral {

	public static void main(String[] args) {
	    int[][] arr = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
              };

	int r=arr.length;

	int c=arr[0].length;
	PrintSpiral ps = new PrintSpiral();
	ps.printSpiral(arr, r, c);

	}
	
	public void printSpiral(int[][] arr, int row,int col) {
		
		if(arr ==null) return;
		
		if(row ==0 && col==0) return;
		
		
		int k=0,l=0;
		
		int last_row = row-1;
		int last_col = col-1;
		
		while(k<=last_row && l <=last_col) {
			
			//print first row
			
			for(int i=l;i<=last_col;i++) {
				System.out.print(arr[k][i] + "  ");
			}
			k++;
			
			//print last_column
			
			for(int i=k;i<=last_row;i++) {
				System.out.print(arr[i][last_col]+ "  ");
			}
			last_col--;
			
			if(k<=last_row) {
				for(int i=last_col;i>=l;i--) {
					System.out.print(arr[last_row][i]+ "  ");
				}
				last_row--;
			}
			
			
			if(l<=last_col) {
				for(int i=last_row;i>=k;i--) {
					System.out.print(arr[i][l]+ "  ");
				}
				l++;
			}
			
		}
	}

}
