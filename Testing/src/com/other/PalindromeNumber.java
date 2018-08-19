package com.other;

public class PalindromeNumber {

	
	public boolean isPalindrome(int num) {
		if(num ==0) return true;
		
		if(num < 0) return false;
		
		if(num%10 ==0 && num!=0) return false;
		
		int result = 0;
		
		while(num > result) {
			int x = num %10;
			
			num = num /10;
			
			result = result*10 +x ;
			
		}
		
		return num == result || num ==result/10;
	}
	public static void main(String[] args) {
		PalindromeNumber pn = new PalindromeNumber();
		
		System.out.println(pn.isPalindrome(121));
		
		System.out.println(pn.isPalindrome(123));
		
		System.out.println(pn.isPalindrome(0));

	}

}
