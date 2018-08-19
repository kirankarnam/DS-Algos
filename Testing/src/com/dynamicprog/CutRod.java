package com.dynamicprog;

public class CutRod {

	public static void main(String[] args) {
		int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
		int n = 5;
		System.out.println(cutRod(n,prices));
		

	}
	
	public static int cutRod(int n, int[] prices) {
		int[] result = new int[n+1];
		
		result[0] = 0;
		
		for(int i=1;i<=n;i++) {
			int max = -1;
			for(int j=1;j<=i;j++) {
				int temp = prices[j-1]+result[i-j];
				if(temp > max) {
					max= temp;
				}
			}
			result[i] = max;
		}
		return result[n];
	}
}
