package com.arrays;

import java.util.Arrays;

public class ProductArray {

	public static void main(String[] args) {
		ProductArray pa = new ProductArray();
		int[] n = {1,2,3,4};
		pa.product(n);

	}
	
	public void product(int[] n) {
		if(n ==null) throw new IllegalArgumentException();
		int length = n.length;
		int [] prod = new int[length];
		
		int temp=1;
		
		Arrays.fill(prod, 1);
		
		for(int i=0;i<length;i++) {
			prod[i] = temp;
			temp = temp*n[i];
		}
		
		for(int result:prod) {
			System.out.print(result +"   ");
		}
		
		temp=1;
		for(int i=length-1;i>=0;i--) {
			prod[i] = prod[i]*temp;
			
			temp = temp*n[i];
		}
		
		for(int result:prod) {
			System.out.print(result +"   ");
		}
		
	}

}
