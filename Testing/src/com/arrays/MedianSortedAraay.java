package com.arrays;

public class MedianSortedAraay {
	public static void main(String args[]) {
		int[] x = {1, 3};
        int[] y = {2};
        MedianSortedAraay msa = new MedianSortedAraay();
        System.out.println(msa.median(x, y));
	}




public double median(int[] a, int [] b) {
	
	if(a ==null && b==null) throw new IllegalArgumentException();
	
	if(a==null) {
		return b[b.length/2];
	}
	
	if(b==null)
		return a[a.length/2];
	
	int aLength = a.length;
	int bLength = b.length;
	
	int low = 0;
	int high = aLength;
	
	while(low<high) {
		int partitionx = (low+high)/2;
		int partitiony = (aLength+bLength+1)/2 - partitionx;
		
		int aLeftMax = a[partitionx-1];
		int aRightMin = a[partitionx];
		
		int bLeftMax = b[partitiony-1];
		int bRightMin = b[partitiony];
		
		if(aLeftMax <=bRightMin && bLeftMax <= aRightMin) {
			if((aLength+bLength)%2 ==0) {
				return (double)(Math.max(aLeftMax, bLeftMax)+Math.min(aRightMin, bRightMin))/2;
			}else
				return Math.max(aLeftMax, bLeftMax);
				
		}else if (aLeftMax > bRightMin)
			high = partitionx-1;
		else
			low = partitionx+1;
	}
	throw new IllegalArgumentException();
	
}
}