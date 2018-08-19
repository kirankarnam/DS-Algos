package com.other;

public class Square {

	public static void main(String[] args) {
		Square sqr = new Square();
		System.out.println(sqr.power(4,2));

	}

	
	public int power(int n,int pow) {
		if(pow !=0)
			return n*power(n,pow-1);
		else
			return 1;
	}
}
