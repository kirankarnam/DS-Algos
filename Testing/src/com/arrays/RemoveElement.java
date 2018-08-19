package com.arrays;

public class RemoveElement {
	
	public int removeElement(int[] nums,int k) {
		if(nums == null) throw new IllegalArgumentException();
		
		int length = nums.length;
		
		if(length ==0) throw new IllegalArgumentException(); 
		
		int i=0;
		
		while(i<length) {
			if(nums[i] ==k) {
				nums[i] = nums[length-1];
				length = length-1;
			}else {
				i++;
			}
			
		}
		return length;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
