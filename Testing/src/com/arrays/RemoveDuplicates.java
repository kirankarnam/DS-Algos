package com.arrays;

public class RemoveDuplicates {
	
	public int remDup(int[] num) {
		if(num== null || num.length <=1) return 0;
		
		int length = num.length;
		
		int i=0;
		for(int j=1;j<length;j++) {
			
			if(num[i] != num[j]) {
				i++;
				num[i] = num[j];
			}
		}
		return i+1;
	}

	public static void main(String[] args) {
		RemoveDuplicates rd =  new RemoveDuplicates();
		
		int[] input = {1,1,2};
		int[] input2 = {0,0,1,1,1,2,2,3,3,4};
		
		//System.out.println(rd.remDup(input));
		
		System.out.println(rd.remDup(input2));
		
		for(int test: input2) {
			System.out.println(test);
		}

	}

}
