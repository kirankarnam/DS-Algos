package com.other;

public class AllSubsets {

	public static void main(String[] args) {
		AllSubsets as = new AllSubsets();
		as.subset("abc");
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

}
