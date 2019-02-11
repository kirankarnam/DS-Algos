package com.strings;

import java.util.ArrayList;
import java.util.List;

public class PossibleEncodings {
/**
 * Input: "23"
 *	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        
        if(digits.length()==0) return res;
        
        res.add("");
        
        for(int i=0;i<digits.length();i++){
            res = combine(KEYS[digits.charAt(i)-'0'],res);
        }
        
        return res;
    }
    
    private List<String> combine(String digit,List<String> res){
        List<String> result = new ArrayList<String>();
        
        for(int i=0;i<digit.length();i++){
            for(String x:res){
                result.add(x+digit.charAt(i));
            }
        }
        return result;
    }
}
