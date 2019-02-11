package com.other;

import java.util.Stack;

/**
 * 
 * @author kkarnam
 * Make use of two pointers left and right when a left paranthesis is encountered increase the left counter and with right increase 
 * the right counter when left becomes equal to right we calculate the length of the current valid string and keep track of the max counter
 * 
 *  when right becomes greater than we reset left and right to 0
 *  
 *  next traverse the string from right to left and apply the same procedure
 *  
 */
public class ValidParanthesis {
	
	public int longestValidParanthesis(String s) {
		int max_length = 0;
		
		if(s== null) return 0;
		
		int left = 0; int right=0;
		int length = s.length();
		
		for (int i=0;i<length;i++) {
			if(s.charAt(i)=='(') {
				left ++;
			}else {
				right++;
			}
			
			if(left == right) {
				max_length = Math.max(max_length, 2*right);
			}else if(right >= left) {
				left = right = 0;
			}
		}
		left = right = 0;
		for (int i=length-1;i>0;i--) {
			if(s.charAt(i)=='(') {
				left ++;
			}else {
				right++;
			}
			
			if(left == right) {
				max_length = Math.max(max_length, 2*left);
			}else if(left >= right) {
				left = right = 0;
			}
		}
		return max_length;
	}
	
	public boolean isValid(String str) {
		
		Stack<Character> s = new Stack<>();
		for (Character c : str.toCharArray()) {
			if (c == '(')
				s.push(')');
			else if (c == '[')
				s.push(']');
			else if (c == '{')
				s.push('}');
			else if (s.isEmpty() || s.pop() != c)
				return false;

		}

		return s.isEmpty();
	}

	public static void main(String[] args) {
		ValidParanthesis vp = new ValidParanthesis();
		
		System.out.println(vp.longestValidParanthesis("))(("));

	}

}
