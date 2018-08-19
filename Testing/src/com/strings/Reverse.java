package com.strings;

public class Reverse {

	public static void main(String[] args) {
		System.out.println(new Reverse().reverse("abc"));

	}

	
	public String reverse(String input) {
		if(input ==null) return null;
		
		
		char[] chars = input.toCharArray();
		int length = chars.length-1;
		int i=0;

		while(i<length) {
			char temp = chars[i];
			chars[i] = chars[length];
			chars[length] = temp;
			i++;
			length--;
		}
		return new String(chars);
	}
}
