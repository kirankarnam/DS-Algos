package com.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsets {

	public static void main(String[] args) {
		AllSubsets as = new AllSubsets();
		as.subset("abc");
		int[] input =new int[] {1,2};
		System.out.println(as.subsets(input));
	}
	
	
	public void subset(String s) {
		if(s ==null ) return;
		
		subset(s,0,"");
	}
	
	public void subset(String s,int index,String curr) {
		
		int length = s.length();
		
		if(index == length) {
			System.out.println(curr);
			return;
		}
		subset(s,index+1,curr+s.charAt(index));
		subset(s,index+1,curr);
		
	}
	
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    private void backTrack(List<List<Integer>> res,List<Integer> tempList,int[] nums, int start){
    	System.out.println(tempList);
        res.add(new ArrayList<>(tempList));
        for(int i=start;i<nums.length;i++){
            tempList.add(nums[i]);
            backTrack(res,tempList,nums,i+1);
            tempList.remove(tempList.size() - 1);
        }
    }

}
