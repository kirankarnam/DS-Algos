package com.other;

public class Pow {

	public static void main(String[] args) {
		System.out.println(new Pow().pow(2, 3));

	}
	
	public float pow(float x, int y) {
		if(y==0) return 1;
		
		float temp;
		
		temp = pow(x,y/2);
		
		if(y%2==0)
			return temp*temp;
		else {
			if(y>0)
				return x*temp*temp;
			else
				return (temp*temp)/x;
		}
	}

}
