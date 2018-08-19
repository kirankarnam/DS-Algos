package com.other;

public class ReverseInteger {
	
	public int reverse(int n) {
		if(n==0) return 0;
		int result = 0;
		
		int isNegative = 1;
		
		if(n<0) {
			isNegative=-1;
			n = n*-1;
		}

		
		while(n!=0) {
			int x = n%10;
			n = n/10;
			
			// INT_MIN=	–2147483647 – 1
			// INT_MAX =	2147483647
			
			
			//last digit of Integer Max value is 7 that is why x is compared to 7
			if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE && x >7) )return 0;
			
			if(result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE && x < -8)) return 0;
			result = result*10+x;
		}
		
		return result*isNegative;
	}

	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		
		System.out.println(ri.reverse(120));

	}

}
