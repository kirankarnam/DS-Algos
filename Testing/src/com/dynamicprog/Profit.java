package com.dynamicprog;


//O(n)
public class Profit {

	public static void main(String[] args) {
		int[] arr = {7,1,5,4,6,4};
		int num = 6;
		
		int[] arr2 = {7,5,4,3,3,1};
		int num2 = 6;
		System.out.println(maxProfit(6, arr));
		System.out.println(maxProfit(6, arr2));
	}

	public static int maxProfit(int n, int[] prices) {
		if(n==0) return 0;
		if(prices == null ) return 0;
		
		int[] result = new int[prices.length];
		int min = prices[0];
		result[0] = 0;
		
		for(int i=1;i<prices.length;i++) {
			min = Math.min(min,prices[i]);
			result[i] = Math.max(result[i-1], prices[i]-min);
		}
		
		return result[n-1];
	}
}
