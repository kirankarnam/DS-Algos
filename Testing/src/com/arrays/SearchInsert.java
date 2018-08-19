package com.arrays;

public class SearchInsert {
	
	
	public int search(int[] nums, int k) {
		if(nums == null) return 0;
		
		int length = nums.length;
		
		if(length ==0) return 0;
		
		for(int i=0;i<length;i++) {
			if(nums[i] ==k || nums[i] > k)
				return i;
		}
		return length;
	}

	public static void main(String[] args) {
		SearchInsert si = new SearchInsert();
		
		int[] input1 = new int[] {1,3,5,6};
		System.out.println(si.search(input1, 5));

		

		System.out.println(si.search(input1, 2));
		
		System.out.println(si.search(input1, 7));
		
		System.out.println(si.search(input1, 0));
	}

}
