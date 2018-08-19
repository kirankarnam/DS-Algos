package com.dynamicprog;

public class SubsetSum {

	public static void main(String[] args) {
		int set[] = {3, 34, 4, 12, 5, 2};
		 int sum = 7;
		 System.out.println(new SubsetSum().isSubset(set, sum));
	}
	
	
	public boolean isSubset(int[] n,int sum) {
		
		if(n == null) return false;
		
		int length = n.length;
		
		boolean[][] result = new boolean[length+1][sum+1];
		
		result[0][0] = true;
		
		for(int i=1;i<=sum;i++)
			result[0][i] = false;
		
		for(int i=1;i<=length;i++)
			result[i][0] = true;
		
		for(int i=1;i<=length;i++) {
			for(int j=1;j<=sum;j++) {
				if(j<n[i-1])
					result[i][j] = result[i-1][j];
				
				else
					result[i][j] = result[i-1][j] || result[i-1][j-n[i-1]];
			}
		}
		
		return result[length-1][sum];
	}

}
