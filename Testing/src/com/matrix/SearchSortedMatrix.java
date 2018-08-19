package com.matrix;

public class SearchSortedMatrix {

	public static void main(String[] args) {
	    int[][] arr = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
              };

	int r=arr.length;

	int c=arr[0].length;
	
	SearchSortedMatrix ssm = new SearchSortedMatrix();
	System.out.println(ssm.search(arr, r, c, 31));

	}
	
	public boolean search(int[][] arr, int row,int col, int num) {
		
		if(arr == null) return false;
		
		if(row ==0 && col ==0) return false;
		
		int i=0;
		int j = col-1;
		
		while(i<row && j>=0) {
			
			if(arr[i][j] == num)
				return true;
			else if(arr[i][j] > num) {
				j--;
			}else if(arr[i][j]< num) {
				i++;
			}
		}
		return false;
		
	}

}
