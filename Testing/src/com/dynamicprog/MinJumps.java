package com.dynamicprog;

public class MinJumps {

	public static void main(String[] args) {
		int []  arr = {2,1,3,2,3,4,5,1,2,8};
		
		System.out.println(new MinJumps().minJump(arr));

	}
	
	
	public int minJump(int[] n) {
		if(n==null) return 0;
		
		int length = n.length;
		
		int[] result = new int[length];
		
		int [] path = new int[length];
		
		result[0] = 0;
		
		
		for(int i=1;i<length;i++) {
			result[i] = Integer.MAX_VALUE;
			for(int j=0;j<i;j++) {
				
				if(i<=j+n[j]) {
					result[i] = Math.min(result[i],result[j]+1);
				}
			}
		}
		
		return result[length-1];
	}

}
