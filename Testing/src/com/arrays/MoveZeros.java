package com.arrays;

public class MoveZeros {
	
	public void moveZero(int[] nums) {
		if(nums == null) return;
		
		int length = nums.length;
		
		if(length ==0) return ;
		int lastNonZeroFoundAt =0;
		
		for(int i=0;i<length;i++) {
			if(nums[i]!=0) {
				nums[lastNonZeroFoundAt++] = nums[i];
			}
		}
		
		for(int i=lastNonZeroFoundAt;i<length;i++) {
			nums[lastNonZeroFoundAt++] = 0;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
