package com.arrays;

public class DutchNationalFlag {

	public static void main(String[] args) {
		
		DutchNationalFlag dnf = new DutchNationalFlag();
		
		int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		int[] result = dnf.sort012(arr);
		for(int i:result) {
			System.out.print(i);
		}

	}
	
	public int[] sort012(int[] arr) {
		if(arr == null) return null;
		
		int length = arr.length;
		
		if(length==0) return null;
		
		
		int low=0,mid=0;
		int high = length-1;
		while(mid<=high) {
			
			switch(arr[mid]) {
			
			case 0 :
				swap(arr,low,mid);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(arr,mid,high);
				high--;
				break;
			}
		}
		return arr;
	}
	
	private void swap(int[] arr, int a1,int a2) {
		int temp = arr[a1];
		arr[a1] = arr[a2];
		arr[a2] = temp;
		
	}

}
