package com.arrays;

public class KthLargest {

	public static void main(String[] args) {
		KthLargest ob = new KthLargest();
        int arr[] = {12, 3, 5, 7, 4, 19, 26};
        int n = arr.length,k = 3;
        System.out.println("K'th smallest element is "+
                           ob.kthLargest(arr, 0, n-1, k));
	}
	
	public int kthLargest(int[] a,int start,int end,int k) {
		
		if(k >0 && k<=end-start+1) {
			
			int pos = randomPartition(a,start,end);
			
			if(pos-start == k-1)
				return a[pos];
			
			if(pos-start > k-1)
				return kthLargest(a,start,pos-1,k);
			else if(pos-start < k-1)
				return kthLargest(a,pos+1,end,k-pos+start-1);
		}
		
		
		return Integer.MAX_VALUE;

	}
	
	private int randomPartition(int[] a, int start,int end) {
		int n = end-start+1;
		int pivot = (int)Math.random()*(n-1);
		swap(a,start+pivot,end);
		return partition(a,start,end);
	}
	
	private void swap(int[] a, int start,int end) {
		int temp = a[end];
		a[end] = a[start];
		a[start] = temp;
	}
	
	private int partition(int[] a,int start,int end) {
		int x = a[end];
		int i=start;
		
		for(int j=1;j<end-1;j++) {
			if(a[j] <= x) {
				swap(a,i,j);
				i++;
			}
		}
		
		swap(a,i,end);
		return i;
	}

}
