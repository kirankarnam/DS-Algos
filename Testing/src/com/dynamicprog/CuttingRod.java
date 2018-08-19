package com.dynamicprog;

public class CuttingRod {

	public static void main(String[] args) {
		int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
		int n = 8;
		System.out.println(new CuttingRod().cutRod(prices,n));

	}

	
	public int cutRod(int[] prices, int n) {
		if(prices ==null) return 0;
		
		int length = prices.length;
		int[][] result = new int[length+1][n+1];
		
		for(int i=0;i<=length;i++) {
			result[i][0] = 0;
		}
		
		for(int j=0;j<=n;j++) {
			result[0][j] = 0;
		}
		
		for(int i=1;i<length;i++) {
			for(int j=1;j<=n;j++) {
				if(j<i)
					result[i][j] = result[i-1][j];
				else
					result[i][j] = Math.max(result[i-1][j], prices[i-1]+result[i][j-i]);
			}
		}
		
		return result[length-1][n];
	}
}
