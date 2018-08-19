package com.strings;

public class OneEditAway {

	public static void main(String[] args) {
		OneEditAway oe = new OneEditAway();
	    String s1 = "gfg";
	    String s2 = "gf";
	    if(oe.isEditDistanceOne(s1, s2))
	        System.out.print("Yes");
	    else
	        System.out.print("No");

	}
	
	public boolean isEditDistanceOne(String s1, String s2) {
		if(s1==null || s2==null) return false;
		
		int m = s1.length();
		int n = s2.length();
		
		if(Math.abs(m-n) >1) return false;
		
		int count=0;
		int i=0,j=0;
		while(i<m && j<n) {
			if(s1.charAt(i)!=s2.charAt(j)) {
				if(count ==1)return false;
				
				if(m>n)
					i++;
				if(n>m)
					j++;
				else {
					i++;
					j++;
				}
				count++;
			}else {
				i++;
				j++;
			}
			
		}
		
		if(i<m|| j<n)
			count++;
		
		return count==1;
	}

}
