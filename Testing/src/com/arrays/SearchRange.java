package com.arrays;

public class SearchRange {

	public static void main(String[] args) {
		SearchRange sr = new SearchRange();
		int [] nums = {5,7,7,7,8,8,10};
		int target = 7;
		int [] result = sr.findRange(nums, target);
		for (int i : result) {
			System.out.print(i);
		}

	}
	
	public int[] findRange(int[] nums, int num) {
		if(nums == null) return null;
		int[] result = {-1,-1};
		 int length = nums.length;
		 int low = 0;
		 result[0] = findLeft(nums,low,length,num);
		 if(result[0]!=-1) {
			 result[1] = findRight(nums,low,length,num);
			 
		 }
		 
		 
		 return result;
	}

	private int findLeft(int[] nums, int low, int high, int num) {
		
		while(low<high) {
			int mid = low+(high-low)/2;
			if(nums[mid]>=num) {
				high = mid;
			}else {
				low = mid+1;
			}
		}
		return (nums[low]==num)?low:-1;
	}

	private int findRight(int[] nums, int low, int high, int num) {
		int result = -1;
		while(low<high) {
			int mid = low+(high-low)/2;
			if(nums[mid] ==num) {
				result = mid;
				low = mid+1;
				
			}
			else if(nums[mid]>num)
				high = mid-1;
			else
				low = mid+1;
				
		}
		return result;
	}

}
