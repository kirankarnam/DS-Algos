package com.arrays;

public class ContainerWithMostWater {

	/**
    1) In the first step we are checking if the size  of the array is zero then return 0(i.e if there are no container then there cannot be maxArea) .
2) Using two pointer(meaning moving from both the directions) first intialize left pointer =0i.e(starting point) and right pointer to  height.length-1;
3) then until (left<right) calculate the area between every two container.
4) Doing (right-left) as right>left i.e(left =0, right = height.length-1)
5) if the left pointer value is smaller than right pointer value then increment the left pointer to move from both the directions which reduces the complexity.
6) other decrement right pointer and finally return maxArea;
    **/
	
	public static void main(String[] args) {
		ContainerWithMostWater csw = new ContainerWithMostWater();
		int [] input = {1,8,6,2,5,4,8,3,7};
		System.out.println(csw.maxArea(input));
	}
	
	 public int maxArea(int[] height) {
		 if(height ==null) return 0;
		 
		 int left = 0,right=height.length-1;
		 int maxArea = 0;
		 
		 while(left<right) {
			 int area = (right-left)*Math.min(height[left], height[right]);
			 maxArea = Math.max(area, maxArea);
			 
			 if(height[left]<height[right])
				 left++;
			 else
				 right--;
		 }
		 
		 return maxArea;
	 }

}
