package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class MissingNumbers {
	
	public static void main(String[] args) {
		MissingNumbers mn = new MissingNumbers();
		
		ArrayList<Integer> input = new ArrayList<>();
		input.add(3);
		input.add(4);
		input.add(2);
		
		mn.printMissingNumbers(input);
	}
	
	public void printMissingNumbers(List<Integer> nums) {
		if(nums ==null) return;
		nums.add(0);
		nums.add(0);
		int i=1;
		int length = nums.size();
		while(i<length) {
			int currValue = nums.get(i-1);
			if(currValue !=i && currValue!=0) {
				int temp = nums.get(currValue-1);
				nums.remove(currValue-1);
				nums.add(currValue-1,currValue);
				nums.remove(i-1);
				nums.add(i-1,temp);
			}else {
				i++;
			}
		}
		int j=1;
		for(int num:nums) {
			if(num==0) {
				System.out.println(j);
	
			}
			j++;
		}
	}

}


