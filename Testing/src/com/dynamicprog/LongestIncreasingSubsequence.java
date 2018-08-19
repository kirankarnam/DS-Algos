package com.dynamicprog;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		
		int[] input = { 10, 22, 9, 33, 21, 50, 41, 60 };
		
		System.out.println(lis.lis(input));

	}
	
	public int lis(int[] n) {
		
		if(n==null) return 0;
		
		int length = n.length;
		int[] lis = new int[length];
		
		for(int i=0;i<length;i++)
			lis[i] = 1;
		 
		for(int i=0;i<length;i++) {
			for(int j=0;j<i;j++) {
				if(n[i] > n[j]  &&  lis[i] <lis[j]+1  ) {
					lis[i] = lis[j]+1;
				}
			}
		}
		
		int max = 0;
		
		for(int j=0;j<length;j++) {
			if(max < lis[j])
				max = lis[j];
		}
		
		return max;
	}

}
