package com.btress;

public class NumOfBinarySearchTrees {

	//catalan number  Dynamic programming
	
	/*0=1
	 * 1= 1
	 * 2= result[0]*result[1] +result[1]*result[0]
	 * 
	 * */
	 
	public static void main(String args[]) {
		int n=2;
		System.out.println(numOfTrees(n));
	}

	public static int numOfTrees(int n) {
		if (n==0) return 1;
		int[] result = new int[n+1];
		result[0] = 1;
		result[1] = 1;
		
		
		for(int i=2;i<=n;i++) {
			result[i] = 0;
			for(int j=0;j<i;j++) {
				result[i]+= result[j]*result[i-j-1];
			}
		}
		
		return result[n];
	}
}

