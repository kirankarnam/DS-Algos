package com.arrays;

public class MedianSortedArrays {

	/*
	 * partition the array in such a way that 
	 * every element of the left array is less than every element on right array
	 * Number of elements on each array is same
	 * 
	 * 
	 * If the length is even then median is avg(max(x2,y6),min(x3,y5)
	 * else  max(x2,y6)
	 */
	public double findMedian(int[] a , int[]b) {
		
		if(a.length > b.length) {
			return findMedian(b, a);
		}
		
		
		int x = a.length;
		int y = b.length;
		
		int low =0;
		int high =x;
		
		while(low<=high) {
			int partitionX = (low+high)/2;
			int partitionY = (x+y+1)/2 - partitionX;
			
			int maxLeft1 = (partitionX ==0) ? Integer.MIN_VALUE : a[partitionX -1];
			int minRight1 = (partitionX ==x) ? Integer.MAX_VALUE : a[partitionX];
			
			int maxLeft2 = (partitionY ==0) ? Integer.MIN_VALUE : b[partitionY -1];
			int minRight2 = (partitionY ==y) ? Integer.MAX_VALUE : b[partitionY];
			
			
			
			
			if(maxLeft1 <= minRight2 && maxLeft2 <=minRight1) {
				if((x+y)%2 ==0) {
					return ((double)Math.max(maxLeft1,maxLeft2)+(Math.min(minRight1, minRight2))/2);
				}else {
					return Math.max(maxLeft1, maxLeft2);
				}
			}else if(maxLeft1 > minRight2) {
					high = partitionX -1;
			}else {
				low = partitionX+1;
			}
			
		}
		
		
		throw new IllegalArgumentException();
	}
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1 ==null) return nums2[nums2.length/2];
        if(nums2 == null) return nums1[nums1.length/2];
        
        int x = nums1.length;
        int y = nums2.length;
        
        int low =0;
        int high=x;
        
        while(low <= high){
            
            int partitionX = (low+high)/2;
            int partitionY = (x+y+1)/2 -partitionX;
            
            int maxLeft1 = (partitionX ==0) ? Integer.MIN_VALUE : nums1[partitionX -1];
            int minRight1 = (partitionX ==x) ? Integer.MIN_VALUE : nums1[partitionX];
            
            int maxLeft2 = (partitionY ==0) ? Integer.MIN_VALUE : nums2[partitionY -1];
            int minRight2 = (partitionY ==y) ? Integer.MIN_VALUE : nums2[partitionY];
            
            if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
                if((x+y)%2==0)
                    return ((double)Math.max(maxLeft1,maxLeft2)+(Math.min(minRight1, minRight2))/2);
                else
                    return Math.max(maxLeft1,maxLeft2);
            }else if(maxLeft1 > minRight2){
                high = partitionX-1;
            }else{
                low = partitionX+1;
            }
        }
        return 0;
    }
	public static void main(String[] args) {
		int[] x = {1, 2};
        int[] y = {3,4};
        // 1,3,7,8,9,11,15,18,19,21,25
        MedianSortedArrays msa = new MedianSortedArrays();
        System.out.println(msa.findMedian(x, y));

	}

}
