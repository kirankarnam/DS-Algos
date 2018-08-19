package com.other;

public class AtoI {
	
	public int atoi(String s) {
		if(s== null) return 0;
		
		int length = s.length();
		
		if(length <1) return 0;
		double result = 0;
		
		char flag = '+';
		
		int i=0;
		if(s.charAt(0) == '-') {
			flag = '-';
			i++;
		}else if(s.charAt(0)=='+') {
			i++;
		}
		
		while(length > i && s.charAt(i) >='0' && s.charAt(i) <='9') {
			result = result*10+(s.charAt(i) -'0');
			i++;
		}
		
		if(flag =='-') {
			result = result *-1;
		}
		
		if(result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		
		if(result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		return (int)result;
	}

	public static void main(String[] args) {
		AtoI ai =new AtoI();
		System.out.println(ai.atoi("-123"));

	}

}
