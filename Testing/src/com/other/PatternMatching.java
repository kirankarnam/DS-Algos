package com.other;

public class PatternMatching {
	
	public boolean isMatch(String text, String pattern) {
		if(pattern.isEmpty()) return text.isEmpty();
		
		//check if the first character matches pattern
		boolean first_match = (!text.isEmpty() && (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0)=='.'));
		
		if(pattern.length() >2 && pattern.charAt(1)=='*') {
			return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
		}else {
			return isMatch(text.substring(1), pattern.substring(1));
		}
	}

	public static void main(String[] args) {
		String text = "aa";
		String pattern = ".*";
		PatternMatching pm = new PatternMatching();
		System.out.println(pm.isMatch(text, pattern));

	}

}
