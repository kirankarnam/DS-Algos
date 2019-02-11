package com.arrays;

import java.util.Arrays;

public class ProductArray {

	public static void main(String[] args) {
		ProductArray pa = new ProductArray();
		int[] n = {1,2,3,4};
		int[] res = pa.product(n);
		for(int i:res)
			System.out.println(i);
	}
	
	/**
	 * 
	 * @param nums
	 * @return
	 * 
	 * for right res[i] = rightMul
	 * for left res[i] = res[i]*leftMul;
	 */
	public int[] product(int[] nums) {
		int length = nums.length;
		
		int [] res = new int[length];
		int leftMul=1,rightMul=1;
		
		for(int i=length-1;i>=0;i--) {
			res[i]=rightMul;
			rightMul = rightMul*nums[i];
		}
		
		for(int j=0;j<length;j++) {
			res[j] = res[j]*leftMul;
			leftMul = leftMul*nums[j];
		}
		return res;
	}

}
