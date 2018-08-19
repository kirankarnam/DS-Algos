package com.dynamicprog;

public class ClimbNsteps {

	public static void main(String[] args) {
		
		System.out.println(numOfWaysToClimb(5));
	}
	
	/*
	 * complexity is O(n)
	 */
	public static int numOfWaysToClimb(int n) {
		int[] s = new int[n+1];
		if( n==0)  return 0;
			
		s[1] = 1;
		s[2] = 2;
		s[3] = 4;
		
		for (int i=4;i<=n;i++) {
			s[i] = s[i-1]+s[i-2]+s[i-3];
		}
		
		return s[n];
	}

}
