package com.other;

public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sqrt sqrt = new Sqrt();
		System.out.println(sqrt.sqrt(9));

	}

	
	public float sqrt(int n) {
		
		float x = n;
		float y=1;
		
		double e =0.00001;
		
		while(x-y >e) {
			x = (x+y)/2;
			y = n/x;
		}
		return x;
	}
}
