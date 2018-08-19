package com.arrays;

public class BadVersion {

	public static void main(String[] args) {
		BadVersion bv = new BadVersion();
		
		System.out.println(bv.firstBadVersion(8));

	}

	
	public int firstBadVersion(int n) {
		if (n==0) return 0;
		int low = 0;
		int high = n;
		
		
		while(low<high) {
			int mid = (low+high)/2;
			
			if(badVersion(mid)) {
				high = mid;
			}else {
				low =mid+1;
			}
			
		}
		return low;
		
	}
	
	public boolean badVersion(int n) {
		if(n>=4) return true;
		return false;
	}
}
