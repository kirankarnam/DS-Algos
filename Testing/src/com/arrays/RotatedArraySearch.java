package com.arrays;

public class RotatedArraySearch {
	
	/**
	 * O(log n)
	 * @param num
	 * @param target
	 * @return
	 */
	public int search(int[] num, int target) {
		if(num == null || num.length ==0) return -1;
		
		int length = num.length;
		
		return search (num,0,length,target);
	}

	private int search(int[] num, int start, int end, int target) {
		
		if(end < start ) return -1;
		
		int mid = (start+end)/2;
		
		if(target == num[mid]) return mid;
		
		//check if the left side is sorted
		if(num[start] <= num[mid]) {
			if(target >= num[start] && target <= num[mid])
				return search(num,start,mid-1,target);
			
			return search(num,mid+1,end,target);
		}
		
		//check on the right side of mid
		if(target > num[mid] && target < num[end])
			return search(num,mid+1,end,target);
		
		return search(num,start,mid-1,target);
	}

	public static void main(String[] args) {
		RotatedArraySearch ra =  new RotatedArraySearch();
		
		int[] input= {4,5,6,7,0,1,2};
		int target = 0;
		
		System.out.println(ra.search(input, target));
		

	}

}
