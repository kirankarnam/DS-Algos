package com.arrays;

import java.util.Arrays;

public class ThreeSumClosest {
	
	
	public int closest(int[] num , int target){
		if(num == null || num.length==0) return 0;
		
		int min =  Integer.MAX_VALUE;
		
		int result =  0;
		int length = num.length;
		
		Arrays.sort(num);
		
		for(int i=0;i<length;i++) {
			int j=i+1;
			int k = length-1;
			
			while(j<k) {
				int sum = num[i]+num[j]+num[k];
				int diff = Math.abs(sum-target);
				 if(diff ==0) return sum;
				 
				 if(diff < min) {
					 min = diff;
					 result = sum;
				 }
				 
				 if(sum<=target) {
					 j++;
				 }else {
					 k--;
				 }
				
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		ThreeSumClosest tsc = new ThreeSumClosest();
		
		int [] input = {-1, 2, 1, -4};
		int target = 1;
		
		System.out.println(tsc.closest(input, target));

	}

}
