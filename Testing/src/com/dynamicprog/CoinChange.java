package com.dynamicprog;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		int coins[] = {1, 2, 5};
		CoinChange cc = new CoinChange();
		int coins2[] = {2, 3, 5, 6};
		int n=10;
		
		int V = 11;
		System.out.println(cc.count(coins2, n));
		
		System.out.println(cc.change_min(coins2, V));
		
		//System.out.println(cc.change(coins2, n));


	}
	
	public int change_min(int[] coins, int n) {
		if(n ==0) return 1;
		if(coins == null) return 0;
		
		int length = coins.length;
		
		int max = n+1;
		
		int[] result = new int[n+1];
		
		Arrays.fill(result, max);  
		result[0] = 0;
		
		for(int i=1;i<=n;i++) {
			for (int j=0;j<length;j++) {
				if(coins[j]<=i) {
					result[i] = Math.min(result[i], result[i - coins[j]] + 1);
				}
			}
		}
		
		return result[n] > n ? -1 : result[n];

	}

	
	public int change(int[] coins, int n) {
		if(coins ==null) return 0;
		
		int length = coins.length;
		
		int[] result = new int[n+1];
		
		result[0]=1;
		
		for(int i=0;i<length;i++) {
			for (int j=coins[i];j<=n;j++) {
				result[j] = result[j]+ result[j-coins[i]];
			}
		}
		
		return result[n];
	}
	
	public  int count( int S[], int n )
	{
	    // table[i] will be storing the number of solutions for
	    // value i. We need n+1 rows as the table is constructed
	    // in bottom up manner using the base case (n = 0)
	    int table[]=new int[n+1];
	 
	    // Base case (If given value is 0)
	    table[0] = 1;
	    int length = S.length;
	 
	    // Pick all coins one by one and update the table[] values
	    // after the index greater than or equal to the value of the
	    // picked coin
	    for(int i=0; i<length; i++)
	        for(int j=S[i]; j<=n; j++)
	            table[j] += table[j-S[i]];
	 
	    return table[n];
	}
}
