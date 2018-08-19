package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public List<List<Integer>> sum(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums ==null || nums.length <3) return result;
		
		Arrays.sort(nums);
		
		int length = nums.length;
		for(int i=0; i<length-2;i++) {
			if(i==0 || nums[i] > nums[i-1]) {
				int j= i+1;
				int k = length-1;
				
				while(j<k) {
					if(nums[i]+nums[j]+nums[k]==0) {
						List<Integer> l =  new ArrayList<Integer>();
						l.add(nums[i]);
						l.add(nums[j]);
						l.add(nums[k]);
						result.add(l);
						
						
						j++;
						k--;
						
						//check for duplicates
						
						while(j<k && nums[j] == nums[j-1])
							j++;
						
						while(j<k && nums[k] == nums[k+1])
							k--;
						
					}else if(nums[i]+nums[j]+nums[k] >0) {
						k--;
					}else
						j++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ThreeSum ts = new ThreeSum();
		
		int[] input = {-1,-1,-1,1};
		
		List<List<Integer>> result = ts.sum(input);
		
		for(List<Integer> list : result) {
			for(Integer value :list) {
				System.out.print(value +"    ");
			}
			System.out.println();
		}
	}

}
