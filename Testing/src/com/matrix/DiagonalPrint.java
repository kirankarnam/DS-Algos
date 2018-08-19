package com.matrix;

public class DiagonalPrint {
	
	public static void main(String args[]) {
		
		DiagonalPrint dp = new DiagonalPrint();
	    int[][] arr = { {1, 2, 3, 4},
	            		{5, 6, 7, 8},
	            		{9, 10, 11, 12},
	            		{13, 14, 15, 16},
	            		{17, 18, 19, 20}
	            	};
	
			int r=arr.length;

			int c=arr[0].length;
			dp.printDiagonal(arr, r, c);
	}


	public void printDiagonal(int[][] a,int r,int c) {
		
		if(a ==null || (r==0 && c==0)) return;
		
		for(int k=0;k<=r-1;k++) {
			int i=k;
			int j=0;
			while(i>=0 && j<c) {
				System.out.print(a[i][j]+" ");
				i = i-1;
				j=j+1;
			}
			System.out.println();
		}
		
		//print the column diagonals
		
		for(int k=1;k<=c-1;k++) {
			int i=r-1;
			int j=k;
			
			while(j < c) {
				System.out.print(a[i][j]+" ");
				i = i-1;
				j=j+1;
			}
			System.out.println();
		}
	}
}
