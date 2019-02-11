package com.arrays;

public class SlidingWindowMax {
	
	public static void main(String[] args) {
		SlidingWindowMax swm = new SlidingWindowMax();
		int [] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int [] result = swm.slidingWindowMax(nums, k);
		
		for(int i:result)
			System.out.println(i);
	}
	
	public int[] slidingWindowMax(int[] nums, int k) {
		int length = nums.length;
		if(length ==0)
			return null;
		
		int[] max_left = new int[length];
		int[] max_right = new int[length];
		
		max_left[0] = 0;
		max_right[length-1] = nums[length-1];
		
		for(int i=1;i<length;i++) {
			max_left[i] = (i%k==0)?nums[i]:Math.max(nums[i],max_left[i-1]);

			int j = length-i-1;
			
			max_right[j] = (j%k==0)?nums[j]:Math.max(nums[j], max_right[j+1]);
		}
		
		int [] sliding_max = new int[length-k+1];
		
		//int j=0;
		for(int i=0,j=0;i+k<=length;i++) {
			sliding_max[j++] = Math.max(max_right[i],max_left[i+k-1]); 
		}
		
		return sliding_max;
	}
	

}
