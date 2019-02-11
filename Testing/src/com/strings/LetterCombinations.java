package com.strings;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
	
	private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	public static void main(String[] args) {
		LetterCombinations lc = new LetterCombinations();
		System.out.println(lc.letterCombinations("23"));

	}

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		if(digits.length()==0) return res;
		
		res.add("");
		for(int i=0;i<digits.length();i++) {
			res = combine(KEYS[digits.charAt(i)-'0'],res);
		}
		
		return res;
	}
	
	public List<String> combine(String digit,List<String> res){
		List<String> result = new ArrayList();
		
		for(int i=0;i<digit.length();i++) {
			for(String s:res) {
				result.add(s+digit.charAt(i));
			}
		}
		
		return result;
	}
}
