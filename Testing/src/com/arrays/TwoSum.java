package com.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

	
	
	/*public int[] sum(int[] input,int sum) {
		if(input == null) return null;
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		int length = input.length;
		for(int i=0;i<length;i++) {
			int complement = sum-input[i];
			if(result.containsKey(complement)) {
				return new int[] {result.get(complement),i};
			}
			result.put(input[i], i);
		}
		throw new IllegalArgumentException("No 2 Sum solution found");
	}*/
	
	
	public int[] sum(int[] input, int sum) {
		
		if(input ==null) return null;
		
		Map<Integer,Integer> complementMap = new HashMap<Integer, Integer>();
		
		int length = input.length;
		
		for(int i=0;i<length;i++) {
			int complement = sum-input[i];
			if(complementMap.containsKey(complement)) {
				return new int[] { complementMap.get(complement),i};
			}
			complementMap.put(input[i], i);
		}
		
		throw new IllegalArgumentException("no 2 sum solution found");
	}
	
	public void test() {
		List<Integer> result = new ArrayList<>();
		
		int[] arr = new int[result.size()];

		for(int i = 0; i < result.size(); i++) {
		    if (result.get(i) != null) {
		        arr[i] = result.get(i);
		    }
		}
	}
	
	
	
	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		int[] input = {2, 7, 11, 15};
		int sum = 9;
		
		int[] result = ts.sum(input, sum);
		for (int i : result) {
			System.out.println(i);
		}

	}

}
